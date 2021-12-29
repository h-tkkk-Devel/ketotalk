package com.ketotalk.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ketotalk.dao.HomeDAO;
import com.ketotalk.dto.DiseaseListDTO;
import com.ketotalk.dto.QuestionDTO;
import com.ketotalk.dto.ResultDeseaseDTO;
import com.ketotalk.dto.ResultQnAVO;
import com.ketotalk.dto.UserChoiceHistoryDTO;
import com.ketotalk.dto.UserDTO;
import com.ketotalk.dto.UserInfoVO;
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
		
		List<DiseaseListDTO> diseaseList = homeDao.selectDiseaseList(disease);
		
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
	public List<UserInfoVO> selectUniqueId(@RequestBody String uniqueId) throws Exception {
		System.out.println("들어옴?");
		List<UserInfoVO> user = homeDao.selectUserUniqueId(uniqueId);
		user.get(0).setUser_id(uniqueId);
		return user;
	}
	
	@PostMapping("/insertUserHistory")
	public List<ResultQnAVO> insertUserHistory(@RequestBody UserChoiceHistoryDTO choice) throws Exception {
		int choice_seq = homeDao.insertUserHistory(choice);
		int orderNo = choice_seq;
		List<ResultQnAVO> qnaList = homeDao.firstQuestion(orderNo);
		qnaList.get(0).setChoice_seq(choice.getChoice_seq());
		
		return qnaList;
	}
	
	@PostMapping("/deleteUserHistory")
	public int deleteUserHistory(@RequestBody int choiceSeq) throws Exception {
		int result = homeDao.deleteUserHistory(choiceSeq);
		return result;
	}
	
	@PostMapping("/resultDesease")
	public List<ResultDeseaseDTO> q1Selected(@RequestBody int choiceSeq) throws Exception {
		UserChoiceHistoryDTO user = homeDao.selectUserChoiceHistory(choiceSeq);
		
		ResultDeseaseDTO resultData = new ResultDeseaseDTO();
		resultData.setQ_1_selected_seq(user.getQ_1_selected_seq());
		resultData.setQ_2_selected_seq(user.getQ_2_selected_seq());
		resultData.setQ_3_selected_seq(user.getQ_3_selected_seq());
		resultData.setQ_4_selected_seq(user.getQ_4_selected_seq());
		resultData.setQ_5_selected_seq(user.getQ_5_selected_seq());
		resultData.setQ_6_selected_seq(user.getQ_6_selected_seq());
		resultData.setQ_7_selected_seq(user.getQ_7_selected_seq());
		resultData.setQ_8_selected_seq(user.getQ_8_selected_seq());
		resultData.setQ_9_selected_seq(user.getQ_9_selected_seq());
		resultData.setQ_10_selected_seq(user.getQ_10_selected_seq());
		resultData.setQ_11_selected_seq(user.getQ_11_selected_seq());
		resultData.setQ_12_selected_seq(user.getQ_12_selected_seq());
		resultData.setQ_13_selected_seq(user.getQ_13_selected_seq());
		
		List<ResultDeseaseDTO> result = homeDao.selectResultData(resultData);
		
		int yn = 0; 
		String deseaseName = "";
		for(int i = 0; i < result.size(); i++) {
			deseaseName += result.get(i).getResult_desease_name();
		}
		user.setResult_desease_name(deseaseName);
		yn = homeDao.insertUserResultDeseaseName(user);
		
		return result;
	}
	
	@PostMapping("/selectQuestionRull")
	public List<ResultQnAVO> SelectQuestionRull(@RequestBody ResultQnAVO qna) throws Exception {
		UserChoiceHistoryDTO user = new UserChoiceHistoryDTO();
		user.setChoice_seq(qna.getChoice_seq());
		
		switch (qna.getQt_q_seq() - 1) {
		case 1:
			user.setQ_1_selected_seq(qna.getQ1_selected_seq());
			break;
		case 2:
			user.setQ_1_selected_seq(qna.getQ1_selected_seq());
			user.setQ_2_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 3:
			user.setQ_1_selected_seq(qna.getQ1_selected_seq());
			user.setQ_3_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 4:
			user.setQ_4_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 5:
			user.setQ_5_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 6:
			user.setQ_6_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 7:
			user.setQ_7_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 8:
			user.setQ_8_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 9:
			user.setQ_9_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 10:
			user.setQ_10_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 11:
			user.setQ_11_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 12:
			user.setQ_12_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		case 13:
			user.setQ_13_selected_seq(qna.getUpper_q_seq_selected__seq());
			break;
		}
		if(qna.getQt_q_seq() < 14) {
			int result = homeDao.choiceHistoryUpdate(user);			
		}
		
		List<ResultQnAVO> qnaList = null;
		switch (qna.getQt_q_seq()) {
			case 14:
				qnaList = homeDao.selectQuestionLastInput(qna);
				break;
			case 15:
				qnaList = homeDao.selectQuestionLastInput(qna);
				break;
		}
		
		
		for(int i = qna.getQt_q_seq(); i<14; i++ ) {
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
