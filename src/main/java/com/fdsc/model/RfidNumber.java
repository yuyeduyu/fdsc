package com.fdsc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/6/3.
 */
public class RfidNumber {
    //private String rfidf;
    private String productName;//品名
    private String color;
    private BigDecimal length;//米数
    private Timestamp outTime;//出厂日期
    private String dyeShopNumber;//染厂编号
    private BigDecimal crockCountNumber;//本缸总数
    private String assist;//辅助
    private String excelServerRCID;
//    private Integer excelServerRN;
//    private Integer excelServerCN;
//    private String excelServerRC1;
//    private String excelServerWIID;
//    private String excelServerRTID;
//    private Integer excelServerCHG;
    private String status;
    //private Timestamp outGoingTime;//出库日期
    private String storeroom;//库房
    //private String barCode;//条形码
    private String barCodeAssist;//条形码
    private String cylinderNumber;//缸号
    private String shrinkage;//缩率
    private String rfid;
    private String frozenMan;//冻结人
    private Timestamp startTime;//开始日期
    private Timestamp endTime;//截止日期

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public String getDyeShopNumber() {
        return dyeShopNumber;
    }

    public void setDyeShopNumber(String dyeShopNumber) {
        this.dyeShopNumber = dyeShopNumber;
    }

    public BigDecimal getCrockCountNumber() {
        return crockCountNumber;
    }

    public void setCrockCountNumber(BigDecimal crockCountNumber) {
        this.crockCountNumber = crockCountNumber;
    }

    public String getAssist() {
        return assist;
    }

    public void setAssist(String assist) {
        this.assist = assist;
    }

    public String getExcelServerRCID() {
        return excelServerRCID;
    }

    public void setExcelServerRCID(String excelServerRCID) {
        this.excelServerRCID = excelServerRCID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStoreroom() {
        return storeroom;
    }

    public void setStoreroom(String storeroom) {
        this.storeroom = storeroom;
    }

    public String getBarCodeAssist() {
        return barCodeAssist;
    }

    public void setBarCodeAssist(String barCodeAssist) {
        this.barCodeAssist = barCodeAssist;
    }

    public String getCylinderNumber() {
        return cylinderNumber;
    }

    public void setCylinderNumber(String cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public String getShrinkage() {
        return shrinkage;
    }

    public void setShrinkage(String shrinkage) {
        this.shrinkage = shrinkage;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getFrozenMan() {
        return frozenMan;
    }

    public void setFrozenMan(String frozenMan) {
        this.frozenMan = frozenMan;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
