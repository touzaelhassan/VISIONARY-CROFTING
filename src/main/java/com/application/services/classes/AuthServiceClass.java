package com.application.services.classes;

import com.application.entities.Customer;
import com.application.entities.Stock;
import com.application.entities.Supplier;
import com.application.services.interfaces.AuthServiceInterface;
import com.application.services.interfaces.CustomerServiceInterface;
import com.application.services.interfaces.StockServiceInterface;
import com.application.services.interfaces.SupplierServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authServiceBean")
public class AuthServiceClass implements AuthServiceInterface {

    private CustomerServiceInterface customerServiceBean;
    private StockServiceInterface stockServiceBean;
    private SupplierServiceInterface supplierServiceBean;

    @Autowired
    public AuthServiceClass(
            CustomerServiceInterface customerServiceBean,
            StockServiceInterface stockServiceBean,
            SupplierServiceInterface supplierServiceBean
    ) {
        this.customerServiceBean = customerServiceBean;
        this.stockServiceBean = stockServiceBean;
        this.supplierServiceBean = supplierServiceBean;
    }

    @Override
    public Boolean isLoggedIn(String email, String password, String role , HttpSession httpSession) {

        if(role.equals("customer")){

            Customer customer = customerServiceBean.getCustomerByEmail(email);

            if(customer != null && customer.getPassword().equals(password)){

                httpSession.setAttribute("id", customer.getId());
                httpSession.setAttribute("name", customer.getName());
                httpSession.setAttribute("email", customer.getEmail());
                httpSession.setAttribute("role", "customer");

                return true;

            }

        }

        if(role.equals("stock")){

            Stock stock = stockServiceBean.getStockByEmail(email);

            if(stock != null && stock.getPassword().equals(password)){

                return true;

            }

        }


        if(role.equals("supplier")){

            Supplier supplier = supplierServiceBean.getSupplierByEmail(email);

            if(supplier != null && supplier.getPassword().equals(password)){

                return true;

            }

        }

        return false;


    }

}
