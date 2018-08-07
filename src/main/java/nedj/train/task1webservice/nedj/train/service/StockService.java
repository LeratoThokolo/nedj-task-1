package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.Stock;
import nedj.train.task1webservice.nedj.train.model.StockResponse;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class StockService {


    public StockResponse getStock(String symbol) throws IOException {

        StockResponse stockResponse = new StockResponse(new Stock(), "Stock not found!!");

        ObjectMapper objectMapper = new ObjectMapper();


        try {

            String urlApi = "https://api.iextrading.com/1.0/stock/" + symbol + "/quote";

            URL url = new URL(urlApi);

            Stock stock = objectMapper.readValue(url, Stock.class);

            if(!stock.getSymbol().equals("")){

                stockResponse.setStock(stock);
                stockResponse.setMessage("Stock found successfully!!");

            }

        }catch (MalformedURLException me){

            stockResponse.setMessage("Invalid url!!");

        }catch (NullPointerException ne){

            stockResponse.setMessage("Stock not found!!");

        }catch (FileNotFoundException fnfe){

           return new StockResponse("Stock not available, please input a valid symbol!!");
        }

       return stockResponse;
    }


}
