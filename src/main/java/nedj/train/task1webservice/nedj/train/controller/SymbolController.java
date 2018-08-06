package nedj.train.task1webservice.nedj.train.controller;

import nedj.train.task1webservice.nedj.train.model.Symbol;
import nedj.train.task1webservice.nedj.train.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/symbol")
public class SymbolController {

    @Autowired
    private SymbolService symbolService;


    @RequestMapping(value = "/get-symbols", method = RequestMethod.GET)
    public List<Symbol> getSymbols(){

        List<Symbol> symbols = new ArrayList<>();

        try {
           symbols = this.symbolService.getSymbols();

        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

        return symbols;

    }
}
