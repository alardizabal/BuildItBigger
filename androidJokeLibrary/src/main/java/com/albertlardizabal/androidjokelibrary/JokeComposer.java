package com.albertlardizabal.androidjokelibrary;

import com.albertlardizabal.JokeCenter;

/**
 * Created by albertlardizabal on 1/14/17.
 */

public class JokeComposer {

    public String grabJoke() {
        JokeCenter jokeCenter = new JokeCenter();
        return jokeCenter.getJoke();
    }
}
