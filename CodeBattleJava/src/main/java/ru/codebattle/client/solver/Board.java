package ru.codebattle.client.solver;

import ru.codebattle.client.api.BoardElement;
import ru.codebattle.client.api.BoardPoint;
import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.GameBoard;

public class Board {
    private final Snake snake;

    private final ElementType[][] elements;

    public Board(GameBoard gameBoard) {
        var size = gameBoard.size();
        elements = new ElementType[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                BoardElement element = gameBoard.getElementAt(new BoardPoint(x, y));
                elements[x][y] = map(element);
            }
        }


        BoardPoint snakeHead = gameBoard.getMyHead();
        if (snakeHead == null) {
            // wtf
            snakeHead = new BoardPoint(1, 1);
        }
        BoardElement element = gameBoard.getElementAt(snakeHead);
        snake = new Snake(Point.forBoardPoint(snakeHead), defineSnakeDirection(element), element == BoardElement.HEAD_EVIL);
        previousDirection = snake.getDirection();
    }

    private ElementType map(BoardElement element) {
        switch (element) {
            case NONE:
                return ElementType.FREE;
            case WALL:
            case START_FLOOR:
                return ElementType.WALL;

            case APPLE:
                return ElementType.APPLE;

            case FURY_PILL:
                return ElementType.RAGE;

            case GOLD:
                return ElementType.GOLD;

            case STONE:
                return ElementType.STONE;

            case ENEMY_HEAD_DOWN:
            case ENEMY_HEAD_LEFT:
            case ENEMY_HEAD_RIGHT:
            case ENEMY_HEAD_UP:
            case ENEMY_BODY_HORIZONTAL:
            case ENEMY_BODY_VERTICAL:
            case ENEMY_BODY_LEFT_DOWN:
            case ENEMY_BODY_LEFT_UP:
            case ENEMY_BODY_RIGHT_DOWN:
            case ENEMY_BODY_RIGHT_UP:
                return ElementType.ENEMY_SNAKE;

            case BODY_HORIZONTAL:
            case BODY_VERTICAL:
            case BODY_LEFT_DOWN:
            case BODY_LEFT_UP:
            case BODY_RIGHT_DOWN:
            case BODY_RIGHT_UP:
                return ElementType.SELF_SNAKE;
        }

        return ElementType.UNKNOWN;
    }

    private Board(Snake snake, ElementType[][] elements) {
        this.snake = snake;
        this.elements = elements;
    }

    public static Direction previousDirection = Direction.RIGHT;

    private Direction defineSnakeDirection(BoardElement element) {
        if (element == BoardElement.HEAD_DOWN) return Direction.DOWN;
        if (element == BoardElement.HEAD_RIGHT) return Direction.RIGHT;
        if (element == BoardElement.HEAD_UP) return Direction.UP;
        if (element == BoardElement.HEAD_LEFT) return Direction.LEFT;

        return previousDirection;
    }

    public Snake getSnake() {
        return snake;
    }

    public ElementType getElement(Point point) {
        if (point.getX() >= elements.length || point.getY() >= elements.length || point.getX() < 0 || point.getY() < 0)
            return ElementType.WALL;

        ElementType element = elements[point.getX()][point.getY()];
        return element;
    }

    public Board move(MoveDirection moveDirection) {
        Direction snakeDirection = moveDirection.transform(snake.getDirection());
        Point newPosition = snake.getPoint().shift(snakeDirection);
        boolean willBeRaged = getElement(newPosition) == ElementType.RAGE;
        Snake newSnake = new Snake(newPosition, snakeDirection, snake.isInRage() || willBeRaged);
        return new Board(newSnake, elements);
    }
}
