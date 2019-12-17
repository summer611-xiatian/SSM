package com.qfedu.controller;

import com.qfedu.pojo.Depart;
import com.qfedu.service.DepartService;
import com.qfedu.utils.PageUtils;
import com.qfedu.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DepartController {
        @Autowired
        DepartService departService;

        @ResponseBody
        @RequestMapping("/addDepart")
        public ResultMessage addDepart(Depart depart){
                ResultMessage resultMessage=null;
                System.out.println(depart);
                int count = departService.addDepart(depart);
                if(count>0){
                        resultMessage = new ResultMessage(200, "新增成功");
                }else {
                        resultMessage = new ResultMessage(500, "新增失败");
                }
                return resultMessage;
        }
        @RequestMapping("/getDepart/{pageIndex}/{pageSize}")
        public String  getDeparts(@PathVariable("pageIndex") long pageIndex, @PathVariable("pageSize") long pageSize, Model model){
                int totalCount = departService.getDepartCount();
                List<Depart> departs = departService.getDeparts((pageIndex - 1) * pageSize, pageSize);
                PageUtils pageUtils = new PageUtils(pageIndex,pageSize,totalCount,departs);
                model.addAttribute("pageUtils",pageUtils);
                return "departlist";
        }
        @ResponseBody
        @RequestMapping("/deleteDepart")
        public ResultMessage deleteDepart(int id){
                ResultMessage resultMessage = null;
                int count = departService.deleteDepart(id);
                if(count>0){
                        resultMessage = new ResultMessage(200, "部门删除成功");
                }else {
                        resultMessage = new ResultMessage(500, "部门删除失败");
                }
                return resultMessage;
        }
        @ResponseBody
        @RequestMapping("/findDeparts")
        public List<Depart> findDeparts(){
                return departService.findDeparts();
        }
}
