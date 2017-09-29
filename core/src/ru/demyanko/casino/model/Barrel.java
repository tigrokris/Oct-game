package ru.demyanko.casino.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Dmitriy on 26.09.2017.
 */
class Barrel extends GameContentUnit {
    private int speed;
    private int number;
    private int amuntOfPictures;
    private Array<Sprite> pictures;
    private float pictureHeight;
    private boolean isStopped;
    private String texturePrefix;
    private String textureFormat;

    Barrel(float x, float y, float width, float height, int number, int amuntOfPictures,String textureNamePrefix,String textureFormat) {
        super(x, y, width, height);
        this.number = number;
        this.amuntOfPictures = amuntOfPictures;
        isStopped = true;
        this.pictures = new Array();
        this.pictureHeight = height / 3+2;
        this.texturePrefix= textureNamePrefix;
        this.textureFormat=textureFormat;
        fill(pictures);
    }

    private void fill(Array<Sprite> array) {
        for (int i = 0; i < amuntOfPictures; i++) {
            Sprite picture = new Sprite(new Texture(texturePrefix+MathUtils.random(1, amuntOfPictures) + "."+textureFormat));
            picture.setX(getX());
            picture.setY(getY() + i * pictureHeight);
            array.add(picture);
        }
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }



    @Override
    public void draw(SpriteBatch batch) {
        for (int i = 0; i < amuntOfPictures; i++) {
            batch.draw(pictures.get(i).getTexture(), getX(), pictures.get(i).getY(), getWidth(), pictureHeight);
        }
    }
    @Override
    public void update() {
        float shift;
        if (!isStopped) {
            shift = speed * Gdx.graphics.getDeltaTime();
            for (int i = 0; i < amuntOfPictures; i++) {
                pictures.get(i).setY(pictures.get(i).getY() - shift);
                jumpUp(pictures.get(i));
            }
        }
    }
    // to imitate real barrel the pictures should go cycle
    private void jumpUp(Sprite picture) {
        if (picture.getY() + pictureHeight < getY())
            picture.setY(picture.getY() + pictureHeight * amuntOfPictures);
    }


    @Override
    public void dispose() {
        for (Sprite picture : pictures) {
            picture.getTexture().dispose();
        }
    }

    int getAmuntOfPictures() {
        return amuntOfPictures;
    }

    void stopBarrel() {
        for (int i = 0; i < getAmuntOfPictures(); i++) {
            if (pictures.get(i).getY() <= getY()  && pictures.get(i).getY() >= getY() - 6) {
                isStopped = true;
                break;
            }
        }
    }

    boolean isStopped() {
        return isStopped;
    }

    void setIsStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }


}
