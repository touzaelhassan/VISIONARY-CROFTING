package com.application.controllers.web;

import com.application.entities.Stock;
import com.application.services.classes.StockServiceClass;
import com.application.services.interfaces.StockServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stocks")
public class StockController {

    private StockServiceInterface stockServiceBean;

    public StockController(StockServiceInterface stockServiceBean) { this.stockServiceBean = stockServiceBean; }

    @GetMapping("")
    public List<Stock> getStocks(){ return stockServiceBean.getStocks(); }

    @GetMapping("/stock/{stockId}")
    public Stock getStock(@PathVariable Integer stockId){ return stockServiceBean.getStockById(stockId); }

    @PostMapping("/create")
    public Stock addStock(@RequestBody Stock stock){ return stockServiceBean.addStock(stock); }

}
