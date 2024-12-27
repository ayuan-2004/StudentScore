package com.score.boot.service;

import com.score.boot.model.dto.Pagedto;
import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import com.score.boot.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScoreService {
	PageResult<Scorevo> selectAllScore(Pagedto pagedto);
	int updateScore(scoredto scoredto);
	int addScore(scoredto scoredto);
	int dalateScore(scoredto scoredto);
	//查询学生总成绩
	PageResult<TotalPerformance> selectTotalPerformance(Pagedto pagedto);
	//模糊查询
	List<TotalPerformance> selectScoreByStudentName(String studentName);
	//模糊查询--学生成绩
	List<Scorevo> selectScoreByStudent(String studentName);
	//学生个人总成绩查询
	List<TotalPerformance> selectTotalPerformanceById(int studentId);
	//学生端个人成绩信息查询
	List<Scorevo> selectStudentAllScore(int studentId);
}
