package com.ketotalk.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketotalk.dao.HomeDAO;
import com.ketotalk.dto.DiseaseListDTO;
import com.ketotalk.dto.UserDTO;
import com.ketotalk.dto.YoutubeDTO;

@RestController
@MapperScan(basePackages = "com.ketotalk.dao")
public class HomeController {
	
	@Autowired
	private HomeDAO homeDao;
	
	@RequestMapping("/home")
	public List<YoutubeDTO> youtubeList() throws Exception {
		List<YoutubeDTO> youtubeList = homeDao.selectYoutubeList();
		return youtubeList;
	}
	
	@PostMapping("/diseaseList")
	public List<DiseaseListDTO> getDiseaseList(@RequestBody String type) throws Exception {
		System.out.println("드러ㅏ오ㅓㅁ");
		String str = type.replaceAll("\"", "");
		List<DiseaseListDTO> diseaseList = homeDao.selectDiseaseList(str);
		return diseaseList;
	}
	
	@PostMapping("/test")
	public DiseaseListDTO getDiseaseDetail(@RequestBody String key) throws Exception {
		System.out.println("키 번호 :" + key);
		DiseaseListDTO list = homeDao.selectDiseaseDetail(key);
		System.out.println(list.getDisease_symptom());
		return list;
	}
	
	
	@PostMapping("/insertUser")
	public String insertUser(@RequestBody UserDTO user) throws Exception {
		String nextView = "defaultQ";
		System.out.println("유저정보 :" + user.getUser_id());
		int result = homeDao.insertUser(user);
		System.out.println(result);
		return nextView;
	}
	
	@PostMapping("/selectUniqueId")
	public UserDTO selectUniqueId(@RequestBody String uniqueId) throws Exception {
		UserDTO user = homeDao.selectUserUniqueId(uniqueId);
		user.setUser_id(uniqueId);
		return user;
	}
}
