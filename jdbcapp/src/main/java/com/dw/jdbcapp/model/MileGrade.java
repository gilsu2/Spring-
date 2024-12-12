package com.dw.jdbcapp.model;

public class MileGrade {
    private String gradeName; // 등급명
    private int lowerMile; // 하한마일리지
    private int upperMile; // 상한마일리지

    // 기본생성자
    public MileGrade() {
    }

    public MileGrade(String gradeName, int lowerMile, int upperMile) {
        this.gradeName = gradeName;
        this.lowerMile = lowerMile;
        this.upperMile = upperMile;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getLowerMile() {
        return lowerMile;
    }

    public void setLowerMile(int lowerMile) {
        this.lowerMile = lowerMile;
    }

    public int getUpperMile() {
        return upperMile;
    }

    public void setUpperMile(int upperMile) {
        this.upperMile = upperMile;
    }

    @Override
    public String toString() {
        return "MileGrade{" +
                "gradeName='" + gradeName + '\'' +
                ", lowerMile=" + lowerMile +
                ", upperMile=" + upperMile +
                '}';
    }
}
