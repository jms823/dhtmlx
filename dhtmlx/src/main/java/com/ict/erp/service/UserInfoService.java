package com.ict.erp.service;

import java.util.List;

import com.ict.erp.vo.UserInfo;

public interface UserInfoService {
	public List<UserInfo> selectUserInfoList(UserInfo ui);
	public UserInfo selectUserInfo(UserInfo ui);
	public int insertUserInfo(UserInfo ui);
	public int updateUserInfo(UserInfo ui);
	public int deleteUserInfo(int uiNum);
}
