package com.example.readwriteseparateshardingjdbc.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCommodityInfo {
    private Long id;

    private String name;

    private String describe;

    private String classify;

    private String repertorynum;

    private BigDecimal purchaseprice;

    private BigDecimal offeringprice;

    private String isenabled;

    private Date inputdate;

    private Date updatedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getRepertorynum() {
        return repertorynum;
    }

    public void setRepertorynum(String repertorynum) {
        this.repertorynum = repertorynum == null ? null : repertorynum.trim();
    }

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public BigDecimal getOfferingprice() {
        return offeringprice;
    }

    public void setOfferingprice(BigDecimal offeringprice) {
        this.offeringprice = offeringprice;
    }

    public String getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled == null ? null : isenabled.trim();
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}