package com.score.boot.controller;

import com.score.boot.model.dto.Studentdtn;
import com.score.boot.util.ResponseUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//教师搜索学生姓名下拉框
@RestController
@RequestMapping("/student")
public class srechStudenController {
	@RequestMapping("/srechName")
	public ResponseUtils srecherName(@RequestBody Studentdtn studentdtn){
		return null;
	}
}
