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
import com.ketotalk.dto.QuestionDTO;
import com.ketotalk.dto.ResultQnAVO;
import com.ketotalk.dto.UserChoiceHistoryDTO;
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
	@ApiResponses({
		@ApiResponse(code=200, message="성공")
		, @ApiResponse(code=404, message="잘못된 요청")
		, @ApiResponse(code=500, message="서버 ERROR")
	})
	@PostMapping("/diseaseList")
	public List<DiseaseListDTO> getDiseaseList(@RequestBody DiseaseListDTO disease) throws Exception {
		String str = disease.getDisease_category().replaceAll("\"", "");
		disease.setDisease_category(str);
		System.out.println(str);
		
		List<DiseaseListDTO> diseaseList = homeDao.selectDiseaseList(disease);
		System.out.println(diseaseList.size());
		
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
	public DiseaseListDTO getDiseaseDetail(@RequestBody String key) throws Exception {
		System.out.println(key);
		DiseaseListDTO list= homeDao.selectDiseaseDetail(key);
		return list;
	}
	
	@ApiOperation("질환 백과 검색")
	@ApiResponses({
		@ApiResponse(code=200, message="성공")
		, @ApiResponse(code=404, message="잘못된 요청")
		, @ApiResponse(code=500, message="서버 ERROR")
	})
	@PostMapping("/diseaseSearch")
	public List<DiseaseListDTO> getDiseaseDetail(@RequestBody DiseaseListDTO disease) throws Exception {
		List<DiseaseListDTO> diseaseList = homeDao.selectDiseaseSearch(disease);
		return diseaseList;
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
	
	@PostMapping("/insertUserHistory")
	public List<ResultQnAVO> insertUserHistory(@RequestBody UserChoiceHistoryDTO choice) throws Exception {
		int choice_seq = homeDao.insertUserHistory(choice);
		int orderNo = 1;
		List<ResultQnAVO> qnaList = homeDao.firstQuestion(orderNo);
		qnaList.get(0).setChoice_seq(choice.getChoice_seq());
		
		return qnaList;
	}
	
	@PostMapping("/deleteUserHistory")
	public int deleteUserHistory(@RequestBody int choiceSeq) throws Exception {
		System.out.println("삭제하러옴");
		int result = homeDao.deleteUserHistory(choiceSeq);
		return result;
	}
	
	@PostMapping("/q1Selected")
	public List<ResultQnAVO> q1Selected(@RequestBody ResultQnAVO qna) throws Exception {
		List<ResultQnAVO> qnaList = homeDao.q1SelectQuestion(qna);
		return qnaList;
	}
	
	@PostMapping("/selectQuestionRull")
	public List<ResultQnAVO> SelectQuestionRull(@RequestBody ResultQnAVO qna) throws Exception {
		List<ResultQnAVO> qnaList = null;
		for(int i = qna.getQt_q_seq(); i<13; i++ ) {
			QuestionDTO question = homeDao.selectQuestionRull(i);
			qna.setQt_q_seq(i);
			if(question.getQuestion_rule().equals("1")) {
				qnaList = homeDao.selectQuestionRull1(qna);
			}else if(question.getQuestion_rule().equals("2")) {
				qnaList = homeDao.selectQuestionRull2(qna);
			}else if(question.getQuestion_rule().equals("3")) {
				qnaList = homeDao.selectQuestionRull3(qna);
			}else if(question.getQuestion_rule().equals("4")) {
				qnaList = homeDao.selectQuestionRull4(qna);
			}
			
			if(qnaList.size() != 0) {
				break;
			}
		}
		
		return qnaList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
