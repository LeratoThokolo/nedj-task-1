package nedj.train.task1webservice.nedj.train.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class SymbolObject implements Serializable {

    private String symbol;
    private String name;
    private Date date;
    private boolean isEnabled;
    private String type;
    private int iexId;

}
