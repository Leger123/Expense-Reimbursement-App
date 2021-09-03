package models;

import java.io.InputStream;
import java.sql.*;

/**
 * @author Kevin Dian
 */

public class Reimbursement {

    Integer reimbId;
    Double reimbAmount;
    Timestamp reimbSubmitted;
    Timestamp reimbResolved;
    String reimbDescription;
    Blob reimbReceipt;
    Integer ersUsersFkAuth;
    Integer ersUsersFkReslvr;
    Integer ersReimbursementStatusFk;
    Integer ersReimbursementTypeFk;

    public Reimbursement() {
    }

    public Reimbursement(Integer reimbId, Double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbDescription, Blob reimbReceipt, Integer ersUsersFkAuth, Integer ersUsersFkReslvr, Integer ersReimbursementStatusFk, Integer ersReimbursementTypeFk) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.ersUsersFkAuth = ersUsersFkAuth;
        this.ersUsersFkReslvr = ersUsersFkReslvr;
        this.ersReimbursementStatusFk = ersReimbursementStatusFk;
        this.ersReimbursementTypeFk = ersReimbursementTypeFk;
    }

    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(Double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Timestamp getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(Timestamp reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public Timestamp getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(Timestamp reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public Blob getReimbReceipt() {
        return reimbReceipt;
    }

    public void setReimbReceipt(Blob reimbReceipt) {
        this.reimbReceipt = reimbReceipt;
    }

    public Integer getErsUsersFkAuth() {
        return ersUsersFkAuth;
    }

    public void setErsUsersFkAuth(Integer ersUsersFkAuth) {
        this.ersUsersFkAuth = ersUsersFkAuth;
    }

    public Integer getErsUsersFkReslvr() {
        return ersUsersFkReslvr;
    }

    public void setErsUsersFkReslvr(Integer ersUsersFkReslvr) {
        this.ersUsersFkReslvr = ersUsersFkReslvr;
    }

    public Integer getErsReimbursementStatusFk() {
        return ersReimbursementStatusFk;
    }

    public void setErsReimbursementStatusFk(Integer ersReimbursementStatusFk) {
        this.ersReimbursementStatusFk = ersReimbursementStatusFk;
    }

    public Integer getErsReimbursementTypeFk() {
        return ersReimbursementTypeFk;
    }

    public void setErsReimbursementTypeFk(Integer ersReimbursementTypeFk) {
        this.ersReimbursementTypeFk = ersReimbursementTypeFk;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbReceipt=" + reimbReceipt +
                ", ersUsersFkAuth=" + ersUsersFkAuth +
                ", ersUsersFkReslvr=" + ersUsersFkReslvr +
                ", ersReimbursementStatusFk=" + ersReimbursementStatusFk +
                ", ersReimbursementTypeFk=" + ersReimbursementTypeFk +
                '}'+ "\n";
    }
}
