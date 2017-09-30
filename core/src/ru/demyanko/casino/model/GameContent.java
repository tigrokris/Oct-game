package ru.demyanko.casino.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dmitriy on 28.09.2017.
 */
public interface GameContent {
    void create();
    void draw(SpriteBatch spriteBatch);
    void update();
    void dispose();
    void start();
    void stop();
    AbstractGameContentUnit getStartUnit();
}
