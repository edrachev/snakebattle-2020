package ru.codebattle.client.solver.aspect;

import ru.codebattle.client.solver.ElementType;
import ru.codebattle.client.solver.Game;

public class Rage implements EstimateAspect {
    @Override
    public double estimate(Game game) {
        ElementType snakePositionElementType = game.getSnakePositionElementType();
        if(snakePositionElementType == ElementType.RAGE) {
            return Constants.RAGE;
        }

        return 0.0;
    }
}
