package com.ict.erp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("li")
@Data
public class LevelInfo {
	private int linum;
	private int lilevel;
	private String liname;
	private String lidesc;
}