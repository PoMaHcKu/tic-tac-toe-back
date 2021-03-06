package com.herokuapp.crosses.controller;

import com.herokuapp.crosses.model.Coordinates;
import com.herokuapp.crosses.model.Game;
import com.herokuapp.crosses.service.IGameService;
import com.herokuapp.crosses.service.impl.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.herokuapp.crosses.WebConstants.*;

@RestController
@RequestMapping(GAME_ENDPOINT)
public class GameController {

    private final IGameService gameService;

    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(NEW_ENDPOINT)
    public Game createNewGame() {
        return gameService.createGame();
    }

    @GetMapping(JOIN_ENDPOINT + SEPARATOR + "{id}")
    public Game joinGame(@PathVariable int id) {
        return gameService.joinGame(id);
    }

    @GetMapping
    public Map<String, Game> getGames() {
        return gameService.getGames();
    }

    @PostMapping(STEP_ENDPOINT + SEPARATOR + "{gameId}")
    public GameService.GameResponse doStep(@PathVariable int gameId, @RequestBody Coordinates target) {
        return gameService.doStep(gameId, target);
    }
}