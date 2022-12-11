package com.c2k.service.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2k.dao.EmpDao;
import com.c2k.model.Employee;
import com.c2k.service.EmpService;


@Service
public class EmpServiceImpl implements EmpService{
//@Autowired
EmpDao dao;
	@Override
	public Employee saveemp(Employee e) {
		return dao.save(e);
	}

}
