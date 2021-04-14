package com.accentelsoft.multirecyclerview;

/**
 * Designed and Developed by Mohammad suhail ahmed on 14/04/2021
 */
public class Menu {
    private int subcategoryid;
    private String categoryname;
    private int menuid;
    private String name;
    private Double price;
    private String type;
    public Menu(int subcategoryid,String categoryname,int menuid,String name,Double price,String type){
        this.subcategoryid = subcategoryid;
        this.categoryname = categoryname;
        this.menuid = menuid;
        this.name = name;
        this.price = price;
        this.type = type;
    }


    public String getCategoryname() {
        return categoryname;
    }

    public int getCategoryid() {
        return subcategoryid;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public int getMenuid() {
        return menuid;
    }

    public String getMenuname() {
        return name;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setSubcategoryid(int subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
