package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

public class ControllerClass {
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	@ResponseBody
	public String display() {
		return "Welcome to SpringBoot!";
	}
	
	

	@RequestMapping(value="/view-html",method=RequestMethod.GET)
	@ResponseBody
	public String displayHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head><title>MyPage</title></head>");
		sb.append("<body><marquee>Welcome...</marquee></body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	@RequestMapping(value="/view-jsp",method=RequestMethod.GET)
	public String displayJsp() {
		return "Sample";
	}
	
	
}
