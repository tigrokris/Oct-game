package ru.demyanko.casino.model.casino1;

import com.badlogic.gdx.Graphics;
import ru.demyanko.casino.model.AbstractGameContent;

/**
 * Created by Dmitriy on 28.09.2017.
 */
public class GameContentImpl extends AbstractGameContent {
    BottomPanel bottomPanel;
    Button button;
    FPSInfo FPSInfo;
    BarrelsArray barrels;

    public GameContentImpl(Graphics graphics) {
        super(graphics);
    }
    @Override
    public void create(){
        float bottomPanelHeight =screenHeigth/5;
        button = new Button(screenWidth,bottomPanelHeight,"startAnim.jpg");
        bottomPanel =new BottomPanel(0,0,screenWidth,bottomPanelHeight,"bottomPanel.jpg");
        FPSInfo =new FPSInfo(10,20,graphics);
        barrels=new BarrelsArray(0,bottomPanelHeight,screenWidth,screenHeigth-bottomPanelHeight);


        gameContentUnits.add(barrels);
        gameContentUnits.add(bottomPanel);
        gameContentUnits.add(button);
        gameContentUnits.add(FPSInfo);

    }


    @Override
    public GameContentUnit getStartUnit() {
        return button;
    }
}
