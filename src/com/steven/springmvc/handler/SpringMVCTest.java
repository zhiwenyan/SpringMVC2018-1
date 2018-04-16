package com.steven.springmvc.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.steven.springmvc.entites.User;

@SessionAttributes(value={"user"},types= {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS="success";
	/**
	 * 
	 *@RequestMapping 除了修饰方法之外 还可以修饰类  
	 *
	 * 类定义处：提供初步的请求映射信息。相对于WEB应用的根目录  
	 * 方法处：提供进一步的细分映射信息。相对于类定义处的URL。
	 * 
	 * @return
	 */
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	
	@RequestMapping(value="/testParamsAndHeaders"
			,params= {"username","age!=10"},headers= "contentType=text/*")
	public String testParamsAndHeaders() {
		return SUCCESS;
	}
	
	@RequestMapping("/testAntPath/*/aa")
	public String testAntPath() {
		return SUCCESS;
	}
	
	
	@RequestMapping("testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") int id) {
		System.out.println("testPathVariable="+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable("id") int id) {
		System.out.println("testRest Get="+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest Post");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String testRestDelete(@PathVariable("id") int id) {
		System.out.println("testRest Delete="+id);
		return SUCCESS;
	}
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public String testRestPut(@PathVariable("id") int id) {
		System.out.println("testRest Put="+id);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam 映射请求参数
	 * value  请求参数的参数名
	 * required 该参数是否必须，默认为true
	 * defaultValue 请求参数的默认值
	 * @param username
	 * @param age
	 * @return
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username") String username,
			@RequestParam(value="age",required=false,defaultValue="0") int age) {
		System.out.println("testRequestParam  username="+username+","+"age="+age);
		return SUCCESS;
	}
	/**
	 * @RequestHeader 映射请求头信息
	 * 属性和@RequestParam一样
	 * @param al
	 * @return
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String al) {
		System.out.println("testRequestHeader,Accept-Language="+al);
		return SUCCESS;
	}
	/**
	 * @CookieValue 映射一个Cookie值 
	 * 属性和@RequestParam一样
	 * @param sessionId
	 * @return
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue="+sessionId);
		return SUCCESS;

	}
	/**
	 * SpringMVC 会按请求参数名和POJO属性名进行自动匹配
	 * 自动为该对象填充请求值。支持级联属性。
	 * 如：dept.deptId、dept.address.tel
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo="+user);
		return SUCCESS;
	}
	/**
	 * 可以使用Servlet原生的Api，作为目标方法的参数  
	 * 具体支持以下类型 
	 * 
	 *  • HttpServletRequest
		• HttpServletResponse
		• HttpSession
		• java.security.Principal • Locale
		• InputStream
		• OutputStream
		• Reader
		• Writer
	 * 
	 * @param requset
	 * @param response
	 * @return
	 * 
	 * 
	 */
	@RequestMapping("/testSevletAPI")
	public String testSevletAPI(HttpServletRequest requset,
			HttpServletResponse response) {
		System.out.println("testSevletAPI HttpServletRequest="+requset+
				",HttpServletResponse="+response);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 目标方法的返回值可以是ModelAndView类型  
	 * 其中可以包含视图和模型信息
	 * 
	 * SpringMVC会把ModelAndView的Model中数据放入request域对象中。
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName=SUCCESS;
		ModelAndView modelAndView=new ModelAndView(viewName);
		//添加模型数据到ModelAndView中。
		modelAndView.addObject("time",new Date());
		return modelAndView;
	}
	/**
	 * 目标方法可以添加Map类型（实际上也可以是Model类型或者ModelMap类型）的数据 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("Tom","Jerry","David"));	
		return SUCCESS;
	}
	
	/**
	 * 除了可以通过属性名指定需要放到会话中的属性外， 
	 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSesionAttribute")
	public String testSessionAttributes(Map<String, Object> map) {
		User user=new User("steven","123","1059408192@qq.com",21);
		map.put("user", user);
		map.put("company", "fumi");
		return SUCCESS;
	}
	
	/**
	 * 运行流程
	 * 
	 * 1、执行@ModelAttribute标记的方法：从数据库中取出对象，把对象放入了Map中，键为user
	 * 2、SpringMVC从map中取出user对象，并把表单的请求参数赋给该User对象对应的属性值
	 * 3、SpringMVC把上述对象传入目标方法的参数
	 * 
	 * 注意：在@ModelAttribute修饰的方法中，
	 * 放入到map时的key需要和目标方法入参类型的第一个字母小写的字符串一致！
	 * @param user
	 * @return
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("修改:"+user);
		return SUCCESS;
	}
	
	/**
	 * @ModelAttribute 标记的方法，会在每个目标方法之前被SpringMVC调用
	 * 
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id
			,Map<String, Object> map) {
		if(id!=null) {
			//模拟从数据中获取对象
			User user=new User(1,"Tom","123456","Tom@qq.com",12);
			System.out.println("从数据库中获取一个对象"+user);
			map.put("user", user);
			System.out.println("---");
		}
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public  String testViewAndViewResolver() {
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}	
	
	@RequestMapping("/testView")
	public String testView() {
		System.out.println("testView");
		return "helloView";
	}
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
		
		
		
		
	}
}
