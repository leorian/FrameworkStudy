/**
 * 
 */
package com.leorain.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.leorain.service.StuInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xiezhonggui
 *
 */
public class StuInfoDelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2627687223638950939L;
	
	@Autowired
	@Qualifier("stuInfoServiceImpl")
	private StuInfoService stuInfoService;
	
	private String stuId;
	
	@Override
	public String execute() throws Exception {
		 stuInfoService.delStuInfo(Integer.parseInt(stuId));
		 ActionContext act = ActionContext.getContext();
		 act.getSession().put("delSucFlag", true);
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
