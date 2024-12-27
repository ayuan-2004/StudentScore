package com.score.boot.service.impl;

import com.score.boot.dao.TScoreMapper;
import com.score.boot.model.dto.Pagedto;
import com.score.boot.model.dto.scoredto;
import com.score.boot.model.vo.Scorevo;
import com.score.boot.model.vo.TotalPerformance;
import com.score.boot.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.score.boot.service.IScoreService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoreServiceImpl implements IScoreService {
	@Autowired
	private TScoreMapper tScoreMapper;


	@Override public PageResult<Scorevo> selectAllScore(Pagedto pagedto) {
		//总条数
		Long total = tScoreMapper.scoreTotal();
		//计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
		int offset=(pagedto.getPageNum()-1)*pagedto.getPageSize();
		List<Scorevo> scorevos = tScoreMapper.selectAllScore(pagedto.getPageSize(), offset);
		return new PageResult<>(scorevos,pagedto.getPageNum(),pagedto.getPageSize(),total);
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

	@Override
	public PageResult<TotalPerformance> selectTotalPerformance(Pagedto pagedto) {
		Long total = tScoreMapper.TotalPerformance();
		//计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
		int offset=(pagedto.getPageNum()-1)*pagedto.getPageSize();
		List<TotalPerformance> totalPerformances = tScoreMapper.selectTotalPerformance(pagedto.getPageSize(), offset);
		return new PageResult<>(totalPerformances,pagedto.getPageNum(),pagedto.getPageSize(),total);
	}


	@Override public List<TotalPerformance> selectScoreByStudentName(String studentName) {
		List<TotalPerformance> totalPerformances = tScoreMapper.selectScoreByStudentName(studentName);
		if (totalPerformances != null){
			return totalPerformances;
		}else {
			return null;
		}
	}

	@Override public List<Scorevo> selectScoreByStudent(String studentName) {
		List<Scorevo> scorevos = tScoreMapper.selectScoreByStudent(studentName);
		if (scorevos != null){
			return scorevos;
		}else {
			return null;
		}
	}

	@Override public List<TotalPerformance> selectTotalPerformanceById(int studentId) {
		List<TotalPerformance> totalPerformances = tScoreMapper.selectTotalPerformanceById(studentId);
		if (totalPerformances != null){
			return totalPerformances;
		}else {
			return null;
		}
	}

	@Override public List<Scorevo> selectStudentAllScore(int studentId) {
		List<Scorevo> scorevos = tScoreMapper.selectStudentAllScore(studentId);
		if (scorevos != null){
			return scorevos;
		}else {
			return null;
		}
	}
}
