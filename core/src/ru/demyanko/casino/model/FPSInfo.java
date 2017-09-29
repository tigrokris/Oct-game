package ru.demyanko.casino.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dmitriy on 27.09.2017.
 */
class FPSInfo extends GameContentUnit {
    private BitmapFont font;
    private CharSequence strFPS;
    private Graphics graphics;
    public FPSInfo(float x, float y,Graphics graphics) {
        super(x,y);
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        strFPS = "FPS = 0";
        this.graphics=graphics;
    }

    @Override
    public void draw(SpriteBatch batch) {
        font.draw(batch,strFPS,getX(),getY());
    }

    @Override
    public void update() {
        strFPS = "FPS = "+ graphics.getFramesPerSecond();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
