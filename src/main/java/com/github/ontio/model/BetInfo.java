package com.github.ontio.model;

import java.math.BigDecimal;

public class BetInfo {
    public String bettor;
    public Integer rollUnder;
    public BigDecimal bet;
    public Integer roll;
    public BigDecimal payout;

    public String getBettor() {
        return bettor;
    }

    public void setBettor(String bettor) {
        this.bettor = bettor;
    }

    public Integer getRollUnder() {
        return rollUnder;
    }

    public void setRollUnder(Integer rollUnder) {
        this.rollUnder = rollUnder;
    }

    public BigDecimal getBet() {
        return bet;
    }

    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }
}