package com.eosine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eosine.util.base.StringEscapeEditor;

/**
 * 基础控制器
 * 
 * 其他控制器继承此控制器防止XSS攻击的功能
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/BaseController")
public class BaseController {

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		/**
		 * 防止XSS攻击
		 */
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true, true, false));
	}
}
