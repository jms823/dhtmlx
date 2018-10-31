package com.ict.erp.vo;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("ui")
public class UserInfo {
	private int uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String uiDesc;
}
