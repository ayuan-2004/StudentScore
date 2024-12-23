package com.score.boot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class scoredto {
	private int scoreId;
	private int scoreValue;
	private String studentName;
	private String scoreType;
	private int studentId;
}
