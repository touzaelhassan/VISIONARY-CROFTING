package com.application.services.interfaces;

import com.application.entities.Supplier;

import java.util.List;

public interface SupplierServiceInterface {

    Supplier addSupplier(Supplier supplier);
    Supplier getSupplierById(Integer supplierId);
    List<Supplier> getSuppliers();

}
