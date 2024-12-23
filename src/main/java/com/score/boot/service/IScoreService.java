package com.score.boot.service;

import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScoreService {
	List<Scorevo> selectAllScore();
	int updateScore(scoredto scoredto);
	int addScore(scoredto scoredto);
	int dalateScore(scoredto scoredto);
	//查询学生总成绩
	List<TotalPerformance> selectTotalPerformance();
	//模糊查询
	List<TotalPerformance> selectScoreByStudentName(String studentName);
	//模糊查询--学生成绩
	List<Scorevo> selectScoreByStudent(String studentName);
}
