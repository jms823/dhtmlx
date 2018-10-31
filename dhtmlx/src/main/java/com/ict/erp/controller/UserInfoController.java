package com.ict.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ict.erp.service.UserInfoService;
import com.ict.erp.vo.UserInfo;

//@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService uis;
	@RequestMapping(value="/userinfo",method=RequestMethod.GET)
	public @ResponseBody List<UserInfo> selectUserList(@ModelAttribute UserInfo ui) {
	return uis.selectUserInfoList(ui);
	}
	@RequestMapping(value="/userinfo/{uinum}",method=RequestMethod.GET)
	public @ResponseBody UserInfo selectUser(@ModelAttribute UserInfo ui,@PathVariable Integer uiNum) {
		ui.setUiNum(uiNum);
	return uis.selectUserInfo(ui);
	}
	@RequestMapping(value="/userinfo",method=RequestMethod.POST)
	public @ResponseBody Integer insertUserInfo(@RequestBody UserInfo ui) {
	return uis.insertUserInfo(ui);
	}
	@RequestMapping(value="/userinfo/{uinum}",method=RequestMethod.PUT)
	public @ResponseBody Integer updateUserInfo(@RequestBody UserInfo ui,@PathVariable Integer uiNum) {
	ui.setUiNum(uiNum);
	return uis.updateUserInfo(ui);
	}
	@RequestMapping(value="/userinfo/{linum}",method=RequestMethod.DELETE)
	public @ResponseBody Integer deleteUserInfo(@PathVariable int uiNum) {
	return uis.deleteUserInfo(uiNum);
	}
}
