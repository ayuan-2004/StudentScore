package com.score.boot.controller;

import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import com.score.boot.service.IScoreService;
import com.score.boot.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//学生个人
@RestController
@RequestMapping("/studentscore")
public class StudentScoreController {
	@Autowired
	private IScoreService service;
	@RequestMapping("/selectById")
	public ResponseUtils selectById(@RequestBody scoredto scoredto){
		try {
			List<TotalPerformance> totalPerformances = service.selectTotalPerformanceById(scoredto.getStudentId());
			if (totalPerformances!=null){
				return new ResponseUtils<>(200,"查询成功",totalPerformances);
			}else {
				return new ResponseUtils<>(506,"查询失败");
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}

	}
	@RequestMapping("/selectStudentAllScore")
	public ResponseUtils selectStudentAllScore(@RequestBody scoredto scoredto){
		try {
			List<Scorevo> scorevos = service.selectStudentAllScore(scoredto.getStudentId());
			if (scorevos!=null){
				return new ResponseUtils<>(200,"查询成功",scorevos);
			}else {
				return new ResponseUtils<>(506,"查询失败");
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}

	}
}
