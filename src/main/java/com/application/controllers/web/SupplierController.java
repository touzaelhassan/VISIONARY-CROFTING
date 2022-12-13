package com.application.controllers.web;

import com.application.entities.Supplier;
import com.application.services.classes.SupplierServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    SupplierServiceClass supplierServiceClass;

    public SupplierController(SupplierServiceClass supplierServiceClass) { this.supplierServiceClass = supplierServiceClass; }

    @GetMapping("")
    public List<Supplier> getSuppliers(){ return supplierServiceClass.getSuppliers(); }

    @GetMapping("/supplier/{supplierId}")
    public Supplier getSupplier(@PathVariable Integer supplierId){ return supplierServiceClass.getSupplierById(supplierId); }

    @PostMapping("/create")
    public Supplier addSupplier(@RequestBody Supplier supplier){ return supplierServiceClass.addSupplier(supplier); }

}
