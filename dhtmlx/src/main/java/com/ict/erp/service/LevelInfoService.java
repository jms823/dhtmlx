package com.ict.erp.service;

import java.util.List;

import com.ict.erp.vo.LevelInfo;

public interface LevelInfoService {
	public List<LevelInfo> selectLevelInfoList(LevelInfo li);
	public LevelInfo selectLevelInfo(LevelInfo li);
	public int insertLevelInfoList(List<LevelInfo> liList);
	public int updateLevelInfo(LevelInfo li);
	public int deleteLevelInfo(int liNum);
	public int getLinum();
}
