package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.Stock;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URL;


@Service
public class StockService {


    public Stock getStock(String symbol) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();


        String urlApi = "https://api.iextrading.com/1.0/stock/" + symbol + "/quote";

        URL url = new URL(urlApi);

        Stock stock = objectMapper.readValue(url, Stock.class);



        return stock;

    }

}
