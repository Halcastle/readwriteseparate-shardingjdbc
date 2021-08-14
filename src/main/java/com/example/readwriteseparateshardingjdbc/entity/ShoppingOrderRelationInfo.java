package com.example.readwriteseparateshardingjdbc.entity;

import java.util.Date;

public class ShoppingOrderRelationInfo {
    private Long id;

    private Long orderserialno;

    private Long commodityid;

    private Long commoditycount;

    private Date inputdate;

    private Date updatedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderserialno() {
        return orderserialno;
    }

    public void setOrderserialno(Long orderserialno) {
        this.orderserialno = orderserialno;
    }

    public Long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Long commodityid) {
        this.commodityid = commodityid;
    }

    public Long getCommoditycount() {
        return commoditycount;
    }

    public void setCommoditycount(Long commoditycount) {
        this.commoditycount = commoditycount;
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