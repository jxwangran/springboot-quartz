/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.himalaya.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**    
* @Title: OrderService.java  
* @Package com.yijiupi.himalaya.service  
* @Description: 
* @author wangran 
* @date 2018年9月27日 上午9:23:10  
* @version V1.0    
*/
@Service
public class OrderService {

	Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public void sort() {
		logger.error("OrderService 开始执行");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.error("OrderService 执行结束");
	}
	
}
