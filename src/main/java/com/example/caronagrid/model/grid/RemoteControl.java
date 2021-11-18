package com.example.caronagrid.model.grid;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoteControl {

  public static List<Character> commandTypes = Arrays.asList('F', 'L', 'R');

  private int beginX;

  private int beginY;

  private char[] commands;

  private static final Logger logger = Logger.getLogger(RemoteControl.class.getName());

  public int getBeginX() {
    return beginX;
  }

  public void setBeginX(int beginX) throws GridException {
    if (beginX < 1 || beginX > Grid.MAX_COLUMNS) {
      logger.log(Level.SEVERE, "Invalid column number. The com.example.caronagrid.model.car can only be positioned" +
          " between columns 1 and " + Grid.MAX_COLUMNS);
      throw new GridException("Invalid starting position");
    }
    this.beginX = beginX;
  }

  public int getBeginY() {
    return beginY;
  }

  public void setBeginY(int beginY) throws GridException {
    if (beginY < 1 || beginY > Grid.MAX_ROWS) {
      logger.log(Level.SEVERE, "Invalid row number. The com.example.caronagrid.model.car can only be positioned" +
          " between rows 1 and " + Grid.MAX_ROWS);
      throw new GridException("Invalid starting position");
    }
    this.beginY = beginY;
  }

  public char[] getCommands() {
    return commands;
  }

  public void setCommands(char[] commands) throws GridException {
    for(int i = 0; i < commands.length; i++){
      if (!commandTypes.contains(commands[i])) {
        logger.log(Level.SEVERE, "Invalid Command. The only available com.example.caronagrid.commands are  " + commandTypes.toString());
        throw new GridException("Invalid Command");
      }
    }
    this.commands = commands;
  }
}
