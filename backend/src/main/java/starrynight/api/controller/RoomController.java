package starrynight.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starrynight.api.dto.room.RoomInfo;
import starrynight.api.service.RoomService;

    /*
    @author 신슬기
    @since 2022. 11. 07.
    */

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @ApiOperation(value = "방 정보 변경", notes = "방의 가구 구성을 변경한다.")
    @PostMapping("/id/{id}")
    public ResponseEntity<RoomInfo> saveRoom(@ApiParam(value = "방에 대한 정보") @RequestBody RoomInfo roomInfo, @PathVariable Long id) {
        roomService.saveRoom(id, roomInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "방 정보 조회", notes = "방의 정보를 조회한다.", response = RoomInfo.class)
    @GetMapping("/id/{id}")
    public ResponseEntity<RoomInfo> searchRoom(@ApiParam(value = "아이디", required = true) @PathVariable Long id) {
        RoomInfo response = roomService.searchRoom(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "초기 방 세팅(임시 API)", notes = "회원가입시 기본 가구 정보 세팅")
    @GetMapping("temp/id/{id}")
    public ResponseEntity<Long> makeRoom(@ApiParam(value = "지갑 주소", required = true) @PathVariable Long id) {
        roomService.makeRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
