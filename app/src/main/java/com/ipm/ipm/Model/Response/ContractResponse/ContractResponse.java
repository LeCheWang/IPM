package com.ipm.ipm.Model.Response.ContractResponse;

import com.google.gson.annotations.SerializedName;
import com.ipm.ipm.Model.Contract;

import java.util.List;

public class ContractResponse {
    @SerializedName("page")
    private String page;

    @SerializedName("total_page")
    private int total_page;

    @SerializedName("per_page")
    private int per_page;

    @SerializedName("contractes")
    private List<Contract2> contractes;

    public ContractResponse(String page, int total_page, int per_page, List<Contract2> contractes) {
        this.page = page;
        this.total_page = total_page;
        this.per_page = per_page;
        this.contractes = contractes;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public List<Contract2> getContractes() {
        return contractes;
    }

    public void setContractes(List<Contract2> contractes) {
        this.contractes = contractes;
    }
}
