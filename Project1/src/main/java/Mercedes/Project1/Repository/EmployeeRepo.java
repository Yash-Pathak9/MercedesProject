package Mercedes.Project1.Repository;

import Mercedes.Project1.Entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,String> {
}
