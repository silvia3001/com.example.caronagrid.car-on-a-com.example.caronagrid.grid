/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.caronagrid.commands;

import com.example.caronagrid.model.car.Car;
import com.example.caronagrid.model.car.Direction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveLeft implements Move {

  private static final Logger logger = Logger.getLogger(MoveLeft.class.getName());

  public void move(Car car) {
    Direction d = car.getDirection();
    car.setDirection(d.turnLeft());
    logger.log(Level.INFO, "Moved direction to " + car.getDirection());
  }
}
