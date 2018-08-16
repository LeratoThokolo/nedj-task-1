package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.*;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trading-account")
public class TradingAccountController {

    @Autowired
    private TradingAccountService tradingAccountService;


    @Autowired
    private TradingAccountRepository tradingAccountRepository;



    @RequestMapping(value = "create-account", method = RequestMethod.POST)
    public String createAccount(@RequestBody TradingAccount tradingAccount){

        return  this.tradingAccountService.createAccount(tradingAccount);
    }



    @RequestMapping(value = "/account-balance/{tradingAccountID}", method = RequestMethod.GET)
    public double accountBalance(@PathVariable int tradingAccountID){

       return this.tradingAccountService.accountBalance(tradingAccountID);
    }

    @RequestMapping(value = "/accounts-list", method = RequestMethod.GET)
    public Object getTradingAccountsResponse(){

        return this.tradingAccountService.getTradingAccountsObject();
    }


    @RequestMapping(value = "/create-list-account", method = RequestMethod.POST)
    public String createAccountsFromList(@RequestBody List<TradingAccount> tradingAccounts){

        return this.tradingAccountService.createAccountsFromList(tradingAccounts);
    }

    @RequestMapping(value = "/create-list-trading-account", method = RequestMethod.POST)
    public ResponseEntity<String> createListOfAccounts(@RequestBody List<TradingAccount> tradingAccounts){

        return new ResponseEntity<String>(this.tradingAccountService.createAccountsFromList(tradingAccounts), HttpStatus.OK);
    }



    @RequestMapping(value = "/update-account", method = RequestMethod.PUT)
    public TradingAccount updateTradingAccount(@RequestBody TradingAccount tradingAccount){

        return this.tradingAccountService.updateTradingAccount(tradingAccount);
    }

    @RequestMapping(value = "/get-one/{tradingAccountID}", method = RequestMethod.GET)
    public TradingAccount getTradingAccount(@PathVariable int tradingAccountID){

       return this.tradingAccountService.getTradingAccount(tradingAccountID);
    }

}
