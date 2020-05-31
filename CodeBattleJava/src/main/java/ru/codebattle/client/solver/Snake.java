package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.GameBoard;

public class Snake {
    private final Point point;
    private final Direction direction;
    private final int rageTicks;

    public Snake(Point point, Direction direction, int rageTicks) {
        this.point = point;
        this.direction = direction;
        this.rageTicks = rageTicks;
    }

    public Point getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isInRage() {
        return rageTicks > 0;
    }

    public int getRageTicks() {
        return rageTicks;
    }
}
