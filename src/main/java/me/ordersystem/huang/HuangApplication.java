package me.ordersystem.huang;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class HuangApplication {

    //log
    private static final Logger log = LoggerFactory.getLogger(HuangApplication.class);

    //数据库配置获取
    @Value("${springboot.driver}")
    private String springbootDriverClass;
    @Value("${springboot.url}")
    private String springbootUrl;
    @Value("${springboot.username}")
    private String springbootUsername;
    @Value("${springboot.password}")
    private String springbootPassword;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        //新建一个数据源
        DataSource dataSource = new DataSource();
        //加载配置
        dataSource.setDriverClassName(springbootDriverClass);
        dataSource.setUrl(springbootUrl);
        dataSource.setUsername(springbootUsername);
        dataSource.setPassword(springbootPassword);
        //日志输出url
        log.info("url" + dataSource.getUrl());
        //返回数据库
        return dataSource;
    }

    public static void main(String[] args) {

        SpringApplication.run(HuangApplication.class, args);
    }


}
