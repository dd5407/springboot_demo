package com.ddpzp.springboot_demo.service.serviceImpl;

import com.ddpzp.springboot_demo.mapper.datasource1.Test1Mapper;
import com.ddpzp.springboot_demo.mapper.datasource2.Test2Mapper;
import com.ddpzp.springboot_demo.pojo.Item;
import com.ddpzp.springboot_demo.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dd
 * Date 2018/10/23 0:49
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {
    @Resource
    Test1Mapper test1Mapper;
    @Resource
    Test2Mapper test2Mapper;

    @Override
    public List<Item> getAll(int type) {
        List<Item> all;
        if (type == 1) {
            System.out.println("get from test1");
            all = test1Mapper.getAll();
        } else {
            System.out.println("get from test2");
            all = test2Mapper.getAll();
        }
        return all;
    }
}
