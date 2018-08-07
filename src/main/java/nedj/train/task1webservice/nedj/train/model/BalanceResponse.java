package nedj.train.task1webservice.nedj.train.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BalanceResponse implements Serializable {

    private double tradingAccountBalance;
    private String response;

    public BalanceResponse(String response){

        this.response = response;
    }
}
