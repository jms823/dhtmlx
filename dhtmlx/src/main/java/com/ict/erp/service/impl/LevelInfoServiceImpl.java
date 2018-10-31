package com.ict.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.erp.dao.LevelInfoDAO;
import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@Service
public class LevelInfoServiceImpl implements LevelInfoService {
	@Autowired
	private LevelInfoDAO ldao;
	@Override
	public List<LevelInfo> selectLevelInfoList(LevelInfo li) {
		return ldao.selectLevelInfoList(li);
	}

	@Override
	public LevelInfo selectLevelInfo(LevelInfo li) {
		return ldao.selectLevelInfo(li);
	}

	@Override
	public int updateLevelInfo(LevelInfo li) {
		return ldao.updateLevelInfo(li);
	}

	@Override
	public int deleteLevelInfo(int liNum) {
		return ldao.deleteLevelInfo(liNum);
	}

	@Override
	public int getLinum() {
		return ldao.getLinum();
	}

	@Override
	public int insertLevelInfoList(List<LevelInfo> liList) {
		return ldao.insertLevelInfoList(liList);
	}

}
