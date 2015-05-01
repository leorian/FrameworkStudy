/**
 * 
 */
package com.leorain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leorain.dao.StuInfoDao;
import com.leorain.domain.StuInfo;
import com.leorain.service.StuInfoService;

/**
 * @author xiezhonggui
 *
 */
@Service
public class StuInfoServiceImpl implements StuInfoService {
	
	@Autowired
	@Qualifier("hibernateStuInfoDaoImpl")
	private StuInfoDao stuInfoDao;

	@Override
	public int isExisits(int stuId) {
		return stuInfoDao.isExisits(stuId);
	}

	@Override
	public void saveStuInfo(StuInfo stuInfo) {
		stuInfoDao.saveStuInfo(stuInfo);
	}

	@Override
	public StuInfo getStuInfo(int stuId) {
		return stuInfoDao.getStuInfo(stuId);
	}

	@Override
	public void updateStuInfo(StuInfo stuInfo) {
		stuInfoDao.updateStuInfo(stuInfo);
	}

	@Override
	public void delStuInfo(int stuId) {
		stuInfoDao.delStuInfo(stuId);
	}

}
