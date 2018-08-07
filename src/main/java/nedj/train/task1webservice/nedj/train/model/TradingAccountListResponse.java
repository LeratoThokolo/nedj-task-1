package nedj.train.task1webservice.nedj.train.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradingAccountListResponse implements Serializable {

    private List<TradingAccount> tradingAccounts;
    private String response;

    private TradingAccountListResponse(String response){

        this.response = response;
    }
}
