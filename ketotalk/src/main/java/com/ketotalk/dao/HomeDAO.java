package com.ketotalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ketotalk.dto.DiseaseListDTO;
import com.ketotalk.dto.QuestionDTO;
import com.ketotalk.dto.ResultDeseaseDTO;
import com.ketotalk.dto.ResultQnAVO;
import com.ketotalk.dto.UserChoiceHistoryDTO;
import com.ketotalk.dto.UserDTO;
import com.ketotalk.dto.UserInfoVO;
import com.ketotalk.dto.YoutubeDTO;

@Mapper
public interface HomeDAO {
	List<YoutubeDTO> selectYoutubeList() throws Exception;
	
	List<DiseaseListDTO> selectDiseaseList(DiseaseListDTO disease) throws Exception;
	
	List<UserInfoVO> selectUserUniqueId(@Param("uniqueId") String uniqueId) throws Exception;
	
	int insertUser(UserDTO user) throws Exception;
	
	DiseaseListDTO selectDiseaseDetail(@Param("key") String key) throws Exception;
	
	List<DiseaseListDTO> selectDiseaseSearch(DiseaseListDTO disease) throws Exception;
	
	int insertUserHistory(UserChoiceHistoryDTO choice) throws Exception;
	
	int deleteUserHistory(@Param("choiceSeq") int choiceSeq) throws Exception;
	
	List<ResultQnAVO> firstQuestion(@Param("orderNo") int orderNo) throws Exception;
	
	List<ResultQnAVO> q1SelectQuestion(ResultQnAVO qna) throws Exception;
	
	QuestionDTO selectQuestionRull(@Param("qSeq") int qSeq) throws Exception;
	
	List<ResultQnAVO> selectQuestionRull1(ResultQnAVO qna) throws Exception;
	
	List<ResultQnAVO> selectQuestionRull2(ResultQnAVO qna) throws Exception;
	
	List<ResultQnAVO> selectQuestionRull3(ResultQnAVO qna) throws Exception;
	
	List<ResultQnAVO> selectQuestionRull4(ResultQnAVO qna) throws Exception;
	
	List<ResultQnAVO> selectQuestionLastInput(ResultQnAVO qna) throws Exception; 
	
	int choiceHistoryUpdate(UserChoiceHistoryDTO user) throws Exception;
	
	UserChoiceHistoryDTO selectUserChoiceHistory(@Param("choiceSeq") int choiceSeq) throws Exception;
	
	List<ResultDeseaseDTO> selectResultData(ResultDeseaseDTO data) throws Exception;
	
	int insertUserResultDeseaseName(UserChoiceHistoryDTO user) throws Exception;
}
