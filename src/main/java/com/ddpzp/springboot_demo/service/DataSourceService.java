package com.ddpzp.springboot_demo.service;

import com.ddpzp.springboot_demo.pojo.Item;

import java.util.List;

/**
 * Created by dd
 * Date 2018/10/23 0:45
 */
public interface DataSourceService {
    List<Item> getAll(int type);
}
