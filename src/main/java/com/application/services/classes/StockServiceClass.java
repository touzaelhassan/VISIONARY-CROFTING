package com.application.services.classes;

import com.application.entities.Stock;
import com.application.repositories.StockRepository;
import com.application.services.interfaces.StockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stockServiceBean")
public class StockServiceClass implements StockServiceInterface {

    private StockRepository stockRepositoryBean;

    @Autowired
    public StockServiceClass(StockRepository stockRepositoryBean) { this.stockRepositoryBean = stockRepositoryBean; }

    @Override
    public Stock addStock(Stock stock) { return stockRepositoryBean.save(stock); }

    @Override
    public Stock getStockById(Integer stockId) { return stockRepositoryBean.findById(stockId).orElse(null); }

    @Override
    public Stock getStockByEmail(String email) { return stockRepositoryBean.getByEmail(email); }

    @Override
    public List<Stock> getStocks() { return stockRepositoryBean.findAll(); }

}
