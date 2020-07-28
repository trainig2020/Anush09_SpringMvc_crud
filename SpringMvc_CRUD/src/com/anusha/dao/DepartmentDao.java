package com.anusha.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anusha.model.Department;
@Repository
@Transactional
public class DepartmentDao {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Department> getAllDepartments(){
		System.out.println("In Dao");
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}
	
	public void insertDepartment(Department department) {
		sessionFactory.getCurrentSession().saveOrUpdate(department);
	}
	
	public void deleteDepartment(int DeptID) {
		Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, DeptID);
		if(department != null) {
			this.sessionFactory.getCurrentSession().delete(department);
		}
	}	
}
