package com.ali.springcloud.controller;

import com.ali.springcloud.entities.Dept;
import com.ali.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
	@Autowired
	DeptService service;

	@Autowired
	DiscoveryClient client;

	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "proceseeHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if(null == dept){
			throw new RuntimeException("该id:"+id+"找不到对应的信息");
		}
		return dept;
	}

	public Dept proceseeHystrix_Get(@PathVariable("id") Long id){
		return new Dept()
				.setDeptno(id).
				setDname("该id:"+id+"找不到对应的信息,null---@HystrixCommand")
				.setDb_source("no database in mysql");
	}

	@GetMapping("/dept/list")
	public List<Dept> list() {
		return service.list();
	}

	@GetMapping(value = "/dept/discovery")
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
