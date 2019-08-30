package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.DTO.EmployeeDTO;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();

    void insert(@Param("employee") Employee employee);
    Employee selectOne(@Param("id") String id);

    List<Employee> selectLike(@Param("keyword") String keyword);

    List<Employee> selectList(@Param("offset") int page, @Param("pagesize") int pagesize);

    void updateOne(@Param("employee") Employee employee, @Param("id") String id);
}
