package nedj.train.task1webservice.nedj.train.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.model.Stock;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Service
public class StockService {


    public Object getStock(String symbol) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();


        try {

            String urlApi = "https://api.iextrading.com/1.0/stock/" + symbol + "/quote";

            URL url = new URL(urlApi);

            Stock stock = objectMapper.readValue(url, Stock.class);

            if(!stock.getSymbol().equals("")){

               return stock;

            }

        }catch (MalformedURLException me){

           return ("Invalid url!!");

        }catch (NullPointerException ne){

            return ("Stock not found!!");

        }catch (FileNotFoundException fnfe){

            return ("Stock not available, please input a valid symbol!!");

        }catch (UnknownHostException une){

            return ("No internet connection!!");
        }

       return "Stock not found!!";
    }


}
