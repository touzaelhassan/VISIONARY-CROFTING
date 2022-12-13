package com.application.controllers.web;

import com.application.entities.Bid;
import com.application.services.classes.BidServiceClass;
import com.application.services.interfaces.BidServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bids")
public class BidController {

    private BidServiceInterface bidServiceBean;

    public BidController(BidServiceInterface bidServiceBean) { this.bidServiceBean = bidServiceBean; }

    @GetMapping("")
    public List<Bid> getBids(){ return bidServiceBean.getBids(); }

    @GetMapping("/bid/{bidId}")
    public Bid getBid(@PathVariable Integer bidId){ return bidServiceBean.getBidById(bidId); }

    @PostMapping("/create")
    public Bid addBid(@RequestBody Bid bid){ return bidServiceBean.addBid(bid); }

}
