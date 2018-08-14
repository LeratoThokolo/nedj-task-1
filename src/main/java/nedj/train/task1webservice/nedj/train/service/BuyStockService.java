package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.BuyStock;
import nedj.train.task1webservice.nedj.train.model.Stock;
import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.repository.BuyStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Service
public class BuyStockService {


    @Autowired
    private BuyStockRepository buyStockRepository;

    @Autowired
    private TradingAccountService tradingAccountService;


    public String buyStock(BuyStock buyStock) throws Exception {

        String response = "Stock bought successfully!!";


        //Object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Url api to fetch stock based on a symbol
       try {


           String urlApi = "https://api.iextrading.com/1.0/stock/" + buyStock.getSymbol() + "/quote";
           URL url = new URL(urlApi);
           //Converting json into pojo
           Stock stock = objectMapper.readValue(url, Stock.class);


           //Trading account to trade
           TradingAccount tradingAccount = null;

           //Validating the trading account to buy stock
           for (int x = 0; x < this.tradingAccountService.getTradingAccounts().size(); x++){

               if(this.tradingAccountService.getTradingAccounts().get(x).getTradingAccountID() == buyStock.getTradingAccountID() &&
                       this.tradingAccountService.getTradingAccounts().get(x).getInitialTradeAmount() >= buyStock.getRandValueAmount()){

                   tradingAccount = this.tradingAccountService.getTradingAccounts().get(x);

               }
           }

           //Throwing exceptions
           if(!stock.getSymbol().equals(" ") && tradingAccount.getInitialTradeAmount() > 0){

               //Keeping track of stock bought and trading accounts used to buy stock
               this.buyStockRepository.save(buyStock);


               //Updating trading account balance
               double updateBalance = tradingAccount.getInitialTradeAmount() - buyStock.getRandValueAmount();


               //Update or deduct from the trading account

               tradingAccount.setTradingAccountID(buyStock.getTradingAccountID());
               tradingAccount.setUserName(tradingAccount.getUserName());
               tradingAccount.setInitialTradeAmount(updateBalance);

               this.tradingAccountService.updateTradingAccount(tradingAccount);

           }

       }catch (MalformedURLException me){

           response = "Invalid url!!";

       }catch (NullPointerException ne){

           response = "Supply valid trading account details!!";

       }catch (FileNotFoundException fnfe){

           response = "Unknown symbol, please supply a valid symbol!!";
       }
       catch (UnknownHostException uhe){

           response = "No internet connection!!";
       }


        return response;
    }
}
