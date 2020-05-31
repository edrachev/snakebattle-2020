package ru.codebattle.client.solver;

import org.junit.jupiter.api.Test;
import ru.codebattle.client.api.Direction;

import static org.junit.jupiter.api.Assertions.*;

class MoveDirectionTest {

    @Test
    public void testTransform() {
        assertEquals(MoveDirection.FORWARD.transform(Direction.RIGHT), Direction.RIGHT);
        assertEquals(MoveDirection.FORWARD.transform(Direction.DOWN), Direction.DOWN);
        assertEquals(MoveDirection.FORWARD.transform(Direction.LEFT), Direction.LEFT);
        assertEquals(MoveDirection.FORWARD.transform(Direction.UP), Direction.UP);

        assertEquals(MoveDirection.RIGHT.transform(Direction.RIGHT), Direction.DOWN);
        assertEquals(MoveDirection.RIGHT.transform(Direction.DOWN), Direction.LEFT);
        assertEquals(MoveDirection.RIGHT.transform(Direction.LEFT), Direction.UP);
        assertEquals(MoveDirection.RIGHT.transform(Direction.UP), Direction.RIGHT);

        assertEquals(MoveDirection.LEFT.transform(Direction.RIGHT), Direction.UP);
        assertEquals(MoveDirection.LEFT.transform(Direction.DOWN), Direction.RIGHT);
        assertEquals(MoveDirection.LEFT.transform(Direction.LEFT), Direction.DOWN);
        assertEquals(MoveDirection.LEFT.transform(Direction.UP), Direction.LEFT);
    }
}