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
public class TrainUiModel {
    private int trainNo;
    private String station;
    private String train;
    private String arrivalTime;
    private String depTime;
    private int ticketAvailiable;

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
     * @return the station
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * @return the train
     */
    public String getTrain() {
        return train;
    }

    /**
     * @param train the train to set
     */
    public void setTrain(String train) {
        this.train = train;
    }

    /**
     * @return the arrivalTime
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the depTime
     */
    public String getDepTime() {
        return depTime;
    }

    /**
     * @param depTime the depTime to set
     */
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    /**
     * @return the ticketAvailiable
     */
    public int getTicketAvailiable() {
        return ticketAvailiable;
    }

    /**
     * @param ticketAvailiable the ticketAvailiable to set
     */
    public void setTicketAvailiable(int ticketAvailiable) {
        this.ticketAvailiable = ticketAvailiable;
    }
    
    
    
}
