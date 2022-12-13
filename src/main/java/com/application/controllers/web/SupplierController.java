package com.application.controllers.web;

import com.application.entities.Supplier;
import com.application.services.classes.SupplierServiceClass;
import com.application.services.interfaces.SupplierServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private SupplierServiceInterface supplierServiceBean;

    public SupplierController(SupplierServiceInterface supplierServiceBean) { this.supplierServiceBean = supplierServiceBean; }

    @GetMapping("")
    public List<Supplier> getSuppliers(){ return supplierServiceBean.getSuppliers(); }

    @GetMapping("/supplier/{supplierId}")
    public Supplier getSupplier(@PathVariable Integer supplierId){ return supplierServiceBean.getSupplierById(supplierId); }

    @PostMapping("/create")
    public Supplier addSupplier(@RequestBody Supplier supplier){ return supplierServiceBean.addSupplier(supplier); }

}
