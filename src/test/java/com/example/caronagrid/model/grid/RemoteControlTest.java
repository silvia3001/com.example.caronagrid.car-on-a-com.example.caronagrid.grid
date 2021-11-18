package com.example.caronagrid.model.grid;

import com.example.caronagrid.model.grid.GridException;
import com.example.caronagrid.model.grid.RemoteControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoteControlTest {

  RemoteControl remoteControl;

  @BeforeEach
  public void setUp() throws Exception {
    remoteControl = new RemoteControl();
  }

  @Test
  public void testSetBeginXWithinGrid() throws GridException {
    remoteControl.setBeginX(1);
    assertEquals(1, remoteControl.getBeginX());
    remoteControl.setBeginX(7);
    assertEquals(7, remoteControl.getBeginX());
  }

  @Test
  public void testSetBeginXOutsideOfGrid() {
    assertThrows(GridException .class, () -> {remoteControl.setBeginX(16);});
  }

  @Test
  public void testSetBeginYWithinGrid() throws GridException {
    remoteControl.setBeginY(1);
    assertEquals(1, remoteControl.getBeginY());
    remoteControl.setBeginY(8);
    assertEquals(8, remoteControl.getBeginY());
  }

  @Test
  public void testSetBeginYOutsideOfGrid() {
    assertThrows(GridException .class, () -> {remoteControl.setBeginY(0);});
  }

  @Test
  public void testSetCommandsValid() throws GridException {
    remoteControl.setCommands("RFLFFFRL".toCharArray());
    assertEquals("RFLFFFRL".toCharArray()[0], remoteControl.getCommands()[0]);
    assertEquals("RFLFFFRL".toCharArray()[4], remoteControl.getCommands()[4]);
  }

  @Test
  public void testSetCommandsInValid() {
    assertThrows(GridException .class, () -> {remoteControl.setCommands("RFLFAFRL".toCharArray());});
  }

}
