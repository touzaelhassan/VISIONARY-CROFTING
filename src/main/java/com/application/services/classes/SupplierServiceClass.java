package com.application.services.classes;

import com.application.entities.Supplier;
import com.application.repositories.SupplierRepository;
import com.application.services.interfaces.SupplierServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceClass implements SupplierServiceInterface {

    private SupplierRepository supplierRepositoryBean;

    @Autowired
    public SupplierServiceClass(SupplierRepository supplierRepositoryBean) { this.supplierRepositoryBean = supplierRepositoryBean; }

    @Override
    public Supplier addSupplier(Supplier supplier) { return supplierRepositoryBean.save(supplier); }

    @Override
    public Supplier getSupplierById(Integer supplierId) { return supplierRepositoryBean.findById(supplierId).orElse(null); }

    @Override
    public Supplier getSupplierByEmail(String email) { return supplierRepositoryBean.getByEmail(email); }

    @Override
    public List<Supplier> getSuppliers() { return supplierRepositoryBean.findAll(); }

}
