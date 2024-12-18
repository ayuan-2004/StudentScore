package com.score.boot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studentdtn {
	private int studentNo;
	private String studentName;
	private String stuPass;
	private String studentSex;
}
