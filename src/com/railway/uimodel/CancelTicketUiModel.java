/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway.uimodel;

/**
 *
 * @author mahesh
 */
public class CancelTicketUiModel {

    /**
     * @return the ticketBooked
     */
    public String getTicketBooked() {
        return ticketBooked;
    }

    /**
     * @param ticketBooked the ticketBooked to set
     */
    public void setTicketBooked(String ticketBooked) {
        this.ticketBooked = ticketBooked;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    private String pnr;
    private String ticketBooked;
    private int trainNo;
    private String date;
    private String custName;
    private String custId;
    private int active;
    /**
     * @return the pnr
     */
    public String getPnr() {
        return pnr;
    }

    /**
     * @param pnr the pnr to set
     */
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

  

    /**
     * @return the trainNo
     */
    public int getTrainNo() {
        return trainNo;
    }

    /**
     * @param trainNo the trainNo to set
     */
    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

}
