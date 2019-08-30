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

//    @GetMapping("")
//    public ResponseEntity<List<Employee>> getAll() {
//
//
//        return ResponseEntity.ok(employeeMapper.selectAll());
//    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll(@RequestParam(required = false) int page,
                                                 @RequestParam(required = false) int pagesize) {


        return ResponseEntity.ok(employeeService.getListEmployee(page,pagesize));
    }
    @GetMapping("/byName")
    public ResponseEntity<List<Employee>> getLike(@RequestParam(required = false) String like){
        return ResponseEntity.ok(employeeService.getLike(like));

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
