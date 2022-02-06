package com.ssafy.api.controller;


import com.ssafy.api.dto.MeetingLogDto;
import com.ssafy.api.dto.StaffDto;
import com.ssafy.api.request.StaffRequest;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.service.StaffService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.model.response.ListResult;
import com.ssafy.common.model.response.SingleResult;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.Staff;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {


    @Autowired
    StaffService staffService;


    @Autowired
    PasswordEncoder passwordEncoder;


    // 아이디 중복 확인
    @GetMapping("/{id}")
    @ApiOperation(value = "아이디 중복확인", notes = "<strong>이미 존재하는 아이디인지 확인한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "사용 가능한 아이디", response = UserLoginPostRes.class),
            @ApiResponse(code = 409, message = "이미 존재하는 아이디", response = BaseResponseBody.class),
            @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<BaseResponseBody> checkId(@PathVariable(value = "id") String id) {

        boolean b = staffService.checkId(id);
        System.out.println(b);
        if (b) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "사용 가능한 아이디"));
        } else {
            return ResponseEntity.status(409).body(BaseResponseBody.of(409, "이미 존재하는 아이디"));
        }

    }


    //회원 가입
    @PostMapping("/signup")
    @ApiOperation(value = "아이디 중복확인", notes = "<strong>이미 존재하는 아이디인지 확인한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원가입 성공", response = UserLoginPostRes.class),
            @ApiResponse(code = 400, message = "비밀번호가 일치하지 않습니다", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<BaseResponseBody> register(@RequestBody StaffRequest request) {

        if (!request.getPassword().equals(request.getPasswordConfirmation())) {
            return ResponseEntity.status(400).body(BaseResponseBody.of(400, "비밀번호가 일치하지 않습니다 "));
        } else {


            request.setPassword(passwordEncoder.encode(request.getPassword()));

            staffService.register(request);
            return ResponseEntity.status(201).body(BaseResponseBody.of(201, "회원가입 성공"));

        }

    }


    //로그인
    @PostMapping("/login")
    @ApiOperation(value = "아이디 중복확인", notes = "<strong>이미 존재하는 아이디인지 확인한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원가입 성공", response = UserLoginPostRes.class),
            @ApiResponse(code = 400, message = "비밀번호가 일치하지 않습니다", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<UserLoginPostRes> login(@RequestBody StaffRequest request) {

        // db에 존재하는 계정인지 확인
        String userId = request.getUserId();
        String password = request.getPassword();


        Staff result = staffService.getStaffByStaffId(userId);

        if (result == null) {
            return ResponseEntity.status(404).body(UserLoginPostRes.of(404, "존재하지 않는 계정입니다", null));
        }


        if (passwordEncoder.matches(password, result.getPassword())) {

            return ResponseEntity.status(401).body(UserLoginPostRes.of(200, "로그인 성공", JwtTokenUtil.getToken(userId, "staff")));


        } else {
            return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "유효하지 않은 비밀번호입니다", null));

        }


    }


    //내 정보 조회
    @GetMapping("/me")
    @ApiOperation(value = "내 정보 조회", notes = "<strong>이미 존재하는 아이디인지 확인한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원가입 성공", response = UserLoginPostRes.class),
            @ApiResponse(code = 400, message = "비밀번호가 일치하지 않습니다", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<SingleResult<StaffDto>> getStaffInfo(@ApiIgnore Authentication authentication) {


        /**
         * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
         * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.

         */

        SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
        String userId = userDetails.getStaffId();

        StaffDto result = staffService.getStaffDtoByStaffId(userId);


        return ResponseEntity.status(200).body(new SingleResult<>(200, "성공", result));


    }


    //내 정보 수정
    @PutMapping("/me")
    @ApiOperation(value = "내 정보 조회", notes = "<strong>이미 존재하는 아이디인지 확인한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원가입 성공", response = UserLoginPostRes.class),
            @ApiResponse(code = 400, message = "비밀번호가 일치하지 않습니다", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<BaseResponseBody> updateStaffInfo(@ApiIgnore Authentication authentication, @RequestBody StaffDto dto) {


        /**
         * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
         * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.

         */


        SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
        String userId = userDetails.getStaffId();
        dto.setUserId(userId);


        staffService.updateStaff(dto);


        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "성공"));

    }


    //내 상담기록 목록 조회
    @GetMapping("/meeting-logs")
    @ApiOperation(value = "상담기록 목록 조회", notes = "<strong>이미 존재하는 아이디인지 확인한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원가입 성공", response = UserLoginPostRes.class),
            @ApiResponse(code = 400, message = "비밀번호가 일치하지 않습니다", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<ListResult<MeetingLogDto>> getMeetingLog(@ApiIgnore Authentication authentication) {


        /**
         * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
         * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.

         SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
         String userId = userDetails.getUsername();

         */

        // 위의 과정을 통해 유저 아이디를 뽑아냈다고 가정
        SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
        String userId = userDetails.getStaffId();

        StaffDto staff = staffService.getStaffDtoByStaffId(userId);
        List<MeetingLogDto> result = staffService.getMeetingLogList(staff.getId());


        return ResponseEntity.status(200).body(new ListResult<>(200, "성공", result));


    }


}