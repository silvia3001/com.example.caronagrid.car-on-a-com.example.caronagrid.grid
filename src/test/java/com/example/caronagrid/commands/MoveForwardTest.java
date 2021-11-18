package com.example.caronagrid.commands;


import com.example.caronagrid.model.car.Car;
import com.example.caronagrid.model.car.Direction;
import com.example.caronagrid.model.grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveForwardTest {

  Move move;

  Car car;

  @BeforeEach
  public void setUp() {
    move = new MoveForward();
    car = new Car();
  }

  @Test
  public void testMoveFromOrigin() throws CommandException {
    move.move(car);
    assertEquals(2, car.getY());
    assertEquals(1, car.getX());
    car.setDirection(car.getDirection().turnRight());
    move.move(car);
    assertEquals(2, car.getY());
    assertEquals(2, car.getX());
    car.setDirection(car.getDirection().turnLeft());
    move.move(car);
    assertEquals(3, car.getY());
    assertEquals(2, car.getX());
  }

  @Test
  public void testMoveBeyondNorthEdge() {
    car.setY(Grid.MAX_ROWS);
    car.setDirection(Direction.North);
    assertThrows(CommandException.class, () -> {
      move.move(car);});
  }

  @Test
  public void testMoveBeyondSouthEdge() {
    car.setY(1);
    car.setDirection(Direction.South);
    assertThrows(CommandException.class, () -> {
      move.move(car);});
  }

  @Test
  public void testMoveBeyondEastEdge() {
    car.setX(Grid.MAX_COLUMNS);
    car.setDirection(Direction.East);
    assertThrows(CommandException.class, () -> {
      move.move(car);});
  }

  @Test
  public void testMoveBeyondWestEdge() {
    car.setX(1);
    car.setDirection(Direction.West);
    assertThrows(CommandException.class, () -> {
      move.move(car);});
  }

}
