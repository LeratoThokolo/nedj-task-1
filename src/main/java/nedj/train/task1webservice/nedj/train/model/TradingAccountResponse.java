package nedj.train.task1webservice.nedj.train.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradingAccountResponse implements Serializable {

    private TradingAccount tradingAccount;
    private String response;

    public TradingAccountResponse(String response){

        this.response = response;
    }
}
