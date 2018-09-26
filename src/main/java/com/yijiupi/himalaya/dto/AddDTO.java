/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.himalaya.dto;

import java.io.Serializable;

/**    
* @Title: AddDTO.java  
* @Package com.yijiupi.himalaya.dto  
* @Description: 
* @author wangran 
* @date 2018年9月26日 下午4:18:33  
* @version V1.0    
*/
public class AddDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jobClassName;
	
	private String jobGroupName;
	
	private String cronExpression;

	public String getJobClassName() {
		return jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	
	
	
}
