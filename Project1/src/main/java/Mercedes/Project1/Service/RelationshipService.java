package Mercedes.Project1.Service;

import Mercedes.Project1.Entities.Employee;
import Mercedes.Project1.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee) {

        if ((employeeRepo.findById((String.valueOf(employee.getEmployeeId())))).isEmpty()) {
            employeeRepo.save(employee);
            if(employeeRepo.findById(employee.getManagerId()).isEmpty()){
                Employee employee1 = new Employee(employee.getManagerId(),employee.getManagerName(),"","");
                employeeRepo.save(employee1);
            }
        }
        else{
            if(employeeRepo.findById(employee.getManagerId()).isEmpty()){
                employeeRepo.save(employee);
                Employee employee1 = new Employee(employee.getManagerId(),employee.getManagerName(),"","");
                employeeRepo.save(employee1);
            }
            else{
                throw new RuntimeException();
            }

        }
    }

    public List<Employee> getAllEmployees() {
       return (List<Employee>) employeeRepo.findAll();
    }

}
