package com.qfedu.controller;


import com.qfedu.pojo.Emp;
import com.qfedu.pojo.Loginlog;
import com.qfedu.service.EmpService;
import com.qfedu.service.LoginlogService;
import com.qfedu.utils.PageUtils;
import com.qfedu.utils.ResultMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    LoginlogService loginlogService;

@RequestMapping("/emp_login")
@ResponseBody
    public ResultMessage login(Emp emp,String ip,String cityAndAddress, HttpServletResponse response, HttpSession session){
        ResultMessage message=null;
        response.setContentType("text/html;charset=utf-8");
    System.out.println("登录的对象是"+emp);
    Emp login = empService.login(emp);
    System.out.println(login);
    System.out.println("ip:"+ip+"city:"+cityAndAddress);
    if (login!=null){
            if(login.getFlag()==1){
                session.setAttribute("login",login);
                //登录IP信息
                Loginlog loginlog = new Loginlog(ip, emp.getNo(), cityAndAddress);
                int count = loginlogService.addLoginLog(loginlog);
                System.out.println(count>0?"日志新增成功":"日志新增失败");
                message=new ResultMessage(200,"登录成功");
            }else {
                message=new ResultMessage(300,"账号已被禁用，联系管理员解除");
            }
    }else {
        message=new ResultMessage(500,"账号密码错误");
    }
    return message;
    }
    @ResponseBody
    @RequestMapping("/getLoginLog")
    public List<Loginlog> getLoginLogs(HttpSession session){
    return loginlogService.getLoginLog(((Emp)session.getAttribute("login")).getNo());
    }

    @ResponseBody
    @RequestMapping("/addEmp")
    public ResultMessage addEmp(Emp emp){
        ResultMessage resultMessage=null;
        int count = empService.addEmp(emp);
        if(count>0){
            resultMessage = new ResultMessage(200,"员工新增成功");
        }else {
            resultMessage = new ResultMessage(500,"员工新增失败");
        }
        return resultMessage;
    }
    @RequestMapping("/getEmps/{pageIndex}/{pageSize}")
    public String  getEmps(@PathVariable("pageIndex") long pageIndex, @PathVariable("pageSize") long pageSize, Model model){
        int totalCount = empService.getEmpCount();
        List<Emp> emps = empService.getEmps((pageIndex - 1) * pageSize, pageSize);
        PageUtils pageUtils = new PageUtils(pageIndex, pageSize, totalCount, emps);
        model.addAttribute("pageUtils",pageUtils);
        return "emplist";


    }




}
