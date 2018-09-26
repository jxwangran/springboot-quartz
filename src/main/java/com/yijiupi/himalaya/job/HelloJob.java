/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.himalaya.job;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**    
* @Title: HelloJob.java  
* @Package com.yijiupi.himalaya.job  
* @Description: 
* @author wangran 
* @date 2018年9月26日 下午3:35:09  
* @version V1.0    
*/
@Component
@DisallowConcurrentExecution //比如此任务需耗时7秒，却配置5秒执行一次，注解后将会7秒才运行一次,任务上家注解
public class HelloJob implements BaseJob {

	Logger logger = LoggerFactory.getLogger(HelloJob.class);
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.error("HelloJob 开始执行");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.error("HelloJob : " + new Date() + " result : " + context.getResult()+ "  mapValue : " + context.getJobDetail().getJobDataMap().getString("name"));
		logger.error("HelloJob 执行结束");
	}

}
