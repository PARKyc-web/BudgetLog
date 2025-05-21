package io.github.parkyc.budgetlog.common.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CommonRes<T> {

  private final T data;
  private final boolean success;
  private final String code;
  private final String message;

  public CommonRes(){
    this.data = null;
    this.success = false;
    this.code = "500 Internal Server Error";
    this.message = "500 Internal Server Error";
  }

  public CommonRes(T data){
    this.data = data;
    this.success = true;
    this.code = "200 OK";
    this.message = "200 OK";
  }

  public CommonRes(String code, String message){
    this.data = null;
    this.success = false;
    this.code = code;
    this.message = message;
  }

}
