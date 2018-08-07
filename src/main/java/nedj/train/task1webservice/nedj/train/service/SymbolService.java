package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.Stock;
import nedj.train.task1webservice.nedj.train.model.Symbol;
import nedj.train.task1webservice.nedj.train.model.SymbolResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class SymbolService {


    public SymbolResponse getSymbols() throws MalformedURLException {

        SymbolResponse symbolResponse = new SymbolResponse(new ArrayList<Symbol>(), "List is empty!!");


        ObjectMapper objectMapper = new ObjectMapper();


        try {

            URL url = new URL("https://api.iextrading.com/1.0/ref-data/symbolsssd");

            List<Symbol> symbols = new ArrayList<>();

            symbols = objectMapper.readValue(url, new TypeReference<List<Symbol>>(){});

            if(symbols.size() != 0){

                symbolResponse.setResponse("Symbols list found successfully!!");
                symbolResponse.setSymbols(symbols);
            }



        } catch (MalformedURLException me) {

            symbolResponse.setResponse("Invalid url!!");

        } catch (JsonParseException jpe) {

            symbolResponse.setResponse("Json data not formatted properly!!");

        } catch (JsonMappingException jme) {

            symbolResponse.setResponse("Json mapping has failed!!");

        } catch (IOException ioe) {

           symbolResponse.setResponse("Url invalid, please correct the last part of the url!!");
        }

        return symbolResponse;

    }
}
