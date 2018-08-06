package nedj.train.task1webservice.nedj.train.service;

import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TradingAccountService {

    @Autowired
    private TradingAccountRepository tradingAccountRepository;


    public TradingAccount createAccount(TradingAccount tradingAccount){

        return this.tradingAccountRepository.save(tradingAccount);
    }

    public List<TradingAccount> getTradingAccounts(){

        return this.tradingAccountRepository.findAll();
    }

    public double accountBalance(int tradingAccountID){

        return this.tradingAccountRepository.getOne(tradingAccountID).getInitialTradeAmount();
    }


}
