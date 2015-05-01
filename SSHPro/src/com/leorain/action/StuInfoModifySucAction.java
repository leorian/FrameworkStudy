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
public class StuInfoModifySucAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7775994508888722981L;
	
	@Autowired
	@Qualifier("stuInfoServiceImpl")
	private StuInfoService stuInfoService;
	
	private StuInfo stuInfo;

	@Override
	public String execute() throws Exception {
		stuInfoService.updateStuInfo(stuInfo);
		ActionContext act = ActionContext.getContext();
		act.getSession().put("modifySucFlag", true);
		return SUCCESS;
	}

	@Override
	public void validate() {
		
	}

	public StuInfo getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(StuInfo stuInfo) {
		this.stuInfo = stuInfo;
	}
	
	
}
