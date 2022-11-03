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
            value = "API 테스트",
            notes = "API 테스트를 진행합니다."
    )
    @GetMapping({"/starcoin/{address}"})
    public ResponseEntity<StarcoinCountResponse> findStarcoinCount(@ApiParam(value = "아이디 주소",required = true, example = "0x1234") @PathVariable String address) {
        StarcoinCountResponse starcoinCountResponse = new StarcoinCountResponse();
        starcoinCountResponse.count = this.gameService.getStarcoinCount(address);
        return new ResponseEntity(starcoinCountResponse, HttpStatus.OK);
    }
}
