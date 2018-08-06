package nedj.train.task1webservice.nedj.train.service;


import nedj.train.task1webservice.nedj.train.model.BuyStock;
import nedj.train.task1webservice.nedj.train.repository.BuyStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyStockService {


    @Autowired
    private BuyStockRepository buyStockRepository;


    public String buyStock(BuyStock buyStock){

        String response = "Stock bought successfully!!";

        if(buyStock != null){

            this.buyStockRepository.save(buyStock);

        }else{

            response = "Please supply details to buy stock!!";
        }

        return response;
    }
}
