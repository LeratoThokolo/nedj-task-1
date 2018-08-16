package nedj.train.task1webservice.nedj.train.controller;

import nedj.train.task1webservice.nedj.train.model.Stock;
import nedj.train.task1webservice.nedj.train.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/stock")
public class StockController {


    @Autowired
    private StockService stockService;

    @GetMapping(value = "/get-specific-stock/{symbol}")
    public Stock getStock(@PathVariable String symbol) throws IOException {

        return this.stockService.getStock(symbol);

    }
}
