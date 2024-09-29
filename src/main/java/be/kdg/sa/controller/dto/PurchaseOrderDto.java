package be.kdg.sa.controller.dto;

import be.kdg.sa.domain.Buyer;
import be.kdg.sa.domain.OrderLine;
import be.kdg.sa.domain.PurchaseOrder;
import be.kdg.sa.domain.Seller;
import org.hibernate.query.Order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static be.kdg.sa.service.PurchaseOrderService.purchaseOrders;

public class PurchaseOrderDto {
    private String poNumber;
    private String buyerName;
    private String buyerAddress;
    private String sellerName;
    private String sellerAddress;
    private Date date;
    private List<OrderLine> orderLines;
    private String vesselNumber;

    // Constructors

    public PurchaseOrderDto(PurchaseOrder purchaseOrder) {
        this.poNumber = purchaseOrder.getPoNumber();
        this.buyerName = purchaseOrder.getBuyer().getName();
        this.buyerAddress = purchaseOrder.getBuyer().getAddress();
        this.sellerName = purchaseOrder.getSeller().getName();
        this.sellerAddress = purchaseOrder.getSeller().getAddress();
        this.date = purchaseOrder.getPurchaseDate();
        this.orderLines = purchaseOrder.getOrderLines();
        this.vesselNumber = purchaseOrder.getVesselNumber();
    }

    public PurchaseOrder toSource(){

        Seller seller = new Seller(1,sellerName,sellerAddress);
        Buyer buyer = new Buyer(1, buyerName, buyerAddress);
        return new PurchaseOrder(purchaseOrders.size() +1, poNumber, date, vesselNumber,seller, buyer, orderLines );

    }

    public PurchaseOrderDto() {}

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }
}

