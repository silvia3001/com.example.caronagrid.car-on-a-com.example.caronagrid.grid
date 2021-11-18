/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.caronagrid.commands;

import com.example.caronagrid.model.car.Car;
import com.example.caronagrid.model.car.Direction;
import com.example.caronagrid.model.grid.Grid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MoveForward implements Move {

  private static Logger logger = LoggerFactory.getLogger(MoveForward.class);

  public void move(Car car) throws CommandException {
    Direction d = car.getDirection();
    switch (d) {
    case North:
      if (car.getY() + 1 > Grid.MAX_ROWS) {
        logger.info("Unable to move forward. Reached the " + Direction.North + " edge of the com.example.caronagrid.grid");
        throw new CommandException("Attempted to move outside the com.example.caronagrid.grid");
      }
      car.setY(car.getY() + 1);
      logger.info("Moved to (" + car.getY() + "," + car.getX() + ")");
      break;
    case East:
      if (car.getX() + 1 > Grid.MAX_COLUMNS) {
        logger.info("Unable to move forward. Reached the " + Direction.East + " edge of the com.example.caronagrid.grid");
        throw new CommandException("Attempted to move outside the com.example.caronagrid.grid");
      }
      car.setX(car.getX() + 1);
      logger.info("Moved to (" + car.getY() + "," + car.getX() + ")");
      break;
    case South:
      if (car.getY() - 1 < 1) {
        logger.info("Unable to move forward. Reached the " + Direction.South + " edge of the com.example.caronagrid.grid");
        throw new CommandException("Attempted to move outside the com.example.caronagrid.grid");
      }
      car.setY(car.getY() - 1);
      logger.info("Moved to (" + car.getY() + "," + car.getX() + ")");
      break;
    case West:
      if (car.getX() - 1 < 1) {
        logger.info("Unable to move forward. Reached the " + Direction.West + " edge of the com.example.caronagrid.grid");
        throw new CommandException("Attempted to move outside the com.example.caronagrid.grid");
      }
      car.setX(car.getX() - 1);
      logger.info("Moved to (" + car.getY() + "," + car.getX() + ")");
      break;
    default:
      break;
    }
  }
}
