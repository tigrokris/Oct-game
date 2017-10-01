package ru.demyanko.casino.util;

import com.badlogic.gdx.Graphics;
import ru.demyanko.casino.model.GameContent;
import ru.demyanko.casino.model.casino1.GameContentImpl;

/**
 * Created by Dmitriy on 01.10.2017.
 */
public class GameContentLoader {
    public static GameContent loadContent(Contents content,Graphics graphics){
        if(content==Contents.CASINO1)
            return new GameContentImpl(graphics);
        else
            throw new IllegalArgumentException("No such content");
    }
}
