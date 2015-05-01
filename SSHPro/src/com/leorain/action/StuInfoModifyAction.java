/**
 * 
 */
package com.leorain.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.leorain.domain.StuInfo;
import com.leorain.service.StuInfoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xiezhonggui
 *
 */
public class StuInfoModifyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2627687223638950939L;
	
	@Autowired
	@Qualifier("stuInfoServiceImpl")
	private StuInfoService stuInfoService;
	
	private String stuId;
	
	private StuInfo stuInfo;
	
	@Override
	public String execute() throws Exception {
		stuInfo = stuInfoService.getStuInfo(Integer.parseInt(stuId));
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
	public StuInfo getStuInfo() {
		return stuInfo;
	}
	public void setStuInfo(StuInfo stuInfo) {
		this.stuInfo = stuInfo;
	}

}
