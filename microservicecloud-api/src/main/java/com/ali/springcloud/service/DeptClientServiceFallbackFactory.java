package com.ali.springcloud.service;

import com.ali.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("该id:"+id+"找不到对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已关闭")
                        .setDb_source("no database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
