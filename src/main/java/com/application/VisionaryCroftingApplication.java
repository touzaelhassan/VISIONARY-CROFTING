package com.application;

import com.application.entities.*;
import com.application.enums.BidStatus;
import com.application.enums.Category;
import com.application.enums.OrderStatus;
import com.application.services.classes.CustomerServiceClass;
import com.application.services.interfaces.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class VisionaryCroftingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisionaryCroftingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(

            CustomerServiceInterface customerServiceInterface,
            StockServiceInterface stockServiceBean,
            ProductServiceInterface productServiceInterface,
            SupplierServiceInterface supplierServiceInterface,
            BidServiceInterface bidServiceInterface,
            OrderServiceInterface orderServiceInterface,
            OrderItemServiceInterface orderItemServiceInterface

    ){

        return args ->{

            // ADD CUSTOMERS

            Stream.of("customer1", "customer2", "customer3").forEach(customerName -> {

                Customer customer = new Customer();

                customer.setName(customerName);
                customer.setEmail(customerName + "@gmail.com");
                customer.setPhone("0535354637");
                customer.setPassword("123456");

                customerServiceInterface.addCustomer(customer);

            });

            // ADD STOCKS

            Stream.of("stock1", "stock2", "stock3").forEach(stockName -> {

                Stock stock = new Stock();

                stock.setName(stockName);
                stock.setEmail(stockName + "@gmail.com");
                stock.setAddress("Morocco, Fez N 134");
                stock.setPhone("0535354637");
                stock.setPassword("123456");

                stockServiceBean.addStock(stock);

            });

            // ADD SUPPLIERS

            Stream.of("supplier1", "supplier2", "supplier3").forEach(supplierName -> {

                Supplier supplier = new Supplier();

                supplier.setName(supplierName);
                supplier.setEmail(supplierName + "@gmail.com");
                supplier.setPhone("0535354637");
                supplier.setPassword("123456");

                supplierServiceInterface.addSupplier(supplier);

            });

            // ADD PRODUCTS

            Stock stock1 = stockServiceBean.getStockById(1);
            Stock stock2 = stockServiceBean.getStockById(2);
            Stock stock3 = stockServiceBean.getStockById(3);


            Product product1 = new Product();

            product1.setName("product1");
            product1.setReference("2343534");
            product1.setDescription("Description for The product 1");
            product1.setPrice(33F);
            product1.setQuantity(35);
            product1.setCategory(Category.CEREALS);
            product1.setStock(stock1);

            productServiceInterface.addProduct(product1);

            Product product2 = new Product();

            product2.setName("product2");
            product2.setReference("2343534");
            product2.setDescription("Description for The product 2");
            product2.setPrice(33F);
            product2.setQuantity(35);
            product2.setCategory(Category.FRUITS);
            product2.setStock(stock2);

            productServiceInterface.addProduct(product2);

            Product product3 = new Product();

            product3.setName("product3");
            product3.setReference("2343534");
            product3.setDescription("Description for The product 3");
            product3.setPrice(33F);
            product3.setQuantity(35);
            product3.setCategory(Category.LEGUMES);
            product3.setStock(stock3);

            productServiceInterface.addProduct(product3);

            Product product4 = new Product();

            product4.setName("product4");
            product4.setReference("2343534");
            product4.setDescription("Description for The product 4");
            product4.setPrice(33F);
            product4.setQuantity(35);
            product4.setCategory(Category.LEGUMES);
            product4.setStock(stock1);

            productServiceInterface.addProduct(product4);

            Product product5 = new Product();

            product5.setName("product5");
            product5.setReference("2343534");
            product5.setDescription("Description for The product 5");
            product5.setPrice(33F);
            product5.setQuantity(35);
            product5.setCategory(Category.FRUITS);
            product5.setStock(stock2);

            productServiceInterface.addProduct(product5);

            Product product6 = new Product();

            product6.setName("product6");
            product6.setReference("2343534");
            product6.setDescription("Description for The product 6");
            product6.setPrice(33F);
            product6.setQuantity(35);
            product6.setCategory(Category.CEREALS);
            product6.setStock(stock3);

            productServiceInterface.addProduct(product6);

            // ADD BIDS

            Stock stock4 = stockServiceBean.getStockById(1);
            Supplier supplier4 = supplierServiceInterface.getSupplierById(1);

            Bid bid1 = new Bid();

            bid1.setReference("43534");
            bid1.setBidStatus(BidStatus.OPEN);
            bid1.setStock(stock4);
            bid1.setSupplier(supplier4);

            bidServiceInterface.addBid(bid1);

            Stock stock5 = stockServiceBean.getStockById(2);
            Supplier supplier5 = supplierServiceInterface.getSupplierById(2);

            Bid bid2 = new Bid();

            bid2.setReference("43534");
            bid2.setBidStatus(BidStatus.OPEN);
            bid2.setStock(stock5);
            bid2.setSupplier(supplier5);

            bidServiceInterface.addBid(bid2);

            // ADD ORDERS

            Customer customer1 = customerServiceInterface.getCustomerById(1);

            Order order1 = new Order();

            order1.setReference("67445");
            order1.setDate(new Date());
            order1.setTotalPrice(145.50F);
            order1.setOrderStatus(OrderStatus.PENDING);
            order1.setCustomer(customer1);

            orderServiceInterface.addOrder(order1);

            Customer customer2 = customerServiceInterface.getCustomerById(2);

            Order order2 = new Order();

            order2.setReference("67433");
            order2.setDate(new Date());
            order2.setTotalPrice(500.50F);
            order2.setOrderStatus(OrderStatus.PENDING);
            order2.setCustomer(customer2);

            orderServiceInterface.addOrder(order2);

            // ADD ORDER-ITEMS

            Order order11 = orderServiceInterface.getOrderById(1);

            Product product11 = productServiceInterface.getProductById(1);

            OrderItem orderItem1 = new OrderItem();

            orderItem1.setReference("54563");
            orderItem1.setPrice(440.75F);
            orderItem1.setQuantity(2);
            orderItem1.setOrder(order11);
            orderItem1.setProduct(product11);

            orderItemServiceInterface.addOrderItem(orderItem1);

            Order order22 = orderServiceInterface.getOrderById(2);

            Product product22 = productServiceInterface.getProductById(2);

            OrderItem orderItem2 = new OrderItem();

            orderItem2.setReference("54588");
            orderItem2.setPrice(670.75F);
            orderItem2.setQuantity(2);
            orderItem2.setOrder(order22);
            orderItem2.setProduct(product22);

            orderItemServiceInterface.addOrderItem(orderItem2);

        };

    }

}
