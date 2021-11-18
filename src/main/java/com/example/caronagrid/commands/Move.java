package com.example.caronagrid.commands;

import com.example.caronagrid.model.car.Car;

public interface Move {
  void move(Car car) throws CommandException;
}
