package com.application.services.classes;

import com.application.entities.Stock;
import com.application.repositories.StockRepository;
import com.application.services.interfaces.StockServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceClass implements StockServiceInterface {

    StockRepository stockRepository;

    public StockServiceClass(StockRepository stockRepository) { this.stockRepository = stockRepository; }

    @Override
    public Stock addStock(Stock stock) { return stockRepository.save(stock); }

    @Override
    public Stock getStockById(Integer stockId) { return stockRepository.findById(stockId).orElse(null); }

    @Override
    public List<Stock> getStocks() { return stockRepository.findAll(); }

}
