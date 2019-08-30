package tws.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.DTO.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //service mapper instance
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {


        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee){
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employeeMapper.insert(employee);

        return ResponseEntity.created(URI.create("/employees"+employee.getId())).build();
          //      ResponseEntity.created(URI.create("/employee") + employee.getId())).build();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getOne(){
//        Employee employee = employeeMapper.
//
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updataOne(
            @PathVariable String id,
            @RequestBody Employee employee){
        employee.setId(id);
        employeeMapper.updateOne(employee,id);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeWithDTO(@PathVariable String id) {

        return ResponseEntity.ok(employeeService.getEmployeeDesc(id));
    }
}
