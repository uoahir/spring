package com.bs.spring.demo.service;

import java.util.List;
import java.util.Map;

import com.bs.spring.demo.model.dto.Demo;

public interface DemoService {
	int insertDemo(Demo d);
	List<Demo> selectDemoList(Map<String,Integer> page);
	Demo selectDemoByNo(int no);
	
}
