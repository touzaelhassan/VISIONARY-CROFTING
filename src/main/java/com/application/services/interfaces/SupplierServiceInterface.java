package com.application.services.interfaces;

import com.application.entities.Supplier;

import java.util.List;

public interface SupplierServiceInterface {

    Supplier addSupplier(Supplier supplier);
    Supplier getSupplierById(Integer supplierId);
    Supplier getSupplierByEmail(String email);
    List<Supplier> getSuppliers();

}
