package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.entity.TradingAccount;
import nedj.train.task1webservice.nedj.train.model.pojo.TradingAccountPojo;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/trading-account")
public class TradingAccountController {

    @Autowired
    private TradingAccountService tradingAccountService;


    @Autowired
    private TradingAccountRepository tradingAccountRepository;


    @PostMapping(value = "/create-account")
    public String createAccount(@RequestBody TradingAccountPojo tradingAccountPojo){

        return this.tradingAccountService.createAccount(tradingAccountPojo);
    }


    @GetMapping(value = "/account-balance/{tradingAccountID}")
    public double accountBalance(@PathVariable int tradingAccountID){

       return this.tradingAccountService.accountBalance(tradingAccountID);
    }

    @GetMapping(value = "/accounts-list")
    public Object getTradingAccountsResponse(){

        return this.tradingAccountService.getTradingAccountsObject();
    }


    @PostMapping(value = "/create-list-account")
    public String createAccountsFromList(@RequestBody List<TradingAccount> tradingAccounts){

        return this.tradingAccountService.createAccountsFromList(tradingAccounts);
    }

    @PostMapping(value = "/create-list-trading-account")
    public ResponseEntity<String> createListOfAccounts(@RequestBody List<TradingAccount> tradingAccounts){

        return new ResponseEntity<>(this.tradingAccountService.createAccountsFromList(tradingAccounts), HttpStatus.OK);
    }



    @PutMapping(value = "/update-account")
    public TradingAccount updateTradingAccount(@RequestBody TradingAccountPojo tradingAccountPojo){

        return this.tradingAccountService.updateTradingAccount(tradingAccountPojo);
    }

    @GetMapping(value = "/get-one/{tradingAccountID}")
    public TradingAccount getTradingAccount(@PathVariable int tradingAccountID){

       return this.tradingAccountService.getTradingAccount(tradingAccountID);
    }


    @GetMapping(value = "/get-by-username/{userName}")
    public TradingAccount getTradingAccountByUsername(@PathVariable String userName){

        TradingAccount tradingAccount = this.tradingAccountService.getTradingAccountByUsername(userName);

        if(tradingAccount.getUserName() == null){

            throw new EntityNotFoundException("Trading account with name " + userName + " doesn't exist");
        }

        return tradingAccount;

    }


}
