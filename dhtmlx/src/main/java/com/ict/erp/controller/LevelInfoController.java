package com.ict.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@Controller
public class LevelInfoController {
	@Autowired
	private LevelInfoService lis;

	@GetMapping("/linum")
	public @ResponseBody Integer getLinum() {
		return lis.getLinum();
	}

	@GetMapping("/levelinfos")
	public @ResponseBody List<LevelInfo> selectLevelInfoList(@ModelAttribute LevelInfo li) {
		return lis.selectLevelInfoList(li);
	}

	@GetMapping("/levelinfos/{linum}")
	public @ResponseBody LevelInfo selectLevelInfo(@ModelAttribute LevelInfo li, @PathVariable Integer linum) {
		li.setLinum(linum);
		return lis.selectLevelInfo(li);
	}
	
	@PostMapping("/levelinfos")
	public @ResponseBody Integer insertLevelInfoList(@RequestBody List<LevelInfo> liList) {
		return lis.insertLevelInfoList(liList);
	}

	@PutMapping("/levelinfos/{linum}")
	public @ResponseBody Integer updateUserInfo(@RequestBody LevelInfo li, @PathVariable Integer linum) {
		li.setLinum(linum);
		return lis.updateLevelInfo(li);
	}

	@DeleteMapping("/levelinfos/{linum}")
	public @ResponseBody Integer deleteUserInfo(@PathVariable int linum) {
		return lis.deleteLevelInfo(linum);
	}
}