package nedj.train.task1webservice.nedj.train.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nedj.train.task1webservice.nedj.train.model.entity.TradingAccount;

import java.io.IOException;
import java.io.Serializable;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class TradingAccountPojo extends TradingAccount implements Serializable {

    public TradingAccountPojo(int tradingAccountID, String userName, double initialTradingAmount){
        super(tradingAccountID, userName, initialTradingAmount);
    }


    public TradingAccountPojo(String json) throws IOException {
        super(json);
    }

    public TradingAccountPojo() {
        super();
    }
}
