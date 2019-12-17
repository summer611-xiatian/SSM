package com.qfedu.controller;
import	java.io.File;


import com.qfedu.utils.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class UploadController {
        @ResponseBody
        @RequestMapping("/upload")
        public ResultMessage upload(MultipartFile file, HttpSession session)throws Exception{
            String ogFilename = file.getOriginalFilename();
            System.out.println("要上传的文件是："+ogFilename);
            //随机文件名
            String[] s = ogFilename.split("\\.");
            String fileName = UUID.randomUUID().toString()+"."+s[s.length-1];
            System.out.println("随机后的文件名:"+fileName);
            //获取文件上传服务器路径
            String realPath = session.getServletContext().getRealPath("/media/upload");
                realPath=realPath+"\\"+fileName;

                //文件上传
            file.transferTo(new File(realPath));
            System.out.println("文件上传成功");
            ResultMessage resultMessage = new ResultMessage(200, fileName);

            return resultMessage;
        }

}
