package ru.codebattle.client.solver.aspect;

import ru.codebattle.client.solver.ElementType;
import ru.codebattle.client.solver.Game;

public class Stone implements EstimateAspect {
    @Override
    public double estimate(Game game) {
        ElementType snakePositionElementType = game.getSnakePositionElementType();
        if(snakePositionElementType == ElementType.STONE) {
            if(game.isSnakeInRage()) {
                return Constants.STONE_RAGE;
            } else {
                return Constants.STONE;
            }
        }

        return 0.0;
    }
}
