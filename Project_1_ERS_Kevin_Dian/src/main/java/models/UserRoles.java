package models;

/**
 * @author Kevin Dian
 */

public class UserRoles {

    Integer ersRoleId;
    String ersRole;

    public UserRoles() {
    }

    public UserRoles(Integer ersRoleId, String ersRole) {
        this.ersRoleId = ersRoleId;
        this.ersRole = ersRole;
    }

    public Integer getErsRoleId() {
        return ersRoleId;
    }

    public void setErsRoleId(Integer ersRoleId) {
        this.ersRoleId = ersRoleId;
    }

    public String getErsRole() {
        return ersRole;
    }

    public void setErsRole(String ersRole) {
        this.ersRole = ersRole;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "ersRoleId=" + ersRoleId +
                ", ersRole='" + ersRole + '\'' +
                '}'+ "\n";
    }
}
