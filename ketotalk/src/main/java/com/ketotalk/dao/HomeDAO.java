package com.ketotalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ketotalk.dto.DiseaseListDTO;
import com.ketotalk.dto.UserDTO;
import com.ketotalk.dto.YoutubeDTO;

@Mapper
public interface HomeDAO {
	List<YoutubeDTO> selectYoutubeList() throws Exception;
	
	List<DiseaseListDTO> selectDiseaseList(DiseaseListDTO disease) throws Exception;
	
	UserDTO selectUserUniqueId(@Param("uniqueId") String uniqueId) throws Exception;
	
	int insertUser(UserDTO user) throws Exception;
	
	DiseaseListDTO selectDiseaseDetail(@Param("key") String key) throws Exception;
	
	List<DiseaseListDTO> selectDiseaseSearch(DiseaseListDTO disease) throws Exception;
}
