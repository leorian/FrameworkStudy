/**
 * 
 */
package com.leorain.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.leorain.domain.StuInfo;
import com.leorain.service.StuInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xiezhonggui
 *
 */
public class StuInfoAddSucAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1721598503962235364L;
	
	@Autowired
	@Qualifier("stuInfoServiceImpl")
	private StuInfoService stuInfoService;
	
	private StuInfo stuInfo;

	@Override
	public String execute() throws Exception {
		stuInfoService.saveStuInfo(stuInfo);
		ActionContext act = ActionContext.getContext();
		act.getSession().put("addSucFlag", true);
		return SUCCESS;
	}

	@Override
	public void validate() {
		System.out.println(stuInfo.getStuId()
				+ " " + stuInfo.getStuName() + " " + stuInfo.getStuCellPhone() + " " + stuInfo.getStuAddress());
	}

	public StuInfo getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(StuInfo stuInfo) {
		this.stuInfo = stuInfo;
	}
	

}
