package com.application.entities;

import com.application.enums.BidStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;

    @Enumerated(EnumType.STRING)
    private BidStatus bidStatus;

    @ManyToOne
    private Stock stock ;

    @ManyToOne
    private Supplier supplier ;

    public Bid() { }

    public Bid(String reference, BidStatus bidStatus) {

        this.reference = reference;
        this.bidStatus = bidStatus;

    }

    public void setId(Integer id) { this.id = id; }
    public void setReference(String reference) { this.reference = reference; }
    public void setBidStatus(BidStatus bidStatus) { this.bidStatus = bidStatus; }
    public void setStock(Stock stock) { this.stock = stock; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }

    public Integer getId() { return id; }
    public String getReference() { return reference; }
    public BidStatus getBidStatus() { return bidStatus; }
    public Stock getStock() { return stock; }
    public Supplier getSupplier() { return supplier; }

}
