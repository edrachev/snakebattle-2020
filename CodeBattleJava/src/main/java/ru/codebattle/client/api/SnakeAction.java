package ru.codebattle.client.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
public class SnakeAction {

  public static SnakeAction forDirection(Direction direction) {
    var action = new SnakeAction(true, direction);
    return action;
  }

  private static final String ACT_COMMAND_PREFIX = "ACT,";

  private final boolean act;
  private final Direction direction;

  @Override
  public String toString() {
    return direction.toString() + ",ACT";
  }
}
