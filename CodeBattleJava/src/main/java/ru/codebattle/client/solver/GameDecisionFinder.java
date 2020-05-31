package ru.codebattle.client.solver;

import ru.codebattle.client.api.Direction;
import ru.codebattle.client.api.SnakeAction;
import ru.codebattle.client.solver.aspect.Constants;

import java.util.*;

public class GameDecisionFinder {
    private GameEstimateCalculator calculator = new GameEstimateCalculator();
    public static class Result {
        private final Map<MoveDirection, Double> directions = new LinkedHashMap<>();

        List<MoveDirection> getBestDirections() {
            List<MoveDirection> bestDirections = new ArrayList<>();
            double maxValue = -Double.MAX_VALUE;
            for(Map.Entry<MoveDirection, Double> entry: directions.entrySet()) {
                if(entry.getValue() > maxValue) {
                    bestDirections = new ArrayList<>();
                    bestDirections.add(entry.getKey());
                    maxValue = entry.getValue();
                } else if (entry.getValue() == maxValue) {
                    bestDirections.add(entry.getKey());
                }
            }

            return bestDirections;
        }

        double getBestValue() {
            if(getBestDirections().isEmpty()) return -Double.MAX_VALUE;
            return directions.get(getBestDirections().get(0));
        }

        public void addDirection(MoveDirection direction, double value) {
            directions.put(direction, value);
        }
    }

    public List<MoveDirection> findBestDirections(Game game) {
        Result result = calcualte(game, Constants.LEVELS, 1.0);
        return result.getBestDirections();
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
