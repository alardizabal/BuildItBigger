package com.albertlardizabal;

import java.util.Random;

public class JokeCenter {
    public String getJoke() {
        String[] jokeArray = {
                "I changed my password to \"incorrect\", so whenever I forget what it is the computer will say \"Your password is incorrect\".",
                "Failure is not an option—it comes bundled with the software.",
                "Are you a computer whiz? it seems you know how to turn my software into hardware.",
                "Are you a keyboard? Because you're my type!",
                "I love the F5 key. It´s just so refreshing."
        };
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        return String.format("%s", jokeArray[n]);
    }
}
