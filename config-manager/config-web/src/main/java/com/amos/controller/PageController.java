package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by chenlunwei on 2018/2/8.
 */
@Controller
@RequestMapping(value = "/")
public class PageController {

	@RequestMapping(value = "/")
	public String showIndex(){
		return "forward:config/addConfig";
	}



	@RequestMapping(value = "/config/{page}")
	public String getPage(@PathVariable("page")String page,HttpServletRequest request){
		return page;
	}


}
