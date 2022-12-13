package com.application.controllers.web;

import com.application.entities.Bid;
import com.application.services.classes.BidServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    BidServiceClass bidServiceClass;

    public BidController(BidServiceClass bidServiceClass) { this.bidServiceClass = bidServiceClass; }

    @GetMapping("")
    public List<Bid> getBids(){ return bidServiceClass.getBids(); }

    @GetMapping("/bid/{bidId}")
    public Bid getBid(@PathVariable Integer bidId){ return bidServiceClass.getBidById(bidId); }

    @PostMapping("/create")
    public Bid addBid(@RequestBody Bid bid){ return bidServiceClass.addBid(bid); }

}
