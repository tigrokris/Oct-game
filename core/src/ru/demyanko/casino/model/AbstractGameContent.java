package ru.demyanko.casino.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import ru.demyanko.casino.model.casino1.GameContentUnit;

/**
 * Created by Dmitriy on 27.09.2017.
 */
abstract public class AbstractGameContent implements GameContent {
    protected float screenWidth;
    protected float screenHeigth;
    protected Graphics graphics;

    protected Array<GameContentUnit> gameContentUnits;

    public AbstractGameContent(Graphics graphics) {
        this.screenWidth = graphics.getWidth();
        this.screenHeigth = graphics.getHeight();
        this.graphics=graphics;
        gameContentUnits = new Array();
    }
    @Override
    public abstract void create();
    @Override
    public abstract GameContentUnit getStartUnit();
    @Override
    public void draw(SpriteBatch batch){
        for (GameContentUnit unit : gameContentUnits) {
            unit.draw(batch);
        }
    }
    @Override
    public void update(){
        for (GameContentUnit unit : gameContentUnits) {
            unit.update();
        }
    }
    @Override
    public void dispose(){
        for (GameContentUnit unit : gameContentUnits) {
            unit.dispose();
        }
    }



}
