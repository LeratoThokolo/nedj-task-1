package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.Stock;
import nedj.train.task1webservice.nedj.train.model.Symbol;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class SymbolService {


    public List<Symbol> getSymbols() throws MalformedURLException {


        ObjectMapper objectMapper = new ObjectMapper();

        URL url = new URL("https://api.iextrading.com/1.0/ref-data/symbols");

        List<Symbol> symbols = new ArrayList<>();

        try {


            symbols = objectMapper.readValue(url, new TypeReference<List<Symbol>>(){});



        } catch (IOException e) {
            e.printStackTrace();
        }

        return symbols;

    }
}
