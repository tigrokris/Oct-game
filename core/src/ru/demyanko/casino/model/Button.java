package ru.demyanko.casino.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * Created by Dmitriy on 27.09.2017.
 */
class Button extends GameContentUnit {
    private Texture texture;
    private Animation animation;
    private TextureRegion[] frames;
    private TextureRegion currentFrame;
    private static final int FRAME_ROWS=12;
    private static final int FRAME_COLS=1;
    private float stateTime;

    Button(float screenWidth, float bottomPanelHeight,String textureName) {
        setWidth( screenWidth/4);
        setHeight(bottomPanelHeight/2);
        texture=new Texture(textureName);
        setX(screenWidth/2-getWidth()/2);
        setY(bottomPanelHeight/2-getHeight()/2);
        createAnimation(texture);
    }

    private void createAnimation(Texture texture){
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/FRAME_COLS, texture.getHeight()/FRAME_ROWS);
        frames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                frames[index++] = tmp[i][j];
            }
        }
        animation = new Animation(0.08f, frames);
        stateTime = 0f;
        currentFrame = (TextureRegion) animation.getKeyFrame(stateTime, true);
    }
    @Override
    public void draw(SpriteBatch batch){
        batch.draw(currentFrame ,getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void update() {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = (TextureRegion) animation.getKeyFrame(stateTime, true);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }


}
