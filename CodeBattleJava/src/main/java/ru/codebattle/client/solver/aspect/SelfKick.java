package ru.codebattle.client.solver.aspect;

import ru.codebattle.client.solver.ElementType;
import ru.codebattle.client.solver.Game;

public class SelfKick implements EstimateAspect {
    @Override
    public double estimate(Game game) {
        if(game.isSnakeInRage()) {
            ElementType snakePositionElementType = game.getSnakePositionElementType();
            if(snakePositionElementType == ElementType.SELF_SNAKE) {
                return Constants.SELF_KICK;
            }
        }
        return 0;
    }
}
