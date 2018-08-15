package nedj.train.task1webservice.nedj.train.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class TradingAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tradingAccountID;
    private String userName;
    private double initialTradeAmount;

    public TradingAccount(String json) throws IOException {

        TradingAccount  tradingAccount = new ObjectMapper().readValue(json, TradingAccount.class);
        this.tradingAccountID = tradingAccount.tradingAccountID;
        this.userName = tradingAccount.userName;
        this.initialTradeAmount = tradingAccount.initialTradeAmount;
    }



}
