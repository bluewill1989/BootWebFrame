package com.wzn.bootwebframe.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/index")
    public String index() {
//        return "Hello World";
        return "/index";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("已经进入index里面的hello中来了");
        return "buttonlink";
    }

    @RequestMapping(value = "/gethello",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject gethello() {
        System.out.println("进入到gethello中来了");
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("errCode","0000");
        ret.put("errInfo","成功");

        return JSONObject.fromObject(ret);
    }
}
