package com.application.services.interfaces;

import com.application.entities.Bid;

import java.util.List;

public interface BidServiceInterface {

    Bid addBid(Bid bid);
    Bid getBidById(Integer bidId);
    List<Bid> getBids();

}
