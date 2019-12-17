package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

  private long id;
  private String no;
  private String pass;
  private String name;
  private long did;
  private long flag;
  private String sex;
  private String email;
  private String qq;
  private String phone;
  private String createdate;
  private String photo;
  private long del;

  private Depart depart;
}
