package com.example.caronagrid.model.car;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class DirectionTest {

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testTurnRight() {
    assertSame(Direction.East, Direction.North.turnRight());
    assertSame(Direction.South, Direction.East.turnRight());
    assertSame(Direction.West, Direction.South.turnRight());
    assertSame(Direction.North, Direction.West.turnRight());
  }

  @Test
  public void testTurnLeft() {
    assertSame(Direction.North, Direction.East.turnLeft());
    assertSame(Direction.East, Direction.South.turnLeft());
    assertSame(Direction.South, Direction.West.turnLeft());
    assertSame(Direction.West, Direction.North.turnLeft());
  }

}
