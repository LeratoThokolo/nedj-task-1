package nedj.train.task1webservice.nedj.train.controller;

import nedj.train.task1webservice.nedj.train.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RestController
@RequestMapping("/stock")
public class StockController {


    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/get-specific-stock/{symbol}", method = RequestMethod.GET)
    public Object getStock(@PathVariable String symbol) throws IOException {

        return this.stockService.getStock(symbol);

    }
}
