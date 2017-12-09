package me.ordersystem.huang.pojo;

public class Dishtype {
    private Integer id;

    private String dishtype;

    public Dishtype(Integer id, String dishtype) {
        this.id = id;
        this.dishtype = dishtype;
    }

    public Dishtype() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishtype() {
        return dishtype;
    }

    public void setDishtype(String dishtype) {
        this.dishtype = dishtype == null ? null : dishtype.trim();
    }
}