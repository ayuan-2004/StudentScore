package com.score.boot.service.impl;

import com.score.boot.dao.TScoreMapper;
import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.score.boot.service.IScoreService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoreServiceImpl implements IScoreService {
	@Autowired
	private TScoreMapper tScoreMapper;

	@Override
	public List<Scorevo> selectAllScore() {
		List<Scorevo> scorevos = tScoreMapper.selectAllScore();
		if (scorevos != null){
			return scorevos;
		}else {
			return new ArrayList<>();
		}
	}

	@Override public int updateScore(scoredto scoredto) {
		int i = tScoreMapper.updateScore(scoredto);
		if (i > 0){
			return 1;
		}else {
			return 0;
		}
	}

	@Override public int addScore(scoredto scoredto) {
		int i = tScoreMapper.addScore(scoredto);
		if (i > 0){
			return 1;
		}else {
			return 0;
		}
	}

	@Override public int dalateScore(scoredto scoredto) {
		int i = tScoreMapper.dalateScore(scoredto);
		if (i > 0){
			return 1;
		}else {
			return 0;
		}
	}

	@Override public List<TotalPerformance> selectTotalPerformance() {
		List<TotalPerformance> totalPerformances = tScoreMapper.selectTotalPerformance();
		if (totalPerformances != null){
			return totalPerformances;
		}else {
			return new ArrayList<>();
		}
	}

	@Override public List<TotalPerformance> selectScoreByStudentName(String studentName) {
		List<TotalPerformance> totalPerformances = tScoreMapper.selectScoreByStudentName(studentName);
		if (totalPerformances != null){
			return totalPerformances;
		}else {
			return new ArrayList<>();
		}
	}

	@Override public List<Scorevo> selectScoreByStudent(String studentName) {
		List<Scorevo> scorevos = tScoreMapper.selectScoreByStudent(studentName);
		if (scorevos != null){
			return scorevos;
		}else {
			return new ArrayList<>();
		}
	}
}
