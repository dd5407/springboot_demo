package com.ddpzp.springboot_demo.controller;

import com.ddpzp.springboot_demo.pojo.Item;
import com.ddpzp.springboot_demo.service.DataSourceService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dd
 * Date 2018/10/23 0:44
 */
@Controller
public class FirstController {
    @Resource
    DataSourceService dataSourceService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        List<Item> all = dataSourceService.getAll(1);
        for (Item item : all) {
            System.out.println(item);
        }
        List<Item> all1 = dataSourceService.getAll(2);
        for (Item item : all) {
            System.out.println(item);
        }
        return "Success";
    }
}
