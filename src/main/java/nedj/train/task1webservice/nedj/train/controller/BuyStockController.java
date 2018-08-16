package nedj.train.task1webservice.nedj.train.controller;


import nedj.train.task1webservice.nedj.train.model.BuyStock;
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
    public String buyStock(@RequestBody BuyStock buyStock) throws IOException {

        return this.buyStockService.buyStock(buyStock);
    }

    @GetMapping(value = "/stock-bought")
    public List<BuyStock> stocksBought(){

        return this.buyStockService.stocksBought();
    }
}
