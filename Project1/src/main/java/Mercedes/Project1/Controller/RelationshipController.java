package Mercedes.Project1.Controller;

import Mercedes.Project1.Entities.Employee;
import Mercedes.Project1.Service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try{
            relationshipService.addEmployee(employee);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Id Already Exists",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllEmployees")
    public List<Employee> fetchEmployees(){
       return relationshipService.getAllEmployees();
    }
}
