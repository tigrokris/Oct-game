package ru.demyanko.casino.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dmitriy on 27.09.2017.
 */
public abstract class AbstractGameContentUnit {
    private float x, y;
    private float width, height;

    abstract public void draw(SpriteBatch spriteBatch);

    abstract public void update();

    abstract public void dispose();

    protected AbstractGameContentUnit() {
    }

    public AbstractGameContentUnit(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public AbstractGameContentUnit(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isClicked(Input input, Graphics graphics) {
        float touchPositionY = graphics.getHeight() - input.getY();
        if (touchPositionY < y || touchPositionY > y + getHeight())
            return false;
        if (input.getX() < x || input.getX() > x + getWidth())
            return false;
        return true;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
