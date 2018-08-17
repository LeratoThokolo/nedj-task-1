package nedj.train.task1webservice.nedj.train.service;

import nedj.train.task1webservice.nedj.train.model.entity.TradingAccount;
import nedj.train.task1webservice.nedj.train.model.pojo.TradingAccountPojo;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TradingAccountService {

    @Autowired
    private TradingAccountRepository tradingAccountRepository;


    public String createAccount(TradingAccountPojo tradingAccountPojo){


        if(tradingAccountPojo.getInitialTradeAmount() != 0 && TradingAccountService.isNull(tradingAccountPojo)){

            TradingAccount tradingAccount = new TradingAccount();
            tradingAccount.setInitialTradeAmount(tradingAccountPojo.getInitialTradeAmount());
            tradingAccount.setTradingAccountID(tradingAccountPojo.getTradingAccountID());
            tradingAccount.setUserName(tradingAccountPojo.getUserName());

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



    public TradingAccount getTradingAccount(int tradingAccountID){

        return this.tradingAccountRepository.getOne(tradingAccountID);

    }

    public double accountBalance(int tradingAccountID){

        return this.tradingAccountRepository.getOne(tradingAccountID).getInitialTradeAmount();
    }

    public TradingAccountPojo updateTradingAccount(TradingAccountPojo tradingAccountPojo){



        if(tradingAccountPojo.getTradingAccountID() !=  0 && tradingAccountPojo.getInitialTradeAmount() != 0 && TradingAccountService.isNull(tradingAccountPojo)){


                this.createAccount(tradingAccountPojo);

        }

       return tradingAccountPojo;
    }

    public static boolean isNull(TradingAccountPojo tradingAccountPojo){


        return !tradingAccountPojo.getUserName().equals("");
    }


}
