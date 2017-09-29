package ru.demyanko.casino.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.demyanko.casino.model.GameContentUnit;

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
