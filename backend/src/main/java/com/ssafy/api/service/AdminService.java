package com.ssafy.api.service;


import com.ssafy.api.dto.AreaDto;
import com.ssafy.api.dto.StaffDto;
import com.ssafy.api.dto.DeskDto;
import com.ssafy.api.dto.PostDto;
import com.ssafy.db.entity.Desks;
import com.ssafy.db.entity.Staff;

import java.util.List;

public interface AdminService {

    Staff getStaffById(String userId);  //admin 로그인에 사용하는 함수

    List<StaffDto> getConsultantList(); // 상담사 목록 조회
    StaffDto getConsultant(int id); //  // 상담사 상세정보 조회
    boolean updateConsultant(int id, StaffDto dto); // 상담사 정보 수정


    int deskRegister(DeskDto dto);  // 데스크 등록  int가 맞나..
    List<DeskDto> getDeskList(); // 데스크 목록 조회
    DeskDto getDesk(int id);  //데스크 정보 조회
    int deskUpdate(DeskDto dto, int id); // 데스크 정보 수정



    /////////////////////////////////

    Desks findByDeskId(String id);


    /////////////////////////////////


    //게시글 목록 조회
    List<PostDto> getPostList();

    //게시글 조회
    PostDto getPost(long id);


    //게시글 삭제
    boolean postDelete(long id);



    //지역 목록 조회
    List<AreaDto> getAreas();

}