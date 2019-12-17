import com.qfedu.pojo.Emp;
import com.qfedu.service.EmpService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import	java.lang.annotation.Target;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
    @Autowired
    EmpService empService;

    @org.junit.Test
    public void TestLogin(){
        Emp emp = new Emp();
        emp.setNo("123");
        emp.setPass("321");
        Emp login = empService.login(emp);
        System.out.println(login);
    }

}
