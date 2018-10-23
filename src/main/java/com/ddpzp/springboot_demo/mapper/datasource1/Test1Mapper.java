package com.ddpzp.springboot_demo.mapper.datasource1;

import com.ddpzp.springboot_demo.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dd
 * Date 2018/10/23 0:47
 */

public interface Test1Mapper {
    List<Item> getAll();
}
