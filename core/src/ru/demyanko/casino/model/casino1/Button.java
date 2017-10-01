package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.demyanko.casino.model.AbstractGameContentUnit;


/**
 * Created by Dmitriy on 27.09.2017.
 */
class Button extends AbstractGameContentUnit {
    private Animation<TextureRegion> animation;
    private TextureRegion[] frames;
    private TextureRegion currentFrame;
    private float stateTime;
    private Graphics graphics;
    private TextureAtlas textureAtlas;
    private String texturePrefix;

    Button(float screenWidth, float bottomPanelHeight, TextureAtlas textureAtlas, String texturePrefix, int amountOfFrames, Graphics graphics) {
        this.graphics = graphics;
        this.textureAtlas = textureAtlas;
        this.texturePrefix = texturePrefix;
        setWidth(screenWidth / 4);
        setHeight(bottomPanelHeight / 2);
        setX(screenWidth / 2 - getWidth() / 2);
        setY(bottomPanelHeight / 2 - getHeight() / 2);
        frames = new TextureRegion[amountOfFrames];
        createAnimation();
    }

    private void createAnimation() {
        for (int i = 0; i < frames.length; i++) {
            frames[i] = textureAtlas.findRegion(texturePrefix, i);

        }
        animation = new Animation<>(0.08f, frames);
        //the next line does not work now
        //animation = new Animation<>(0.08f, textureAtlas.findRegion(texturePrefix));
        stateTime = 0f;
        currentFrame = animation.getKeyFrame(stateTime, true);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());

    }

    @Override
    public void update() {
        stateTime += graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime, true);
    }

    @Override
    public void dispose() {
    }


}
