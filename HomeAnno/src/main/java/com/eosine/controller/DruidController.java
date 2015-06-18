package com.eosine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据源控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/druidController")
public class DruidController extends BaseController {

	@RequestMapping("/druid")
	public String druid(){
		return "redirect:/druid/index.html";
	}
	
	@RequestMapping("/druid2")
	public String druid2(){
		return "success";
	} 
}
