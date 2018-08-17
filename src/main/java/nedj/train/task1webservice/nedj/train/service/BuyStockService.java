package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.entity.BuyStock;
import nedj.train.task1webservice.nedj.train.model.entity.Stock;
import nedj.train.task1webservice.nedj.train.model.entity.TradingAccount;
import nedj.train.task1webservice.nedj.train.model.pojo.BuyStockPojo;
import nedj.train.task1webservice.nedj.train.model.pojo.TradingAccountPojo;
import nedj.train.task1webservice.nedj.train.repository.BuyStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class BuyStockService {


    @Autowired
    private BuyStockRepository buyStockRepository;

    @Autowired
    private TradingAccountService tradingAccountService;


    public String buyStock(BuyStockPojo buyStockPojo) throws IOException {

        String response = "Stock not bought!!";


        //Object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Url api to fetch stock based on a symbol


           String urlApi = "https://api.iextrading.com/1.0/stock/" + buyStockPojo.getSymbol() + "/quote";
           URL url = new URL(urlApi);
           //Converting json into pojo
           Stock stock = objectMapper.readValue(url, Stock.class);


           //Trading account to trade
            TradingAccount tradingAccount = new TradingAccount();

           //Validating the trading account to buy stock
           for (int x = 0; x < this.tradingAccountService.getTradingAccounts().size(); x++){

               if(this.tradingAccountService.getTradingAccounts().get(x).getTradingAccountID() == buyStockPojo.getTradingAccountID() &&
                       this.tradingAccountService.getTradingAccounts().get(x).getInitialTradeAmount() >= buyStockPojo.getRandValueAmount()){

                    tradingAccount = this.tradingAccountService.getTradingAccounts().get(x);

               }
           }

           //Throwing exceptions
           if(!stock.getSymbol().equals("") && tradingAccount.getInitialTradeAmount() != 0 && buyStockPojo.getRandValueAmount() > 0){


               BuyStock buyStock = new BuyStock();
               buyStock.setBuyStockID(buyStockPojo.getBuyStockID());
               buyStock.setRandValueAmount(buyStockPojo.getRandValueAmount());
               buyStock.setSymbol(buyStockPojo.getSymbol());
               buyStock.setTradingAccountID(buyStockPojo.getTradingAccountID());
               //Keeping track of stock bought and trading accounts used to buy stock
               this.buyStockRepository.save(buyStock);

               response = "Stock bought successfully!!";


               //Updating trading account balance
               double updateBalance = tradingAccount.getInitialTradeAmount() - buyStock.getRandValueAmount();


               //Update or deduct from the trading account

               tradingAccount.setTradingAccountID(buyStock.getTradingAccountID());
               tradingAccount.setUserName(tradingAccount.getUserName());
               tradingAccount.setInitialTradeAmount(updateBalance);

               TradingAccountPojo tradingAccountPojo = new TradingAccountPojo();
               tradingAccountPojo.setInitialTradeAmount(tradingAccount.getInitialTradeAmount());
               tradingAccountPojo.setUserName(tradingAccount.getUserName());
               tradingAccountPojo.setTradingAccountID(tradingAccount.getTradingAccountID());

               this.tradingAccountService.updateTradingAccount(tradingAccountPojo);

           }



        return response;
    }

    public List<BuyStock> stocksBought(){

        return this.buyStockRepository.findAll();
    }
}
