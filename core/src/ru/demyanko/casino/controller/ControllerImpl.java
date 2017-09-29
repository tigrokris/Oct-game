package ru.demyanko.casino.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import ru.demyanko.casino.Game;
import ru.demyanko.casino.model.casino1.GameContent;


/**
 * Created by Dmitriy on 28.09.2017.
 */
public class ControllerImpl implements Controller{

    private GameContent gameContent;
    private Graphics graphics;

    public ControllerImpl(GameContent gameContent, Graphics graphics) {
        this.gameContent = gameContent;
        this.graphics=graphics;
    }
    @Override
    //start barrel spin
    public void start(Input input){
        boolean isStartClicked;
        if(input.isButtonPressed(Input.Keys.LEFT) && (isStartClicked=gameContent.getStartUnit().isClicked(Gdx.input, graphics))){
            Game.isStarted= isStartClicked;
            gameContent.update();
        }
    }
    @Override
    //stop barrel spin when time is over
    public void stop() {
        if(TimeUtils.millis()>Game.stopTime) {
            Game.isStarted=false;
        }
    }
}
