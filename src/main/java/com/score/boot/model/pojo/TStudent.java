package com.score.boot.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TStudent {

  private int studentNo;
  private String studentName;
  private String studentSex;
  private String stuPass;
  private int isDelete;
}
