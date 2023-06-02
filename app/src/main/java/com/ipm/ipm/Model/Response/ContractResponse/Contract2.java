package com.ipm.ipm.Model.Response.ContractResponse;

import com.google.gson.annotations.SerializedName;

public class Contract2 {
    @SerializedName("_id")
    private String id;

    @SerializedName("idUser")
    private String idUser;

    @SerializedName("idFactory")
    private Factory2 idFactory;

    @SerializedName("startDate")
    private String startDate;

    @SerializedName("endDate")
    private String endDate;

    @SerializedName("deposit")
    private int deposit;

    @SerializedName("isAccepted")
    private int isAccepted;

    @SerializedName("isFinished")
    private int isFinished;

    @SerializedName("createdAt")
    private String createdAt;

    public Contract2(String id, String idUser, Factory2 idFactory, String startDate, String endDate, int deposit, int isAccepted, int isFinished, String createdAt) {
        this.id = id;
        this.idUser = idUser;
        this.idFactory = idFactory;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.isAccepted = isAccepted;
        this.isFinished = isFinished;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Factory2 getIdFactory() {
        return idFactory;
    }

    public void setIdFactory(Factory2 idFactory) {
        this.idFactory = idFactory;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(int isAccepted) {
        this.isAccepted = isAccepted;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
