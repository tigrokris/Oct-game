package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import ru.demyanko.casino.Game;
import ru.demyanko.casino.model.AbstractGameContentUnit;

/**
 * Created by Dmitriy on 27.09.2017.
 */
class BarrelsArray extends AbstractGameContentUnit {
    private Array<Barrel> barrels;
    private int barrelToStop;
    private boolean isStarted;

    BarrelsArray(float x, float y,
                 float width, float height,
                 String texturePrefix,String textureFormat,
                 Graphics graphics) {

        super(x, y, width, height);
        this.barrels=new Array();
        for (int i = 0; i < 5 ; i++) {
            Barrel barrel =new Barrel(x+width*i/5, y, width/5,height,i, Game.AMOUNT_BARREL_PICTURES,texturePrefix,textureFormat,graphics);
            barrels.add(barrel);
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        for (Barrel barrel : barrels) {
            barrel.draw(spriteBatch);
        }
    }

    @Override
    public void update() {
        for (Barrel barrel : barrels) {
            barrel.update();
        }
    }

    void start(){
        if(Game.isStarted && !isStarted ){
            for (int i = 0; i < barrels.size; i++) {
                barrels.get(i).setSpeed(MathUtils.random(Game.LOWER_SPEED_LIMIT, (Game.UPPER_SPEED_LIMIT)));
                Game.stopTime= TimeUtils.millis() + Game.ROTATION_TIME + MathUtils.random(0, (Game.ROTATION_DIAPASON_TIME));
                barrels.get(i).setIsStopped(false);
                barrelToStop=0;
                isStarted=true;
            }
        }
    }

    void stop(){
        if(!Game.isStarted && isStarted ) {
            if (barrelToStop < 5 && !Game.isStarted) {
                barrels.get(barrelToStop).stopBarrel();
                if (barrels.get(barrelToStop).isStopped())
                    barrelToStop++;
            }
            if(barrelToStop==5)
                isStarted=false;
        }
    }
    @Override
    public void dispose() {
        for (Barrel barrel : barrels) {
            barrel.dispose();
        }
    }

}
