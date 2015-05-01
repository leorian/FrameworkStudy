/**
 * 
 */
package com.leorain.service;

import com.leorain.domain.StuInfo;

/**
 * @author xiezhonggui
 *
 */
public interface StuInfoService {
	/**
	 * @author xiezhonggui
	 * @param stuId
	 * @return 学号是否存在
	 * 
	 * */
	public int isExisits(int stuId);
	
	/**
	 * @author xiezhonggui
	 * @param stuInfo
	 * @return void  保存学生信息
	 *
	 */
	public void saveStuInfo(StuInfo stuInfo);
	
	/**
	 * @author xiezhonggui
	 * @param stuId
	 * @return stuInfo
	 * */
	public StuInfo getStuInfo(int stuId);
	
	/**@author xiezhonggui
	 * @param stuInfo
	 * @return 更新某一条学生信息
	 * 
	 * */
	public void updateStuInfo(StuInfo stuInfo);
	
	/**
	 * @author xiezhonggui
	 * @param stuId
	 * @return void
	 * 删除一条学生信息
	 * 
	 * */
	public void delStuInfo(int stuId);
}
