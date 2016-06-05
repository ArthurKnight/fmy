package com.fmy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

	@RequestMapping(value="/hello")
	@Scope("prototype")
	public String sayHello(){
		System.out.println("spring say hello");
		return "hello";
	}
	
	@RequestMapping("/back")
	@ResponseBody
	public Map<String, Object> backData(){
		List<String> bookList=new ArrayList<String>();
		bookList.add("Java核心技术卷1");
		bookList.add("Java核心技术卷2");
	/*	JSONObject jsonObj = new JSONObject();
		jsonObj.put("book1", "Java核心技术卷1");*/
		Map<String, Object>map=new HashMap<String,Object>();
		map.put("m", bookList);
		return map;
	}
	
	@RequestMapping(value="/backJson",method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String backJson(){
		List<String> bookList=new ArrayList<String>();
		bookList.add("Java核心技术卷1");
		bookList.add("Java核心技术卷2");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("book1", "Java核心技术卷1");
		jsonObj.put("book2", bookList);
		return jsonObj.toString();
	}
}
