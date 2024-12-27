package com.score.boot.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class studentVo {
	private String studentname;
	private String token;

	public studentVo(String studentname) {
		this.studentname = studentname;
	}
}
