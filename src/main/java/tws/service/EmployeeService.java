package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.DTO.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.ArrayList;
import java.util.List;
@Service
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

    public List<Employee> getListEmployee(int page, int pagesize){
        List<Employee> employees = new ArrayList<>();

        int offset = (page - 1) * pagesize;

        employees = employeeMapper.selectList(offset,pagesize);

        return employees;
    }

    public List<Employee> getLike(String like){
        List<Employee> employees = new ArrayList<>();

        employees = employeeMapper.selectLike(like);

        return employees;
    }

}
