/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.himalaya.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**    
* @Title: QuartzConfiguration.java  
* @Package com.yijiupi.himalaya  
* @Description: 
* @author wangran 
* @date 2018年9月26日 下午3:00:55  
* @version V1.0    
*/
@Configuration
public class QuartzConfiguration {
	
	@Autowired
	@Qualifier(value = "primaryDataSource")
	private DataSource primaryDataSource;
	
	@Bean(name="SchedulerFactory")
	public SchedulerFactoryBean initSchedulerFactoryBean() throws IOException {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		factoryBean.setQuartzProperties(quartzProperties());
		factoryBean.setDataSource(primaryDataSource);
		return factoryBean;
	}
	
	@Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
	
	@Bean
	public QuartzInitializerListener initListener() {
		return new QuartzInitializerListener();
	}

	@Bean(name="Scheduler")
	public Scheduler getScheduler() throws IOException {
		return initSchedulerFactoryBean().getScheduler();
	}
	
}
