package com.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "supplier")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Bid> bids = new ArrayList<>();

    public Supplier() { }

    public Supplier(String name, String email, String phone, String password) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPassword(String password) { this.password = password; }
    public void setBids(List<Bid> bids) { this.bids = bids; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public List<Bid> getBids() { return bids; }

}
