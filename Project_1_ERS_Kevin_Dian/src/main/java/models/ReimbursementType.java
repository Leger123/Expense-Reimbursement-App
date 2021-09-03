package models;

/**
 * @author Kevin Dian
 */

public class ReimbursementType {
    Integer reimbTypeId;
    String reimType;

    public ReimbursementType(){
    }

    public ReimbursementType(Integer reimbTypeId, String reimType) {
        this.reimbTypeId = reimbTypeId;
        this.reimType = reimType;
    }

    public Integer getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(Integer reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    public String getReimType() {
        return reimType;
    }

    public void setReimType(String reimType) {
        this.reimType = reimType;
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "reimbTypeId=" + reimbTypeId +
                ", reimType='" + reimType + '\'' +
                '}'+ "\n";
    }
}

