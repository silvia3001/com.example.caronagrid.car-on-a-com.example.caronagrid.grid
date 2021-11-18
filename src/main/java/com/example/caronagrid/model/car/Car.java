package com.example.caronagrid.model.car;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Data
public class Car {

  private int x;

  private int y;

  private Direction direction;

  public Car() {
    this(1, 1);
  }

  public Car(int x, int y) {
    this(x, y, Direction.North);
  }

  public Car(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

}
