package com.application.services.classes;

import com.application.entities.Bid;
import com.application.repositories.BidRepository;
import com.application.services.interfaces.BidServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bidServiceBean")
public class BidServiceClass implements BidServiceInterface {

    private BidRepository bidRepositoryBean;

    public BidServiceClass(BidRepository bidRepository) { this.bidRepositoryBean = bidRepository; }

    @Override
    public Bid addBid(Bid bid) { return bidRepositoryBean.save(bid); }

    @Override
    public Bid getBidById(Integer bidId) { return bidRepositoryBean.findById(bidId).orElse(null);}

    @Override
    public List<Bid> getBids() { return bidRepositoryBean.findAll(); }

}
