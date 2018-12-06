package com.ali.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.springcloud.dao.DeptDao;
import com.ali.springcloud.entities.Dept;
import com.ali.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptDao dao;

	@Override
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return dao.findAll();
	}

}
