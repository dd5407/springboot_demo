package com.ddpzp.springboot_demo.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时调度
 */
@Component
@EnableScheduling
public class AutoTaks {
    //cron="0 20 13 * * ?"  每天13:20:00触发
    //cron="*/5 * * * * ?"  每5秒触发一次
    @Scheduled(cron = "0 20 13 * * ?")
    public void test() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"：触发");
    }
}
