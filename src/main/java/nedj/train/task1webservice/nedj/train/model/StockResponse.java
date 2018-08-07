package nedj.train.task1webservice.nedj.train.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StockResponse implements Serializable {

    private Stock stock;
    private String message;

    public StockResponse(String message){

        this.message = message;
    }
}
