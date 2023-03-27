package com.atguigu.admin.controller;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos
                         ) throws IOException {
        log.info("上传的信息：email:{},username:{},headerImg:{},photos:{}",email,username,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("H:\\" +originalFilename));
        }
        if(photos.length > 0){
            for (MultipartFile photo: photos){
                if (! photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("H:\\" +originalFilename));
                }
            }
        }
        return "main";
    }

    @RequestMapping("/download")
    public String download() throws IOException {
        String fileName = "homework.jpg";
    String src = "src\\main\\resources\\homeworkS.jpg";
    String def = "D:\\homework.jpg";
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    bis = new BufferedInputStream(new FileInputStream(src));
    bos = new BufferedOutputStream(new FileOutputStream(def));
        byte[] buff = new byte[1024];
        int readLen = 0;
        try {
            while (((readLen) = bis.read(buff)) != -1){
                bos.write(buff,0,readLen);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (bis != null){
                bis.close();
            }
            if (bos != null){
                bos.close();
            }
        }
        return "redirect:/form_layouts";
//    if (!StringUtils.isBlank(fileName)){
//        File file = new File("src\\main\\resources\\homeworkS.jpg");
//        if (file.exists()){
//            response.setContentType("application/force-download");//强制下载不打开
//            response.addHeader("Content-Disposition",fileName);
//            byte[] buff = new byte[1024];
//            BufferedInputStream bis = null;
//            OutputStream os = null;
//            try {
//                os = response.getOutputStream();
//                bis = new BufferedInputStream(new FileInputStream(file));
//                int i = bis.read(buff);
//                while (i != -1){
//                    os.write(buff,0,buff.length);
//                    os.flush();
//                    i = bis.read(buff);
//                }
//                log.info("下载成功");
//                return"redirect:/form_layouts";
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                if (bis != null){
//                    try {
//                        bis.close();
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }
//    }
//        log.info("下载失败");
//    return "redirect:/form_layouts";
    }
}
