package com.jzt.entity;

public class Merchant {

    //商户的统一社会信用代码
    private String cust_id;

    //商户名称
    private String mer_name;

    //----------------------------------------
    //是否我行商户：0-否，1-是
    private int is_bank_merch;

    // 收单商户日均交易额：（元）
    private Double avg_amt;

    public Merchant() {
    }

    public Merchant(String cust_id, String mer_name, int is_bank_merch, Double avg_amt) {
        this.cust_id = cust_id;
        this.mer_name = mer_name;
        this.is_bank_merch = is_bank_merch;
        this.avg_amt = avg_amt;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "cust_id='" + cust_id + '\'' +
                ", mer_name='" + mer_name + '\'' +
                ", is_bank_merch=" + is_bank_merch +
                ", avg_amt=" + avg_amt +
                '}';
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getMer_name() {
        return mer_name;
    }

    public void setMer_name(String mer_name) {
        this.mer_name = mer_name;
    }

    public int getIs_bank_merch() {
        return is_bank_merch;
    }

    public void setIs_bank_merch(int is_bank_merch) {
        this.is_bank_merch = is_bank_merch;
    }

    public Double getAvg_amt() {
        return avg_amt;
    }

    public void setAvg_amt(Double avg_amt) {
        this.avg_amt = avg_amt;
    }
}
