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
	 * @return ѧ���Ƿ����
	 * 
	 * */
	public int isExisits(int stuId);
	
	/**
	 * @author xiezhonggui
	 * @param stuInfo
	 * @return void  ����ѧ����Ϣ
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
	 * @return ����ĳһ��ѧ����Ϣ
	 * 
	 * */
	public void updateStuInfo(StuInfo stuInfo);
	
	/**
	 * @author xiezhonggui
	 * @param stuId
	 * @return void
	 * ɾ��һ��ѧ����Ϣ
	 * 
	 * */
	public void delStuInfo(int stuId);
}
