package com.score.boot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtils<T> {
	private int status;
	private String message;
	private T data;

	public ResponseUtils(int status, String message) {
		this.status = status;
		this.message = message;
	}

	// Getters and setters for code, message, and data

	@Override
	public String toString() {
		return "ResponseUtils{" +
				"code=" + status +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}