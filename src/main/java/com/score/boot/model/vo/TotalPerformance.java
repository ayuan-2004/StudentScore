package com.score.boot.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//学生总成绩响应数据
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalPerformance {
	private int studentNo;
	private String studentName;
	private double exerciseGrades;//习题成绩
	private double testScore;//测验成绩
	private double examinationResults;//考试成绩
	private double totalScore;//总成绩
}
