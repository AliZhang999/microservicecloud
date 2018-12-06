package com.ali.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {
	
	private static final long serialVersionUID = -2812648766861980512L;
	
	private Long deptno;
	private String dname;
	private String db_source;

}
