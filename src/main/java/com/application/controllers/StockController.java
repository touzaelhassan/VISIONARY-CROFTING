package com.application.controllers;

import com.application.entities.Stock;
import com.application.services.classes.StockServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    StockServiceClass stockServiceClass;

    public StockController(StockServiceClass stockServiceClass) { this.stockServiceClass = stockServiceClass; }

    @GetMapping("")
    public List<Stock> getStocks(){ return stockServiceClass.getStocks(); }

    @GetMapping("/stock/{stockId}")
    public Stock getStock(@PathVariable Integer stockId){ return stockServiceClass.getStockById(stockId); }

    @PostMapping("/create")
    public Stock addStock(@RequestBody Stock stock){ return stockServiceClass.addStock(stock); }

}
