package com.score.boot.dao;

import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TScoreMapper {
	//查询所有成绩
	//成绩类别1习题 2测验 3考试

	List<Scorevo> selectAllScore();
	//修改成绩
	int updateScore(@Param("scoredto") scoredto scoredto);
	//添加成绩
	@Insert("insert into t_score value (null,#{scoredto.scoreValue},#{scoredto.scoreType},#{scoredto.studentId})")
	int addScore(@Param("scoredto") scoredto scoredto);
	//删除
	@Delete("delete from t_score where score_id=#{scoredto.scoreId}")
	int dalateScore(@Param("scoredto") scoredto scoredto);
	//查询学生总成绩
	List<TotalPerformance> selectTotalPerformance();
	//模糊查询--总成绩
	List<TotalPerformance> selectScoreByStudentName(String studentName);
	//模糊查询--学生成绩
	List<Scorevo> selectScoreByStudent(String studentName);
}