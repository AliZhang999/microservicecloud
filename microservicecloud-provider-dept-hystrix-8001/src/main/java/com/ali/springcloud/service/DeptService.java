package com.ali.springcloud.service;

import com.ali.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
	
	boolean add(Dept dept);
	Dept get(Long id);
	List<Dept> list();
	
}
