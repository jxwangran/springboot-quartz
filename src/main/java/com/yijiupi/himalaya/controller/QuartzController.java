/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.himalaya.controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijiupi.himalaya.dto.AddDTO;
import com.yijiupi.himalaya.utils.ClazzUtils;

/**
 * @Title: QuartzController.java
 * @Package com.yijiupi.himalaya.controller
 * @Description:
 * @author wangran
 * @date 2018年9月26日 下午3:41:21
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/job")
public class QuartzController {

	@Autowired
	@Qualifier("Scheduler")
	private Scheduler scheduler;

	@PostMapping(value = "/addjob")
	public void addjob(@RequestBody AddDTO dto) throws Exception {
		JobDetail jobDetail = JobBuilder.newJob(ClazzUtils.getClass(dto.getJobClassName()).getClass())
				.withIdentity(dto.getJobClassName(), dto.getJobGroupName()).build();
		jobDetail.getJobDataMap().put("name", "wangran");
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(dto.getCronExpression());
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(dto.getJobClassName(), dto.getJobGroupName())
				.withSchedule(scheduleBuilder).build();
		try {
			scheduler.scheduleJob(jobDetail, cronTrigger);
		} catch (Exception e) {
			System.err.println("创建失败");
		}
	}

}
