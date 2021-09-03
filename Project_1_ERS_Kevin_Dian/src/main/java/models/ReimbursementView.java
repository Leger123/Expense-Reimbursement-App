package models;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 * @author Kevin Dian
 */

public class ReimbursementView {

    Integer reimbId;
    Double reimbAmount;
    Timestamp reimbSubmitted;
    Timestamp reimbResolved;
    String reimbDescription;
    Blob reimbReceipt;
    Integer ersUsersFkAuth;
    String authorFirstName;
    String authorLastName;
    Integer ersUsersFkReslvr;
    String resolverFirstName;
    String resolverLastName;
    String reimbStatus;
    String reimbType;

    public ReimbursementView(){
    }

    public ReimbursementView(Integer reimbId, Double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbDescription, Blob reimbReceipt, Integer ersUsersFkAuth, String authorFirstName, String authorLastName, Integer ersUsersFkReslvr, String resolverFirstName, String resolverLastName, String reimbStatus, String reimbType) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.ersUsersFkAuth = ersUsersFkAuth;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.ersUsersFkReslvr = ersUsersFkReslvr;
        this.resolverFirstName = resolverFirstName;
        this.resolverLastName = resolverLastName;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
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

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Integer getErsUsersFkReslvr() {
        return ersUsersFkReslvr;
    }

    public void setErsUsersFkReslvr(Integer ersUsersFkReslvr) {
        this.ersUsersFkReslvr = ersUsersFkReslvr;
    }

    public String getResolverFirstName() {
        return resolverFirstName;
    }

    public void setResolverFirstName(String resolverFirstName) {
        this.resolverFirstName = resolverFirstName;
    }

    public String getResolverLastName() {
        return resolverLastName;
    }

    public void setResolverLastName(String resolverLastName) {
        this.resolverLastName = resolverLastName;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public String getReimbType() {
        return reimbType;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }

    @Override
    public String toString() {
        return "ReimbursementView{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbReceipt=" + reimbReceipt +
                ", ersUsersFkAuth=" + ersUsersFkAuth +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", ersUsersFkReslvr=" + ersUsersFkReslvr +
                ", resolverFirstName='" + resolverFirstName + '\'' +
                ", resolverLastName='" + resolverLastName + '\'' +
                ", reimbStatus='" + reimbStatus + '\'' +
                ", reimbType='" + reimbType + '\'' +
                '}' + "\n";
    }
}
