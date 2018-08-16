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




    @PostMapping(value = "/create-account")
    public String createAccount(@RequestBody TradingAccount tradingAccount){

        return  this.tradingAccountService.createAccount(tradingAccount);
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
    public TradingAccount updateTradingAccount(@RequestBody TradingAccount tradingAccount){

        return this.tradingAccountService.updateTradingAccount(tradingAccount);
    }

    @GetMapping(value = "/get-one/{tradingAccountID}")
    public TradingAccount getTradingAccount(@PathVariable int tradingAccountID){

       return this.tradingAccountService.getTradingAccount(tradingAccountID);
    }


}
