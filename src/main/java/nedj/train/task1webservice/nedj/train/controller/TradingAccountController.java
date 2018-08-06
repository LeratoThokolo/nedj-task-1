package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/trading-account")
public class TradingAccountController {

    @Autowired
    private TradingAccountService tradingAccountService;


    @RequestMapping(value = "create-account", method = RequestMethod.POST)
    public TradingAccount createAccount(@RequestBody TradingAccount tradingAccount){

        return  this.tradingAccountService.createAccount(tradingAccount);

    }


    @RequestMapping(value = "/get-account-balance/{tradingAccountID}", method = RequestMethod.GET)
    public double accountBalance(@PathVariable int tradingAccountID){

        return this.tradingAccountService.accountBalance(tradingAccountID);
    }

    @RequestMapping(value = "/accounts-list", method = RequestMethod.GET)
    public List<TradingAccount> getTradingAccounts(){

        return this.tradingAccountService.getTradingAccounts();
    }



}
