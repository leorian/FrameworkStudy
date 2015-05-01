/**
 * 
 */
package com.leorain.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xiezhonggui
 *
 */
public class StuInfoAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7248259179852851476L;
	
	private String stuId;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public void validate() {
		
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	

}
