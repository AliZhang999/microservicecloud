package com.ali.springcloud.controller;

import com.ali.springcloud.entities.Dept;
import com.ali.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController_Consumer {
	
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	//private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
	
	//@Autowired
	//private RestTemplate restTemplate;

	@Autowired
	private DeptClientService service;
	
	@PostMapping("consumer/dept/add")
	public boolean add(Dept dept) {
		//return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
		return service.add(dept);
	}
	
	@GetMapping("consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		//return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
		return service.get(id);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("consumer/dept/list")
	public List<Dept> list(){
		//return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
		return service.list();
	}
	
	@RequestMapping("consumer/dept/discovery")
	public Object discovery() {
		//return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
		return service.discovery();
	}
	
}
