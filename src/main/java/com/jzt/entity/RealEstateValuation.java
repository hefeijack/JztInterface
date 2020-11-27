package com.jzt.entity;



public class RealEstateValuation {

    // 身份证号
    private String cerno;

    //姓名
    private String name;

    //------------------------------------
    //查封状态：0-是，1-否
    private int cfzt;

    // 抵押状态：0-是，1-否
    private int dyzt;

    // 债券数额：
    private Double zqse;

    // 房产评估金额：
    private Double fcpgje;

    public RealEstateValuation() {
    }

    public RealEstateValuation(String cerno, String name) {
        this.cerno = cerno;
        this.name = name;
    }

    public RealEstateValuation(int cfzt, int dyzt, Double zqse, Double fcpgje) {
        this.cfzt = cfzt;
        this.dyzt = dyzt;
        this.zqse = zqse;
        this.fcpgje = fcpgje;
    }

    @Override
    public String toString() {
        return "RealEstateValuation{" +
                "cerno='" + cerno + '\'' +
                ", name='" + name + '\'' +
                ", cfzt=" + cfzt +
                ", dyzt=" + dyzt +
                ", zqse=" + zqse +
                ", fcpgje=" + fcpgje +
                '}';
    }

    public String getCerno() {
        return cerno;
    }

    public void setCerno(String cerno) {
        this.cerno = cerno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCfzt() {
        return cfzt;
    }

    public void setCfzt(int cfzt) {
        this.cfzt = cfzt;
    }

    public int getDyzt() {
        return dyzt;
    }

    public void setDyzt(int dyzt) {
        this.dyzt = dyzt;
    }

    public Double getZqse() {
        return zqse;
    }

    public void setZqse(Double zqse) {
        this.zqse = zqse;
    }

    public Double getFcpgje() {
        return fcpgje;
    }

    public void setFcpgje(Double fcpgje) {
        this.fcpgje = fcpgje;
    }
}
