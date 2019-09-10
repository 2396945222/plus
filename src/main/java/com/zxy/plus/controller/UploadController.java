package com.zxy.plus.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/upLoad")
    public Object upLoad(@RequestParam("file") MultipartFile[] files,HttpServletRequest request) {



        String uploadFileName = request.getParameter("fileName");
        try {
            File pathss = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(pathss);
            System.out.println("文件组大小" + files.length);
            for (int i = 0 ; i < files.length;i++){
                MultipartFile file = (MultipartFile) files[i];
                // 获取文件名
                String fileName = file.getOriginalFilename();
                System.out.print("上传的文件名为：" + fileName);
                // 获取文件的后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                System.out.print("文件的后缀名为：" + suffixName);
                // 设置文件存储路径
                String filePath = "F://Nginx//nginx-1.12.2//nginx-1.12.2//html//img//"+uploadFileName+"//";
                String path = filePath + fileName + suffixName;
                File dest = new File(path);
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();// 新建文件夹
                }
                file.transferTo(dest);// 文件写入
            }
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
