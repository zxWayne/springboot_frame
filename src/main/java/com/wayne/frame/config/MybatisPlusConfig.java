package com.wayne.frame.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xzhang
 * @date 2019-12-11 12:45
 **/
@Configuration
@MapperScan("com.zx.springboottest.dao*")
public class MybatisPlusConfig {

}