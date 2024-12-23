package com.score.boot.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scorevo {
	private int scoreId;
	private int scoreValue;
	private String scoreType;
	private int studentId;
	private String studentName;
	private String scoreTypeName;
}
