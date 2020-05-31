package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.GameBoard;
import ru.codebattle.client.api.SnakeAction;

import java.util.function.Function;

public class SmartStrategy implements Function<GameBoard, SnakeAction>  {
    private final GameDecisionFinder finder = new GameDecisionFinder();

    @Override
    public SnakeAction apply(GameBoard gameBoard) {
        try {
            long startTime = System.currentTimeMillis();
            Game game = new Game(new Board(gameBoard));
            MoveDirection bestMovement = finder.findBestDirection(game);
            Direction snakeDirection = game.getBoard().getSnake().getDirection();
            Direction newDirection = bestMovement.transform(snakeDirection);
            Board.previousDirection = newDirection;
            long time = System.currentTimeMillis() - startTime;
            System.out.println("took " + time);
            return SnakeAction.forDirection(newDirection);
        } catch (Exception e) {
            e.printStackTrace();
            return SnakeAction.forDirection(Direction.RIGHT);
        }
    }
}
