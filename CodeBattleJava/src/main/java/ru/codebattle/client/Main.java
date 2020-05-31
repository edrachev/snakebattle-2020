package ru.codebattle.client;

import java.io.IOException;
import java.net.URISyntaxException;

import ru.codebattle.client.solver.SmartStrategy;

public class Main {

    private static final String SERVER_ADDRESS = "http://codebattle-pro-2020s1.westeurope.cloudapp.azure.com/codenjoy-contest/board/player/w1463iuyl6sbuxju0vri?code=3281041901914613153&gameName=snakebattle";

    public static void main(String[] args) throws URISyntaxException, IOException {
        SnakeBattleClient client = new SnakeBattleClient(SERVER_ADDRESS);
        client.run(new SmartStrategy());

        System.in.read();

        client.initiateExit();
    }
}
