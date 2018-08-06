package nedj.train.task1webservice.nedj.train.controller;

import nedj.train.task1webservice.nedj.train.model.Stock;
import nedj.train.task1webservice.nedj.train.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.OneToMany;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {


    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/get-specific-stock/{symbol}", method = RequestMethod.GET)
    public Stock getStock(@PathVariable String symbol) throws IOException {

        return this.stockService.getStock(symbol);

    }
}
