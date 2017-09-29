package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dmitriy on 28.09.2017.
 */
public interface GameContent {
    void create();
    void draw(SpriteBatch spriteBatch);
    void update();
    void dispose();
    GameContentUnit getStartUnit();
}
