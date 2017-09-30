package ru.demyanko.casino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import ru.demyanko.casino.model.GameContent;
import ru.demyanko.casino.model.casino1.GameContentImpl;
import ru.demyanko.casino.view.GameScreen;

public class Game extends com.badlogic.gdx.Game {

	public static final int LOWER_SPEED_LIMIT=200;//barrel rotation speed
	public static final int UPPER_SPEED_LIMIT=500;//barrel rotation speed
	public static final int ROTATION_TIME=4000;//barrel rotation time
	public static final int ROTATION_DIAPASON_TIME=1000;//barrel rotation time over the basic,i.e. 4 sec plus less then 1 sec(4-5 sec)
	public static final int AMOUNT_BARREL_PICTURES=11;//cannot be less 4
	public GameContent gameContent;
	public static long stopTime;
	public static boolean isStarted=false;


	@Override
	public void create () {
		gameContent=new GameContentImpl(Gdx.graphics);
		gameContent.create();
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();

		gameContent.update();

		//start the round
		boolean isStartClicked;
		if(Gdx.input.isButtonPressed(Input.Keys.LEFT) && (isStartClicked=gameContent.getStartUnit().isClicked(Gdx.input, Gdx.graphics))){
			isStarted= isStartClicked;
			gameContent.start();
		}
		//stop the barrels
		if(TimeUtils.millis()>stopTime) {
			isStarted=false;
			gameContent.stop();
		}
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
