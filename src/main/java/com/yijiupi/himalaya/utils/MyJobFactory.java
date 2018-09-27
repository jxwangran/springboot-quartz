/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.himalaya.utils;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**    
* @Title: MyJobDetailFactory.java  
* @Package com.yijiupi.himalaya.utils  
* @Description: 
* @author wangran 
* @date 2018年9月27日 上午10:11:16  
* @version V1.0    
*/
@Component
public class MyJobFactory extends AdaptableJobFactory {
	
	@Autowired
	private AutowireCapableBeanFactory beanFactory;
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object jobInstance = super.createJobInstance(bundle);
		beanFactory.autowireBean(jobInstance);
		return jobInstance;
	}
	
}
