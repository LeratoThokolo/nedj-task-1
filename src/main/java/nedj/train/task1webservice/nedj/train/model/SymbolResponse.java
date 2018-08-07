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
public class SymbolResponse implements Serializable {

    private List<Symbol> symbols;
    private String response;

}
