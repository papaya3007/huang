package me.ordersystem.huang.pojo;

import java.math.BigDecimal;

public class Dish {
    private Integer id;

    private String dishname;

    private BigDecimal dishprice;

    private Integer dishtype;

    public Dish(Integer id, String dishname, BigDecimal dishprice, Integer dishtype) {
        this.id = id;
        this.dishname = dishname;
        this.dishprice = dishprice;
        this.dishtype = dishtype;
    }

    public Dish() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname == null ? null : dishname.trim();
    }

    public BigDecimal getDishprice() {
        return dishprice;
    }

    public void setDishprice(BigDecimal dishprice) {
        this.dishprice = dishprice;
    }

    public Integer getDishtype() {
        return dishtype;
    }

    public void setDishtype(Integer dishtype) {
        this.dishtype = dishtype;
    }
}