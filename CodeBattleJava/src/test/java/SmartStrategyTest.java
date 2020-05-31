import org.junit.jupiter.api.Test;
import ru.codebattle.client.api.GameBoard;
import ru.codebattle.client.api.SnakeAction;
import ru.codebattle.client.solver.SmartStrategy;

public class SmartStrategyTest {

    @Test
    void applyTest() {
        SmartStrategy strategy = new SmartStrategy();
        GameBoard board = new GameBoard("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼☼            ☼  ○        ☼  ®    ☼\n" +
                "☼☼®  ☼   ☼      ☼   ○ ☼ ☼    ☼    ☼\n" +
                "☼☼   ☼      ☼   ○® ☼            ® ☼\n" +
                "☼#    ☼  ☼  ○ ☼  ☼   ☼○ ®○☼   ☼○  ☼\n" +
                "☼☼        ☼    ☼    ☼   ○☼  ®☼    ☼\n" +
                "☼☼   ☼ ☼        ☼  ☼    ☼  ®      ☼\n" +
                "☼☼      ☼   ☼          ☼ ○ ☼ ®  ● ☼\n" +
                "☼☼   ☼   ☼        ☼    ® ○☼   ☼ ○ ☼\n" +
                "☼#   ☼☼       ☼      ☼       ☼○®  ☼\n" +
                "☼☼  ®☼     ☼   ☼    ☼○  ☼○  ☼  ○  ☼\n" +
                "☼☼      ☼   ☼   ☼○     ☼   ☼  ○   ☼\n" +
                "☼☼   ☼           ☼    ☼    ●     ○☼\n" +
                "☼☼        ☼   ☼$         ☼    ☼   ☼\n" +
                "☼#   ☼☼    ☼   ☼   ☼    ☼    ☼    ☼\n" +
                "☼☼     ☼    ☼       ☼       ☼     ☼\n" +
                "☼☼         ® ☼   ☼®  ☼    ☼       ☼\n" +
                "☼☼       ☼        ☼   ☼    ☼      ☼\n" +
                "☼☼     ☼       ☼            ☼     ☼\n" +
                "☼#    ☼    ☼    ☼   ☼   ☼         ☼\n" +
                "☼☼   ☼    ☼      ☼   ☼            ☼\n" +
                "☼☼       ●   ☼    ☼       ☼       ☼\n" +
                "☼☼  ╓   ☼   ☼          ☼   ☼   ○  ☼\n" +
                "☼☼  ║  ☼   ☼   ☼ ●  ☼   ☼●        ☼\n" +
                "☼#  ║ ☼       ☼  ●       ☼        ☼\n" +
                "☼☼  ║☼   ☼       ☼    ☼   ☼       ☼\n" +
                "☼☼  ╚══╗☼   ☼     ☼    ☼   ☼®  ○  ☼\n" +
                "☼☼     ╚╗  ☼    ☼  ☼         ☼    ☼\n" +
                "☼☼    ☼ ║ ☼    ☼       ●       ☼  ☼\n" +
                "☼#   ☼  ║☼    ☼         ☼   ☼     ☼\n" +
                "☼☼      ╚═♥♣┐   ☼   ☼     ☼       ☼\n" +
                "☼☼  ☼   ☼  ☼│   ☼     ☼           ☼\n" +
                "☼☼  ® ☼   ☼☼¤ ☼           ☼  ☼  ☼ ☼\n" +
                "☼☼                                ☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼");
        SnakeAction result = strategy.apply(board);
        System.out.println(result);
    }
}