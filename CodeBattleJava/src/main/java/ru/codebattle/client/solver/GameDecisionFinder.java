package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.SnakeAction;
import ru.codebattle.client.solver.aspect.Constants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameDecisionFinder {
    private GameEstimateCalculator calculator = new GameEstimateCalculator();
    public static class Result {
        private final Map<MoveDirection, Double> directions = new LinkedHashMap<>();

        MoveDirection getBestDirection() {
            double maxValue = -Double.MAX_VALUE;
            MoveDirection maxDirection = MoveDirection.RIGHT;
            for(Map.Entry<MoveDirection, Double> entry: directions.entrySet()) {
                if(entry.getValue() > maxValue) {
                    maxDirection = entry.getKey();
                    maxValue = entry.getValue();
                }
            }

            return maxDirection;
        }

        double getBestValue() {
            return directions.get(getBestDirection());
        }

        public void addDirection(MoveDirection direction, double value) {
            directions.put(direction, value);
        }
    }

    public MoveDirection findBestDirection(Game game) {
        Result result = calcualte(game, Constants.LEVELS, 1.0);
        return result.getBestDirection();
    }

    private Result calcualte(Game game, int levels, double decreasingLevelRate) {
        double nextLeveDecreasingLevelRate = decreasingLevelRate * 0.9;
        int nextLevels = levels - 1;
        Result result = new Result();
        for(MoveDirection direction: MoveDirection.values()) {
            Game newGame = game.move(direction);
            double value = calculator.evaluate(newGame) * decreasingLevelRate;

            if(levels > 0 && value >= 0) {
                Result nextLevelResult = calcualte(newGame, nextLevels, nextLeveDecreasingLevelRate);
                value += nextLevelResult.getBestValue();
            }

            result.addDirection(direction, value);
        }

        return result;
    }
}
