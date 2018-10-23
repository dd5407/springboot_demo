package com.ddpzp.springboot_demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by dd
 * Date 2018/10/22 23:46
 */
@Configuration
public class DatasourceConfig {
    @Bean(value = "datasource1")
    @ConfigurationProperties(prefix = "datasource1")
    public DataSource datasource1(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
    @Bean(value = "datasource2")
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource datasource2(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
    @Bean
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory1(@Qualifier("datasource1") DataSource dataSource1) throws IOException {
        //配置对象
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        //开启驼峰映射
        configuration.setMapUnderscoreToCamelCase(true);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ddpzp.springboot_demo.pojo");
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setDataSource(dataSource1);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/datasource1/*.xml"));
        return sqlSessionFactoryBean;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory2(@Qualifier("datasource2") DataSource dataSource2) throws IOException {
        //配置对象
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        //开启驼峰映射
        configuration.setMapUnderscoreToCamelCase(true);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ddpzp.springboot_demo.pojo");
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setDataSource(dataSource2);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/datasource2/*.xml"));
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ddpzp.springboot_demo.mapper.datasource1");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");
        return mapperScannerConfigurer;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer2(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ddpzp.springboot_demo.mapper.datasource2");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory2");
        return mapperScannerConfigurer;
    }
}
