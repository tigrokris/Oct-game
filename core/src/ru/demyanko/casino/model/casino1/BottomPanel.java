package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ru.demyanko.casino.model.AbstractGameContentUnit;


/**
 * Created by Dmitriy on 27.09.2017.
 */
class BottomPanel extends AbstractGameContentUnit {
    private TextureRegion texture;
    BottomPanel(float x, float y, float width, float height,TextureRegion textureRegion) {
        super(x, y, width, height);
        texture =textureRegion;
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

    }
}
