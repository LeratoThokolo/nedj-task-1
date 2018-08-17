package nedj.train.task1webservice.nedj.train.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class BuyStock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int buyStockID;
    private int tradingAccountID;
    private String symbol;
    private double randValueAmount;
}
