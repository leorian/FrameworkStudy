package com.leorain.json.test;
/**
 * 
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.sf.json.JSONObject;

import com.leorain.service.StuInfoService;
import com.leorain.util.Util;
import com.opensymphony.xwork2.ActionSupport;
 
public class StuIdJudgeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1339403739798171497L;
	
	@Autowired
	@Qualifier("stuInfoServiceImpl")
	private StuInfoService stuInfoService;
	
	private String stuId;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String execute() throws Exception {
		int intJudge = -1;
		if(stuId==null || stuId.trim().equals("") || !Util.isNumeric(stuId))
		{
			
		}
		else
		{
		  intJudge = stuInfoService.isExisits(Integer.parseInt(stuId));
		}
		 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("intJudge", intJudge);
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		return SUCCESS;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
}
