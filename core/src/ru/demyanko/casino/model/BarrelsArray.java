package ru.demyanko.casino.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import ru.demyanko.casino.Game;

/**
 * Created by Dmitriy on 27.09.2017.
 */
class BarrelsArray extends GameContentUnit {
    private Array<Barrel> barrels;
    private int barrelToStop;
    private boolean isStarted;


    public BarrelsArray(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.barrels=new Array();
        for (int i = 0; i < 5 ; i++) {
            Barrel barrel =new Barrel(x+width*i/5, y, width/5,height,i, Game.AMOUNT_BARREL_PICTURES,"","jpg");
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
        if(Game.isStarted && !isStarted ){
            for (int i = 0; i < barrels.size; i++) {
                barrels.get(i).setSpeed(MathUtils.random(Game.LOWER_SPEED_LIMIT, (Game.UPPER_SPEED_LIMIT)));
                Game.stopTime= TimeUtils.millis() + Game.ROTATION_TIME + MathUtils.random(0, (Game.ROTATION_DIAPASON_TIME));
                barrels.get(i).setIsStopped(false);
                barrelToStop=0;
                isStarted=true;
            }
        }
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
