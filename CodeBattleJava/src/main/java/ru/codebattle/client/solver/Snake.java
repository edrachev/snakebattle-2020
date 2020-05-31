package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.GameBoard;

public class Snake {
    private final Point point;
    private final Direction direction;
    private final boolean inRage;

    public Snake(Point point, Direction direction, boolean inRage) {
        this.point = point;
        this.direction = direction;
        this.inRage = inRage;
    }

    public Point getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isInRage() {
        return inRage;
    }
}
