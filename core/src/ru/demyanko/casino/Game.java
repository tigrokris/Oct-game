package ru.demyanko.casino;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.demyanko.casino.controller.ControllerImpl;
import ru.demyanko.casino.model.GameContentImpl;

import java.util.ResourceBundle;

public class Game extends ApplicationAdapter {

	SpriteBatch batch;
	public static final int LOWER_SPEED_LIMIT=200;//barrel rotation speed
	public static final int UPPER_SPEED_LIMIT=400;//barrel rotation speed
	public static final int ROTATION_TIME=4000;//barrel rotation time
	public static final int ROTATION_DIAPASON_TIME=1000;//barrel rotation time over the basic,i.e. 4 sec plus less then 1 sec(4-5 sec)
	public static final int AMOUNT_BARREL_PICTURES=11;//cannot be less 4
	public GameContent gameContent;
	public Controller controller;
	public static long stopTime;
	public static boolean isStarted=false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameContent=new GameContentImpl(Gdx.graphics);
		gameContent.create();
		controller = new ControllerImpl(gameContent,Gdx.graphics);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		gameContent.draw(batch);
		batch.end();

		gameContent.update();
		controller.start(Gdx.input);
		controller.stop();

	}

	@Override
	public void dispose () {
		batch.dispose();
		gameContent.dispose();
	}
}
