package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenlunwei on 2018/2/8.
 */
@Controller
@RequestMapping(value = "/")
public class PageController {

	@RequestMapping(value = "/")
	public String showIndex(){
		return "redirect:config/addConfig";
	}



	@RequestMapping(value = "/config/{page}")
	public String getPage(@PathVariable("page")String page){
		return page;
	}


}
