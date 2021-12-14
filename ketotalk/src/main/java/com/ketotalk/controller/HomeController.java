package com.ketotalk.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ketotalk.dao.HomeDAO;
import com.ketotalk.dto.DiseaseListDTO;
import com.ketotalk.dto.UserDTO;
import com.ketotalk.dto.YoutubeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"KETOTALK API 정보 제공 Controller"})
@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.ketotalk.dao")
public class HomeController {
	
	@Autowired
	private HomeDAO homeDao;
	
	@ApiOperation("유튜브 리스트 조회")
	@PostMapping("/home")
	public List<YoutubeDTO> youtubeList() throws Exception {
		List<YoutubeDTO> youtubeList = homeDao.selectYoutubeList();
		return youtubeList;
	}
	
	@ApiOperation("질환 백과 리스트 조회")
	@PostMapping("/diseaseList")
	public List<DiseaseListDTO> getDiseaseList(@RequestBody String type) throws Exception {
		String str = type.replaceAll("\"", "");
		List<DiseaseListDTO> diseaseList = homeDao.selectDiseaseList(str);
		return diseaseList;
	}
	
	@ApiOperation("질환 백과 상세정보 조회")
	@PostMapping("/test")
	public DiseaseListDTO getDiseaseDetail(@RequestBody String key) throws Exception {
		System.out.println("키 번호 :" + key);
		DiseaseListDTO list = homeDao.selectDiseaseDetail(key);
		System.out.println(list.getDisease_symptom());
		return list;
	}
	
	@ApiOperation("해당 디바이스 유저 정보 기입")
	@PostMapping("/insertUser")
	public String insertUser(@RequestBody UserDTO user) throws Exception {
		String nextView = "defaultQ";
		System.out.println("유저정보 :" + user.getUser_id());
		int result = homeDao.insertUser(user);
		System.out.println(result);
		return nextView;
	}
	
	@ApiOperation("디바이스 기준 회원 조회")
	@PostMapping("/selectUniqueId")
	public UserDTO selectUniqueId(@RequestBody String uniqueId) throws Exception {
		UserDTO user = homeDao.selectUserUniqueId(uniqueId);
		user.setUser_id(uniqueId);
		return user;
	}
}
