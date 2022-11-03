package starrynight.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starrynight.api.dto.game.StarcoinCountResponse;
import starrynight.api.dto.game.StoryListResponse;
import starrynight.api.service.GameService;

@RestController
@RequestMapping({"/game"})
public class GameController {
    private static final Logger log = LoggerFactory.getLogger(GameController.class);
    final GameService gameService;
    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    @ApiOperation(
            value = "스타코인 개수 조회",
            notes = "현재 보유중인 스타코인의 개수를 조회한다."
    )
    @GetMapping({"/starcoin/id/{id}"})
    public ResponseEntity<StarcoinCountResponse> findStarcoinCount(@ApiParam(value = "회원아이디PK번호",required = true, example = "1") @PathVariable Long id) {
        StarcoinCountResponse starcoinCountResponse = new StarcoinCountResponse();
        starcoinCountResponse.count = this.gameService.getStarcoinCount(id);
        return new ResponseEntity(starcoinCountResponse, HttpStatus.OK);
    }

    @ApiOperation(
            value = "스토리 목록 받기",
            notes = "회원의 스토리 목록을 받는다."
    )
    @GetMapping({"/storylist/id/{id}"})
    public ResponseEntity<StoryListResponse> findStorylist(@ApiParam(value = "회원아이디PK번호", required = true, example = "1") @PathVariable Long id){
        StoryListResponse storyListResponse = new StoryListResponse();
        gameService.setInitialGameInfor(id);
        storyListResponse.stories = gameService.getStoryList(id);
        return new ResponseEntity(storyListResponse, HttpStatus.OK);
    }
}
