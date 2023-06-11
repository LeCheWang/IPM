package com.ipm.ipm.Model.Response.ContractResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ipm.ipm.Model.Account;

public class Contract2 {
    @SerializedName("_id")
    private String id;

    @SerializedName("idUser")
    private Account idUser;

    @Expose()
    @SerializedName("idFactory")
    private Factory2 idFactory;

    @SerializedName("startDate")
    private String startDate;

    @SerializedName("endDate")
    private String endDate;

    @SerializedName("deposit")
    private float deposit;

    @SerializedName("isAccepted")
    private int isAccepted;

    @SerializedName("isFinished")
    private int isFinished;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("isStatusAccepted")
    private int isStatusAccepted;

    public Contract2(String id, Account idUser, Factory2 idFactory, String startDate, String endDate, float deposit, int isAccepted, int isFinished, String createdAt, int isStatusAccepted) {
        this.id = id;
        this.idUser = idUser;
        this.idFactory = idFactory;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.isAccepted = isAccepted;
        this.isFinished = isFinished;
        this.createdAt = createdAt;
        this.isStatusAccepted = isStatusAccepted;
    }

    public int getIsStatusAccepted() {
        return isStatusAccepted;
    }

    public void setIsStatusAccepted(int isStatusAccepted) {
        this.isStatusAccepted = isStatusAccepted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getIdUser() {
        return idUser;
    }

    public void setIdUser(Account idUser) {
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

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
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
