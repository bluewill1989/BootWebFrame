//package com.wzn.bootwebframe.controller;
//
//import com.wzn.bootwebframe.common.util.FtpUtil;
//import com.wzn.bootwebframe.maintain.IBatch;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * DESCRIPTION:
// *
// * @author will
// * @create 2018-11-14 10:18
// */
//@RestController
//@Slf4j
//public class FtpController {
//
//    @Autowired
//    private FtpUtil ftpUtil;
//
//    @Autowired
//    private IBatch iBatch;
//
//    @RequestMapping(value = "/upload", method = RequestMethod.POST,produces = "application/json")
////    @ResponseBody
//    public Map<String, String> uploadImg(@RequestBody String fileName) throws FileNotFoundException {
//        Map<String, String> map = new HashMap<>();
//        map.put("code", "0");
//        map.put("msg", "上传文件失败");
//        JSONObject jsonObject = JSONObject.fromObject(fileName);
//        String realName = jsonObject.getString("fileName");
//        String filePath = "d://ftptest//"+realName;
//        log.info("上传文件:{}", filePath);
//        File file = new File(filePath);
//        InputStream inputStream = new FileInputStream(file);
//        Boolean flag = ftpUtil.uploadFile(realName, inputStream);
//        if (flag == true) {
//            log.info("上传文件成功!");
//            map.put("code", "1");
//            map.put("msg", "上传文件成功");
//        }
//        map.put("path", filePath);
//        return map; //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
//    }
//
//
//
//
//    @RequestMapping(value = "/uploadbygroovy")
//    public String uploadByGroovy() throws FileNotFoundException {
//        String args[] = new String[2];
//        args[1] = "5.txt";
//        args[0] = "uploadgroovy.groovy";
//        String result = "FAILED";
//        try {
//            int number = iBatch.execute(args);
//            log.info("number={}",number);
//            result = "SUCCESS";
//        } catch (Exception e) {
//            log.error("error!!!");
//        }
//        return result;
//    }
//}