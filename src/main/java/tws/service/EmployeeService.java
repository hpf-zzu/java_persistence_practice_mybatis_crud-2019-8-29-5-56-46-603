package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import tws.DTO.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO getEmployeeDesc(String id){
        Employee employee = employeeMapper.selectOne(id);

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employee.setId(employee.getId());
        employee.setAge(employee.getAge());
        employee.setName(employee.getName());

        String desc = String.format("name: %s,age: %s",employee.getName(),employee.getAge());
        employeeDTO.setDescription(desc);
        return employeeDTO;

    }

}
