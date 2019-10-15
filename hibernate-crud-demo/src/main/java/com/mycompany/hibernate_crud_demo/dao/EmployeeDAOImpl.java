package com.mycompany.hibernate_crud_demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.modelmapper.ModelMapper;

import com.mycompany.hibernate_crud_demo.factory.MyHibernateFactory;
import com.mycompany.hibernate_crud_demo.model.Employee;
import com.mycompany.hibernate_crud_demo.shared.SharedEmployee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private Session session=null;
	
	
	

	public EmployeeDAOImpl() {
		super();
		
		session=MyHibernateFactory.getMySession();
	}

	@Override
	public void createEmployee(SharedEmployee sEmployee) {
		// TODO Auto-generated method stub
		
		ModelMapper mapper=new ModelMapper();
		Employee employee=mapper.map(sEmployee, Employee.class);
		UUID uUid=UUID.randomUUID();
		employee.setGeneratedId(uUid.toString());
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

	}

	@Override
	public List<SharedEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		ModelMapper mapper=new ModelMapper();
		session.getTransaction().begin();
		Query query=session.createQuery("from Employee");
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Employee> list1=query.getResultList();
		List<SharedEmployee> sList=new ArrayList<SharedEmployee>();
		for(Employee e:list1)
		{
			SharedEmployee se=mapper.map(e, SharedEmployee.class);
			sList.add(se);
		}
		
		return sList;
	}

}
