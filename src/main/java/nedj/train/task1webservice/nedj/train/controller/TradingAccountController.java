package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.*;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object createAccount(@RequestBody TradingAccount tradingAccount){

        return  this.tradingAccountService.createAccount(tradingAccount);
    }



    @RequestMapping(value = "/account-balance/{tradingAccountID}", method = RequestMethod.GET)
    public Object accountBalanceObject(@PathVariable int tradingAccountID){

        return this.tradingAccountService.accountBalanceObject(tradingAccountID);
    }

    @RequestMapping(value = "/accounts-list", method = RequestMethod.GET)
    public Object getTradingAccountsResponse(){

        return this.tradingAccountService.getTradingAccountsObject();
    }


    @RequestMapping(value = "/create-list-account", method = RequestMethod.POST)
    public String createAccountsFromList(@RequestBody List<TradingAccount> tradingAccounts){

        return this.tradingAccountService.createAccountsFromList(tradingAccounts);
    }

    @RequestMapping(value = "/find-one/{tradingAccountID}", method = RequestMethod.GET)
    public Object findOne(@PathVariable int tradingAccountID){

        return this.tradingAccountService.findOne(tradingAccountID);
    }


}
