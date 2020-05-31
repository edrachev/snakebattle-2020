package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.GameBoard;
import ru.codebattle.client.api.SnakeAction;

import java.util.List;
import java.util.function.Function;

public class SmartStrategy implements Function<GameBoard, SnakeAction>  {
    private final GameDecisionFinder finder = new GameDecisionFinder();

    @Override
    public SnakeAction apply(GameBoard gameBoard) {
        try {
            long startTime = System.currentTimeMillis();
            Game game = new Game(new Board(gameBoard));
            List<MoveDirection> bestMovements = finder.findBestDirections(game);
            MoveDirection bestMovement = getOneDirection(bestMovements, game);
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

    private MoveDirection getOneDirection(List<MoveDirection> bestMovements, Game game) {
        if(bestMovements.isEmpty()) return MoveDirection.FORWARD;
        if(bestMovements.size() == 1) return bestMovements.get(0);

        System.out.println("try to choose from several");
        int closestDistance = Integer.MAX_VALUE;
        MoveDirection bestDirection = bestMovements.get(0);
        for(MoveDirection direction: bestMovements) {
            Game newGame = game.move(direction);
            int distanceToClosestUseful = newGame.distanceToClosestUseful();
            if(distanceToClosestUseful < closestDistance) {
                closestDistance = distanceToClosestUseful;
                bestDirection = direction;
            }
        }

        return bestDirection;
    }
}
