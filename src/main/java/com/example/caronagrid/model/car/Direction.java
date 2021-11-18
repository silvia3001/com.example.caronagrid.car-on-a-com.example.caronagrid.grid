package com.example.caronagrid.model.car;

public enum Direction {
  North,
  East,
  South,
  West;

  public Direction turnRight() {
    return values()[(ordinal() + 1) % 4];
  }

  public Direction turnLeft() {
    return values()[(ordinal() + 3) % 4];
  }
}

