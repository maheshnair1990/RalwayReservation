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
public class TrainAdminUiModel {

    /**
     * @return the trainNumber
     */
    public String getTrainNumber() {
        return trainNumber;
    }

    /**
     * @param trainNumber the trainNumber to set
     */
    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    /**
     * @return the tickets
     */
    public int getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
    private String station;
    private String trainName;
    private int tickets;
    private String arrivalTime;
    private String depatureTime;
    private String trainNumber;

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
     * @return the trainName
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * @param trainName the trainName to set
     */
    public void setTrainName(String trainName) {
        this.trainName = trainName;
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
     * @return the depatureTime
     */
    public String getDepatureTime() {
        return depatureTime;
    }

    /**
     * @param depatureTime the depatureTime to set
     */
    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }

}
