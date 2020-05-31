package ru.codebattle.client.solver;

import ru.codebattle.client.solver.aspect.*;

import java.util.List;

public class GameEstimateCalculator {
    private final List<EstimateAspect> aspects = List.of(
            new Death(),
            new Apple(),
            new Rage(),
            new Stone(),
            new Gold(),
            new KickEnemy(),
            new Unknown(),
            new SelfKick()
    );

    double evaluate(Game game) {
        double value = 0;
        for (EstimateAspect aspect : aspects) {
            value += aspect.estimate(game);
        }

        return value;
    }
}
