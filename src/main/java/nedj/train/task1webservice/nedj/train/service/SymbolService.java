package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.entity.SymbolObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class SymbolService {


    public List<SymbolObject> getSymbols() throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();


        URL url = new URL("https://api.iextrading.com/1.0/ref-data/symbols");



        List<SymbolObject> symbols  = objectMapper.readValue(url, new TypeReference<List<SymbolObject>>() {
        });

        if (symbols.isEmpty()) {

            return symbols;
        }

        return symbols;
    }
}
