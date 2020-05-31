package ru.codebattle.client.solver.aspect;

import ru.codebattle.client.solver.ElementType;
import ru.codebattle.client.solver.Game;

public class KickEnemy implements EstimateAspect {
    @Override
    public double estimate(Game game) {
        if(game.isSnakeInRage()) {
            ElementType snakePositionElementType = game.getSnakePositionElementType();
            if(snakePositionElementType == ElementType.ENEMY_SNAKE) {
                return Constants.ENEMY_KICK;
            }
        }
        return 0;
    }
}
