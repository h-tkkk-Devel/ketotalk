package com.ketotalk.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ketotalk.dao.HomeDAO;
import com.ketotalk.dto.DiseaseListDTO;
import com.ketotalk.dto.UserDTO;
import com.ketotalk.dto.YoutubeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"KETOTALK API 정보 제공 Controller"})
@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.ketotalk.dao")
public class HomeController {
	
	@Autowired
	private HomeDAO homeDao;
	
	@ApiOperation("유튜브 리스트 조회")
	@ApiResponses({
		@ApiResponse(code=200, message="성공")
		, @ApiResponse(code=404, message="잘못된 요청")
		, @ApiResponse(code=500, message="서버 ERROR")
	})
	@GetMapping("/getYoutubeList")
	public List<YoutubeDTO> youtubeList() throws Exception {
		List<YoutubeDTO> youtubeList = homeDao.selectYoutubeList();
		return youtubeList;
	}
	
	@ApiOperation("질환 백과 리스트 조회")
	@ApiImplicitParam(name="type", value="카테고리 타입")
	@ApiResponses({
		@ApiResponse(code=200, message="성공")
		, @ApiResponse(code=404, message="잘못된 요청")
		, @ApiResponse(code=500, message="서버 ERROR")
	})
	@PostMapping("/diseaseList")
	public List<DiseaseListDTO> getDiseaseList(@RequestBody String type) throws Exception {
		String str = type.replaceAll("\"", "");
		List<DiseaseListDTO> diseaseList = homeDao.selectDiseaseList(str);
		return diseaseList;
	}
	
	@ApiOperation("질환 백과 상세정보 조회")
	@ApiImplicitParam(name="key", value="질환백과 번호")
	@ApiResponses({
		@ApiResponse(code=200, message="성공")
		, @ApiResponse(code=404, message="잘못된 요청")
		, @ApiResponse(code=500, message="서버 ERROR")
	})
	@PostMapping("/diseaseDetail")
	public DiseaseListDTO getDiseaseDetail(@RequestParam String key) throws Exception {
		DiseaseListDTO list = homeDao.selectDiseaseDetail(key);
		return list;
	}
	
	@ApiOperation("해당 디바이스 유저 정보 기입")
	@ApiResponses({
		@ApiResponse(code=200, message="성공")
		, @ApiResponse(code=404, message="잘못된 요청")
		, @ApiResponse(code=500, message="서버 ERROR")
	})
	@PostMapping("/insertUser")
	public String insertUser(@RequestBody @ApiParam(value = "회원 한 명의 정보를 갖는 객체", required = true) UserDTO user) throws Exception {
		String nextView = "defaultQ";
		int result = homeDao.insertUser(user);
		return nextView;
	}
	
	@ApiOperation("디바이스 기준 회원 조회")
	@ApiImplicitParam(name="uniqueId", value="회원 디바이스 고유 번호")
	@PostMapping("/selectUniqueId")
	public UserDTO selectUniqueId(@RequestBody String uniqueId) throws Exception {
		UserDTO user = homeDao.selectUserUniqueId(uniqueId);
		user.setUser_id(uniqueId);
		return user;
	}
}
