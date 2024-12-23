package com.score.boot.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TScore {

  private int scoreId;
  private int scoreValue;
  private String scoreType;
  private int studentId;
}
