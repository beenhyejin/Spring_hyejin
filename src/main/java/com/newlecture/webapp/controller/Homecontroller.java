package com.newlecture.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/*")
public class Homecontroller {
		@RequestMapping("index")
		@ResponseBody
		public String index() {
			return "�ȳ��ϼ���";
			//return "/WEB-INF/views/index.jsp";
		}
}
