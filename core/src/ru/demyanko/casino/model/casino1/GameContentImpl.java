package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.demyanko.casino.model.AbstractGameContent;
import ru.demyanko.casino.model.AbstractGameContentUnit;
/**
 * Created by Dmitriy on 28.09.2017.
 */
public class GameContentImpl extends AbstractGameContent {
    private BottomPanel bottomPanel;
    private Button button;
    private FPSInfo FPSInfo;
    private BarrelsArray barrels;
    private Graphics graphics;

    public GameContentImpl(Graphics graphics) {
        super(graphics);
        this.graphics=graphics;
    }
    @Override
    public void create(){
        float bottomPanelHeight =screenHeigth/5;
        button = new Button(screenWidth,bottomPanelHeight,"startAnim.jpg",graphics);
        bottomPanel =new BottomPanel(0,0,screenWidth,bottomPanelHeight,"bottomPanel.jpg");
        FPSInfo =new FPSInfo(10,20,graphics);
        barrels=new BarrelsArray(0,bottomPanelHeight,screenWidth,screenHeigth-bottomPanelHeight,"","jpg",graphics);

        gameContentUnits.add(barrels);
        gameContentUnits.add(bottomPanel);
        gameContentUnits.add(button);
        gameContentUnits.add(FPSInfo);
    }

    @Override
    public AbstractGameContentUnit getStartUnit() {
        return button;
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void start() {
        barrels.start();
    }

    @Override
    public void stop() {
        barrels.stop();
    }
}
