package nedj.train.task1webservice.nedj.train.controller;

import nedj.train.task1webservice.nedj.train.model.entity.SymbolObject;
import nedj.train.task1webservice.nedj.train.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/symbol")
public class SymbolController {

    @Autowired
    private SymbolService symbolService;


    @GetMapping(value = "/get-symbols")
    public List<SymbolObject> getSymbols() throws IOException {


        return this.symbolService.getSymbols();
    }
}
