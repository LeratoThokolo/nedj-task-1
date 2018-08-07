package nedj.train.task1webservice.nedj.train.service;

import nedj.train.task1webservice.nedj.train.model.BalanceResponse;
import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.model.TradingAccountListResponse;
import nedj.train.task1webservice.nedj.train.model.TradingAccountResponse;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class TradingAccountService {

    @Autowired
    private TradingAccountRepository tradingAccountRepository;


    public TradingAccountResponse createAccount(TradingAccount tradingAccount){

        TradingAccountResponse tradingAccountResponse = new TradingAccountResponse("Couldn't create trading account, please validate your trading account details!!");

        if(tradingAccount.getInitialTradeAmount() != 0 && !tradingAccount.getUserName().equals("")){

            tradingAccountResponse.setResponse("Trading account created successfully!!");
            tradingAccountResponse.setTradingAccount(tradingAccount);

            this.tradingAccountRepository.save(tradingAccount);

        }

        return tradingAccountResponse;
    }

    public List<TradingAccount> getTradingAccounts(){

        return this.tradingAccountRepository.findAll();
    }

    public TradingAccountListResponse getTradingAccountsResponse(){

        TradingAccountListResponse tradingAccountListResponse = new TradingAccountListResponse(
                new ArrayList<TradingAccount>(), "List is empty!!");

        if(!this.tradingAccountRepository.findAll().isEmpty()){

            tradingAccountListResponse.setResponse("Trading accounts found successfully!!");
            tradingAccountListResponse.setTradingAccounts(this.tradingAccountRepository.findAll());

        }
        return tradingAccountListResponse;
    }



    public BalanceResponse accountBalance(int tradingAccountID){

       BalanceResponse balanceResponse = new BalanceResponse("The trading account for id: " + tradingAccountID + " doesn't exist!!");

       try{


           if(this.tradingAccountRepository.getOne(tradingAccountID) != null){

               balanceResponse.setResponse("Balance brought forward for trading account id:" + tradingAccountID);
               balanceResponse.setTradingAccountBalance(this.tradingAccountRepository.getOne(tradingAccountID).getInitialTradeAmount());
           }
       }catch (EntityNotFoundException enfe){

          return new BalanceResponse("The trading account for id: " + tradingAccountID + " doesn't exist!!");
       }

       return balanceResponse;
    }


}
