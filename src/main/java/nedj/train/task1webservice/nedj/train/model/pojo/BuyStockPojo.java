package nedj.train.task1webservice.nedj.train.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nedj.train.task1webservice.nedj.train.model.entity.BuyStock;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class BuyStockPojo extends BuyStock {


    public BuyStockPojo(int buyStockID, int tradingAccountID, String symbol, double randValueAmount){

        super(buyStockID, tradingAccountID, symbol, randValueAmount);


    }

    public BuyStockPojo() {
        super();
    }
}
