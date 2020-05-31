package ru.codebattle.client.solver;

import ru.codebattle.client.api.BoardPoint;
import ru.codebattle.client.api.Direction;

public class Point {
    private final int x;
    private final int y;

    public static Point forBoardPoint(BoardPoint point) {
        return new Point(point.getX(), point.getY());
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point shift(Direction direction) {
        if(direction == Direction.UP) return new Point(x, y - 1);
        if(direction == Direction.RIGHT) return new Point(x + 1, y);
        if(direction == Direction.DOWN) return new Point(x, y + 1);
        if(direction == Direction.LEFT) return new Point(x - 1, y);

        return this;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
