package com.score.boot.model.dto;

import lombok.Data;

@Data
public class Pagedto {
	private Integer pageNum = 1; // 当前页
	private Integer pageSize = 10; // 一页显示10条
}
