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
public class BookTicketUiModel {
    private String date;
    private String ticketNumber;
    private String toStation;
    private String fromStation;

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
     * @return the ticketNumber
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * @param ticketNumber the ticketNumber to set
     */
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * @return the toStation
     */
    public String getToStation() {
        return toStation;
    }

    /**
     * @param toStation the toStation to set
     */
    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    /**
     * @return the fromStation
     */
    public String getFromStation() {
        return fromStation;
    }

    /**
     * @param fromStation the fromStation to set
     */
    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }
    
    
    
}
