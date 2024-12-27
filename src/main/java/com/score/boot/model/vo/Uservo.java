package com.score.boot.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uservo {
	private String username;
	private String token;

	public Uservo(String username) {
		this.username = username;
	}
}
