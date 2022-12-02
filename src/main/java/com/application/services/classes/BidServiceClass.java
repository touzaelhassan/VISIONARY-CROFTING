package com.application.services.classes;

import com.application.entities.Bid;
import com.application.repositories.BidRepository;
import com.application.services.interfaces.BidServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceClass implements BidServiceInterface {

    BidRepository bidRepository;

    public BidServiceClass(BidRepository bidRepository) { this.bidRepository = bidRepository; }

    @Override
    public Bid addBid(Bid bid) { return bidRepository.save(bid); }

    @Override
    public Bid getBidById(Integer bidId) { return bidRepository.findById(bidId).orElse(null);}

    @Override
    public List<Bid> getBids() { return bidRepository.findAll(); }

}
