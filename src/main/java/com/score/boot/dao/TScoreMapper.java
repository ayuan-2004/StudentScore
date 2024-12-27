package com.score.boot.dao;

import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TScoreMapper {

	//统计总数量
	Long scoreTotal();
	//查询所有成绩
	//成绩类别1习题 2测验 3考试

	List<Scorevo> selectAllScore(@Param("pageSize") Integer pageSize,
	                             @Param("offset") Integer offset);
	//修改成绩
	int updateScore(@Param("scoredto") scoredto scoredto);
	//添加成绩
	int addScore(@Param("scoredto") scoredto scoredto);
	//删除
	@Delete("delete from t_score where score_id=#{scoredto.scoreId}")
	int dalateScore(@Param("scoredto") scoredto scoredto);
	//学生总成绩的总数
	Long TotalPerformance();
	//查询学生总成绩
	List<TotalPerformance> selectTotalPerformance(@Param("pageSize") Integer pageSize,
	                                              @Param("offset") Integer offset);
	//模糊查询--总成绩
	List<TotalPerformance> selectScoreByStudentName(String studentName);
	//模糊查询--学生成绩
	List<Scorevo> selectScoreByStudent(String studentName);

	//学生个人总成绩查询
	List<TotalPerformance> selectTotalPerformanceById(int studentId);

	//学生端个人成绩信息查询
	List<Scorevo> selectStudentAllScore(int studentId);
}