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


    public Object createAccount(TradingAccount tradingAccount){


        if(tradingAccount.getInitialTradeAmount() != 0 && !tradingAccount.getUserName().equals("")){

            this.tradingAccountRepository.save(tradingAccount);

            return "Trading account created successfully!!";

        }

        return "Couldn't create trading account, please validate trading account details!!";
    }

    public List<TradingAccount> getTradingAccounts(){

        return this.tradingAccountRepository.findAll();
    }

    public Object getTradingAccountsObject(){

        if(!this.tradingAccountRepository.findAll().isEmpty()){

            return this.tradingAccountRepository.findAll();
        }else {

            return "List is empty!!";
        }

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



    public Object accountBalanceObject(int tradingAccountID){

        double balance = 0.0;


        try{

            if(this.tradingAccountRepository.getOne(tradingAccountID) != null){

                balance = this.tradingAccountRepository.getOne(tradingAccountID).getInitialTradeAmount();
            }

        }catch (EntityNotFoundException enfe){

           return "Balance for trading account id:" + tradingAccountID + " doesn't exist!!";
        }

        return balance;
    }


}
