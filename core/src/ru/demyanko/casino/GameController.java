package ru.demyanko.casino;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.TimeUtils;
import ru.demyanko.casino.controller.Controller;
import ru.demyanko.casino.model.GameContent;
import ru.demyanko.casino.util.Contents;
import ru.demyanko.casino.util.GameContentLoader;
import ru.demyanko.casino.view.GameScreen;

public class GameController extends Game implements Controller{

	public static final int LOWER_SPEED_LIMIT=200;//barrel rotation speed
	public static final int UPPER_SPEED_LIMIT=500;//barrel rotation speed
	public static final int ROTATION_TIME=4000;//barrel rotation time
	public static final int ROTATION_DIAPASON_TIME=1000;//barrel rotation time over the basic,i.e. 4 sec plus less then 1 sec(4-5 sec)
	public static final int AMOUNT_BARREL_PICTURES=11;//cannot be less 4
	public GameContent gameContent;
	public static long stopTime;
	public static boolean isStarted=false;
	private Screen gameScreen;


	@Override
	public void create () {
		gameContent= GameContentLoader.loadContent(Contents.CASINO1,Gdx.graphics);
		gameContent.create();
		gameScreen=new GameScreen(this);
		this.setScreen(gameScreen);
	}

	@Override
	public void render () {
		super.render();

		gameContent.update();
	}

	@Override
	public void dispose () {
		super.dispose();
		gameScreen.dispose();
	}

	@Override
	public void stop() {
		boolean isStartClicked;
		if(Gdx.input.isButtonPressed(Input.Keys.LEFT) && (isStartClicked=gameContent.getStartUnit().isClicked(Gdx.input, Gdx.graphics))){
			isStarted= isStartClicked;
			gameContent.start();
		}
	}

	@Override
	public void start() {
		if(TimeUtils.millis()>stopTime) {
			isStarted=false;
			gameContent.stop();
		}
	}
}
