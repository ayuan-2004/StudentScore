package com.score.boot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.score.boot.model.dto.Studentdtn;
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


//学生成绩
@RestController
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	private IScoreService scoreService;
	//查询所有学生成绩
	@RequestMapping("/selectAllScore")
	public ResponseUtils selectAll() {
		try{
			List<Scorevo> tScorevos = scoreService.selectAllScore();
			if (tScorevos != null){
				return new ResponseUtils<>(200,"查询成功", tScorevos);
			}else {
				return new ResponseUtils<>(501,"查询失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//修改学生成绩
	@RequestMapping("/updateScore")
	public ResponseUtils updateScore(@RequestBody scoredto scoredto){
		try{
			int i = scoreService.updateScore(scoredto);
			if (i == 1 ){
				return new ResponseUtils<>(200,"修改成功");
			}else {
				return new ResponseUtils<>(304,"修改失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//添加学生成绩
	@RequestMapping("/addscore")
	public ResponseUtils addScore(@RequestBody scoredto scoredto){
		try{
			int i = scoreService.addScore(scoredto);
			if (i == 1 ){
				return new ResponseUtils<>(200,"添加成功");
			}else {
				return new ResponseUtils<>(304,"添加失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//删除学生成绩
	@RequestMapping("/dalateScore")
	public ResponseUtils dalateScore(@RequestBody scoredto scoredto){
		try{
			int i = scoreService.dalateScore(scoredto);
			if (i == 1 ){
				return new ResponseUtils<>(200,"删除成功");
			}else {
				return new ResponseUtils<>(304,"删除失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//查询学生总成绩
	@RequestMapping("/selectTotalPerformance")
	public ResponseUtils selectTotalPerformance(){
		try{
			List<TotalPerformance> totalPerformances = scoreService.selectTotalPerformance();
			if (totalPerformances != null){
				return new ResponseUtils<>(200,"查询成功", totalPerformances);
			}else {
				return new ResponseUtils<>(501,"查询失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//模糊查询--总成绩
	@RequestMapping("/selectScoreByStudentName")
	public ResponseUtils selectScoreByStudentName(@RequestBody Studentdtn studentdtn) {
		try {
			List<TotalPerformance> totalPerformance = scoreService.selectScoreByStudentName(studentdtn.getStudentName());
			if (totalPerformance != null){
				return new ResponseUtils<>(200,"查询成功", totalPerformance);
			}else {
				return new ResponseUtils<>(501,"查询失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//模糊查询--学生成绩
	@RequestMapping("/selectScoreByStudent")
	public ResponseUtils selectScoreByStudent(@RequestBody Studentdtn studentdtn) {
		try {
			List<Scorevo> scorevos = scoreService.selectScoreByStudent(studentdtn.getStudentName());
			if (scorevos != null){
				return new ResponseUtils<>(200,"查询成功", scorevos);
			}else {
				return new ResponseUtils<>(501,"查询失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
