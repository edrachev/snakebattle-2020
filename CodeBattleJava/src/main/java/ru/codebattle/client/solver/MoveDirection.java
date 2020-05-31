package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;

public enum MoveDirection {
    FORWARD(new Direction[] {Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT}),
    RIGHT(new Direction[] {Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP}),
    LEFT(new Direction[] {Direction.LEFT, Direction.UP, Direction.RIGHT, Direction.DOWN});

    private Direction[] directions;

    MoveDirection(Direction[] directions) {
        this.directions = directions;
    }

    public Direction transform(Direction direction) {
        if (direction == Direction.UP) return directions[0];
        if (direction == Direction.RIGHT) return directions[1];
        if (direction == Direction.DOWN) return directions[2];
        if (direction == Direction.LEFT) return directions[3];

        return null;
    }
}
