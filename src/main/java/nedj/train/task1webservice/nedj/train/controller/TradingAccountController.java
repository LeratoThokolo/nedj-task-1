package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
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


    @Autowired
    private TradingAccountRepository tradingAccountRepository;



    @RequestMapping(value = "create-account", method = RequestMethod.POST)
    public TradingAccount createAccount(@RequestBody TradingAccount tradingAccount) throws Exception {

        if(tradingAccount == null){

            throw new Exception("Trading account is empty!!");

        }

        return  this.tradingAccountService.createAccount(tradingAccount);

    }


    @RequestMapping(value = "/get-account-balance/{tradingAccountID}", method = RequestMethod.GET)
    public double accountBalance(@PathVariable int tradingAccountID) throws Exception {

        if(this.tradingAccountRepository.getOne(tradingAccountID) == null){

            throw new Exception("No record for that identifier");
        }

        return this.tradingAccountService.accountBalance(tradingAccountID);
    }

    @RequestMapping(value = "/accounts-list", method = RequestMethod.GET)
    public List<TradingAccount> getTradingAccounts() throws Exception {

        if(this.tradingAccountService.getTradingAccounts().size() == 0){

            throw new Exception("No trading accounts");

        }

        return this.tradingAccountService.getTradingAccounts();
    }


}
