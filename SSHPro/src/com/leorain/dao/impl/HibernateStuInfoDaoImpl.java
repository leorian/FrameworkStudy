/**
 * 
 */
package com.leorain.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.leorain.dao.StuInfoDao;
import com.leorain.domain.StuInfo;

/**
 * @author xiezhonggui
 *
 */
@Repository
public class HibernateStuInfoDaoImpl implements StuInfoDao {
	private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public int isExisits(int stuId) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Object o = session.createSQLQuery("SELECT COUNT(*) FROM stuInfo WHERE stuId = ?;").setParameter(0, stuId).uniqueResult();
		ts.commit();
		session.close();
		return Integer.parseInt(o.toString());
	}

	@Override
	public void saveStuInfo(StuInfo stuInfo) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(stuInfo);
		session.flush();
		ts.commit();
		session.close();
		 
	}

	@Override
	public StuInfo getStuInfo(int stuId) { 
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		StuInfo stuInfo = (StuInfo) session.get(StuInfo.class, stuId);
		ts.commit();
		session.close();
		return stuInfo;
	}

	@Override
	public void updateStuInfo(StuInfo stuInfo) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.update(stuInfo);
		ts.commit();
		session.close();
	}

	@Override
	public void delStuInfo(int stuId) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		StuInfo stuInfo = (StuInfo) session.get(StuInfo.class, stuId);
		session.delete(stuInfo);
		ts.commit();
		session.close();
	}
	
}
