package com.application.services.classes;

import com.application.entities.Supplier;
import com.application.repositories.SupplierRepository;
import com.application.services.interfaces.SupplierServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceClass implements SupplierServiceInterface {

    SupplierRepository supplierRepository;

    public SupplierServiceClass(SupplierRepository supplierRepository) { this.supplierRepository = supplierRepository; }

    @Override
    public Supplier addSupplier(Supplier supplier) { return supplierRepository.save(supplier); }

    @Override
    public Supplier getSupplierById(Integer supplierId) { return supplierRepository.findById(supplierId).orElse(null); }

    @Override
    public List<Supplier> getSuppliers() { return supplierRepository.findAll(); }

}
