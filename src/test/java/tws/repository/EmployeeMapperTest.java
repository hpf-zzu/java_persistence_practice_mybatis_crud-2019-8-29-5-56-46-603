package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.Employee;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeMapper employeeMapper;
    @After
    public void teardown(){
        JdbcTestUtils.deleteFromTables(jdbcTemplate,"employee");
    }
    @Test
    public void shouldFetchAllEmployees(){
        //given
        jdbcTemplate.execute("insert into employee values('1','zhangsan',18)");
        //when
        List<Employee> employeeList = employeeMapper.selectLike("zhangsan");
        //then
        assertEquals(1,employeeList.size());

    }
    @Test
    public void shouldSaveEmployees(){
        //given
        jdbcTemplate.execute("insert into employee values('1','zhangsan',18)");
        //when
        int numbers = JdbcTestUtils.countRowsInTable(jdbcTemplate,"employee");
        //then
        assertEquals(1,numbers);

    }

}
