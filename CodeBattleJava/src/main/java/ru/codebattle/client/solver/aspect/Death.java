package ru.codebattle.client.solver.aspect;

import ru.codebattle.client.solver.ElementType;
import ru.codebattle.client.solver.Game;

public class Death implements EstimateAspect {

    @Override
    public double estimate(Game game) {
        ElementType snakePositionElementType = game.getSnakePositionElementType();
        if(snakePositionElementType == ElementType.WALL) return Constants.DEATH;
        if(snakePositionElementType == ElementType.ENEMY_SNAKE && !game.isSnakeInRage()) return Constants.DEATH_FROM_ENEMY;
        return 0;
    }
}
