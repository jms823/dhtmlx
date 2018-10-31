package com.ict.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.erp.dao.UserInfoDAO;
import com.ict.erp.service.UserInfoService;
import com.ict.erp.vo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDAO udao;
	@Override
	public List<UserInfo> selectUserInfoList(UserInfo ui) {
		return udao.selectUserInfoList(ui);
	}
	@Override
	public UserInfo selectUserInfo(UserInfo ui) {
		return udao.selectUserInfo(ui);
	}
	@Override
	public int insertUserInfo(UserInfo ui) {
		return udao.insertUserInfo(ui);
	}
	@Override
	public int updateUserInfo(UserInfo ui) {
		return udao.updateUserInfo(ui);
	}
	@Override
	public int deleteUserInfo(int uiNum) {
		return udao.deleteUserInfo(uiNum);
	}
}
