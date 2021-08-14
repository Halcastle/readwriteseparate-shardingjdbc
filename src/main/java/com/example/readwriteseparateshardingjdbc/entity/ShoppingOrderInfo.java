package com.example.readwriteseparateshardingjdbc.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingOrderInfo {
    private Long id;

    private Long customerid;

    private BigDecimal initamount;

    private BigDecimal discountamount;

    private BigDecimal freightcharge;

    private BigDecimal totalamount;

    private String modeofpayment;

    private String isenabled;

    private Date inputdate;

    private Date updatedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public BigDecimal getInitamount() {
        return initamount;
    }

    public void setInitamount(BigDecimal initamount) {
        this.initamount = initamount;
    }

    public BigDecimal getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(BigDecimal discountamount) {
        this.discountamount = discountamount;
    }

    public BigDecimal getFreightcharge() {
        return freightcharge;
    }

    public void setFreightcharge(BigDecimal freightcharge) {
        this.freightcharge = freightcharge;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public String getModeofpayment() {
        return modeofpayment;
    }

    public void setModeofpayment(String modeofpayment) {
        this.modeofpayment = modeofpayment == null ? null : modeofpayment.trim();
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