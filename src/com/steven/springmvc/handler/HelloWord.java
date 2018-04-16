package com.steven.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWord {
	
	/**
	 * 1.使用@RequestMapping注解来映射请求的URl
	 * 返回值会通过解析器为实际的物理视图，对于InternalResourceViewResolver视图解析器，
	 * 会做如下解析：prefix+returnVal+后缀 这样的方式得到实际物理视图，然后做转发操作
	 * 
	 *WBB-INF/views/SUCCESS.jsp
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String sayHello() {
		System.out.println("hello world");
		return "success";
	}
}
