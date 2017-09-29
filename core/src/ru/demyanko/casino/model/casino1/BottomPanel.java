package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by Dmitriy on 27.09.2017.
 */
class BottomPanel extends GameContentUnit {
    Texture texture;
    BottomPanel(float x, float y, float width, float height,String textureName) {
        super(x, y, width, height);
        texture =new Texture(textureName);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
