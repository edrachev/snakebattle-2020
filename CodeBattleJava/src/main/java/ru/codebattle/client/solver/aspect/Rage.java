package ru.codebattle.client.solver.aspect;

import ru.codebattle.client.solver.ElementType;
import ru.codebattle.client.solver.Game;

import java.util.zip.CheckedOutputStream;

public class Rage implements EstimateAspect {
    @Override
    public double estimate(Game game) {
        ElementType snakePositionElementType = game.getSnakePositionElementType();
        if (snakePositionElementType == ElementType.RAGE) {
            if (game.getBoard().getPreviousSnake().getRageTicks() <= Constants.TICKS_WHEN_RAGE_IS_NEEDED) {
                return Constants.RAGE_WHEN_NEED_RAGE;
            } else {
                return Constants.RAGE_WHEN_DO_NOT_NEED_RAGED;
            }
        }

        return 0.0;
    }
}
