package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.entity.BuyStock;
import nedj.train.task1webservice.nedj.train.model.pojo.BuyStockPojo;
import nedj.train.task1webservice.nedj.train.service.BuyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/buy-stock")
public class BuyStockController {

    @Autowired
    private BuyStockService buyStockService;


    @PostMapping(value = "/buy")
    public String buyStock(@RequestBody BuyStockPojo buyStockPojo) throws IOException {

        return this.buyStockService.buyStock(buyStockPojo);
    }

    @GetMapping(value = "/stock-bought")
    public List<BuyStock> stocksBought(){

        return this.buyStockService.stocksBought();
    }
}
