package ru.codebattle.client.solver;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public Game move(MoveDirection direction) {
        return new Game(board.move(direction));
    }

    public Board getBoard() {
        return board;
    }

    public ElementType getSnakePositionElementType() {
        var snakePosition = board.getSnake().getPoint();
        return board.getElement(snakePosition);
    }

    public boolean isSnakeInRage() {
        return board.getSnake().isInRage();
    }


}
