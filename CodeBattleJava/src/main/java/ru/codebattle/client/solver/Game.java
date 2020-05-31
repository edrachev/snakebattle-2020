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


    public int distanceToClosestUseful() {
        Point point = board.getSnake().getPoint();
        int snakeX = point.getX();
        int snakeY = point.getY();

        int closestDistance = Integer.MAX_VALUE;

        ElementType[][] elements = board.getElements();
        for(int x = 0; x < elements.length; x++) {
            for(int y = 0; y < elements.length; y++) {
                ElementType element = elements[x][y];
                if(element == ElementType.APPLE || element == ElementType.GOLD) {
                    int distance = Math.abs(x - snakeX) + Math.abs(y - snakeY);
                    if(distance < closestDistance) {
                        closestDistance = distance;
                    }
                }
            }
        }

        return closestDistance;
    }
}
