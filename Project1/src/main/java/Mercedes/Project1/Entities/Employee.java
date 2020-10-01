package Mercedes.Project1.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String managerId;
    private String managerName;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String managerId, String managerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
