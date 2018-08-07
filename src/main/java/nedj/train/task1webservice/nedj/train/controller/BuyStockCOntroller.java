package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.BuyStock;
import nedj.train.task1webservice.nedj.train.service.BuyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy-stock")
public class BuyStockCOntroller {

    @Autowired
    private BuyStockService buyStockService;


    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buyStock(@RequestBody BuyStock buyStock) throws Exception {

        if(buyStock == null){

            throw new Exception("Supply details to buy stock!!");
        }

        return this.buyStockService.buyStock(buyStock);
    }
}
