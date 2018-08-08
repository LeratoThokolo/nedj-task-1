package nedj.train.task1webservice.nedj.train.service;

import nedj.train.task1webservice.nedj.train.model.*;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.net.UnknownHostException;
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

    public String createAccountsFromList(List<TradingAccount> tradingAccounts){

        String response = "Accounts created successfully!!";

        List<TradingAccount> tradingAccountsToPersist = new ArrayList<>();

        if(tradingAccounts.isEmpty()){

            response = "List is empty!!";

        }else if(!tradingAccounts.isEmpty()){

            for(int x = 0; x < tradingAccounts.size(); x++){

               //Validating objects
                if(tradingAccounts.get(x).getUserName().equals("") || tradingAccounts.get(x).getInitialTradeAmount() == 0){

                    response = "Invalid list of trading account:Perhaps some trading account values are null?";

                    break;

                }


                tradingAccountsToPersist.add(tradingAccounts.get(x));

            }

            // Check if the list is valid
            if(tradingAccountsToPersist.size() == tradingAccounts.size()){

               for(int i = 0; i < tradingAccountsToPersist.size(); i++){

                   this.tradingAccountRepository.save(tradingAccountsToPersist.get(i));
               }

            }


        }


        return response;
    }


    public BalanceResponse accountBalance(int tradingAccountID) {

       BalanceResponse balanceResponse = new BalanceResponse("The trading account for id: " + tradingAccountID + " doesn't exist!!");


       try{


           if(this.tradingAccountRepository.getOne(tradingAccountID) != null){

               balanceResponse.setResponse("Balance brought forward for trading account id:" + tradingAccountID);
               balanceResponse.setTradingAccountBalance(this.tradingAccountRepository.getOne(tradingAccountID).getInitialTradeAmount());
           }
       } catch (EntityNotFoundException enfe){

          return new BalanceResponse("The trading account for id:" + tradingAccountID + " doesn't exist!!");

       }
        return balanceResponse;
    }


}
