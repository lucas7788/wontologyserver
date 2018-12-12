package com.github.ontio.model;

import java.math.BigDecimal;

public class BankerInfo {
    public String time;
    public String banker;
    public BigDecimal ongAmount;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBanker() {
        return banker;
    }

    public void setBanker(String banker) {
        this.banker = banker;
    }

    public BigDecimal getOngAmount() {
        return ongAmount;
    }

    public void setOngAmount(BigDecimal ongAmount) {
        this.ongAmount = ongAmount;
    }
}



