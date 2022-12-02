package com.application.services.interfaces;

import com.application.entities.Stock;

import java.util.List;

public interface StockServiceInterface {

    Stock addStock(Stock stock);
    Stock getStockById(Integer stockId);
    List<Stock> getStocks();

}
