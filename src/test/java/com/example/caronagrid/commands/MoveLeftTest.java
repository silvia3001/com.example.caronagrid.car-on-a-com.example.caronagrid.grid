package com.example.caronagrid.commands;

import com.example.caronagrid.model.car.Car;
import com.example.caronagrid.model.car.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveLeftTest {

  Move move;
  Car car;

  @BeforeEach
  public void setUp() throws Exception {
    move = new MoveLeft();
    car = new Car();
  }

  @Test
  public void testMove() throws CommandException {
    car.setDirection(Direction.North);
    move.move(car);
    assertEquals(Direction.West, car.getDirection());
    move.move(car);
    assertEquals(Direction.South, car.getDirection());
    move.move(car);
    assertEquals(Direction.East, car.getDirection());
  }

}
