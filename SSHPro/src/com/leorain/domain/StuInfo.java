/**
 * 
 */
package com.leorain.domain;

import java.io.Serializable;

/**
 * @author xiezhonggui
 *
 */
public class StuInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9053299130564979056L;
	private int stuId;//学号
	private String stuName;//姓名
	private String stuCellPhone;//手机号
	private String stuAddress;//家庭住址
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuCellPhone() {
		return stuCellPhone;
	}
	public void setStuCellPhone(String stuCellPhone) {
		this.stuCellPhone = stuCellPhone;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	

}
