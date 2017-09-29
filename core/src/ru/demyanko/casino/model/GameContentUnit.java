package ru.demyanko.casino.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Dmitriy on 27.09.2017.
 */
public abstract class GameContentUnit extends Actor{

    abstract public void draw (SpriteBatch spriteBatch);
    abstract public void update ();
    abstract public void dispose ();

    public GameContentUnit() {
    }

    public GameContentUnit(float x, float y) {
        setX(x);
        setY(y);
    }

    public GameContentUnit(float x, float y, float width, float height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public boolean isClicked(Input input, Graphics graphics){
        float touchPositionY=graphics.getHeight()-input.getY();
        if(touchPositionY<getY() || touchPositionY>getY()+getHeight())
            return false;
        if(input.getX()<getX()|| input.getX()>getX()+getWidth())
            return false;
        return true;
    }

}
