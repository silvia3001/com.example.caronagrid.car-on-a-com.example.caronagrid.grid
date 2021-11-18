package com.example.caronagrid.service;

import com.example.caronagrid.model.car.Car;
import com.example.caronagrid.commands.*;
import com.example.caronagrid.model.grid.GridException;
import com.example.caronagrid.model.grid.RemoteControl;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RemoteControlService {

    private int row;

    private int column;

    private char[] commands;

    public boolean validateInput(String s) {
        boolean isInputValid = false;
        Pattern p = Pattern.compile("[1-9][0-5]?,[1-9][0-5]?:[RLF]*");
        Matcher m = p.matcher(s);
        isInputValid = m.matches();
        return isInputValid;
    }

    public String executeInstruction(String instruction) throws GridException {
        String output = "";
        parseInstruction(instruction);
        Car car = new Car(row, column);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommands(commands);
        Move move = null;
        for (char c : remoteControl.getCommands()) {
            switch (c) {
                case 'R':
                    move = new MoveRight();
                    break;
                case 'L':
                    move = new MoveLeft();
                    break;
                case 'F':
                    move = new MoveForward();
                    break;
                default:
                    break;
            }
            if (move != null) {
                try {
                    move.move(car);
                }
                catch (CommandException e) {
                    e.getMessage();
                }
            }
        }
        output = "The new position is: row= " + car.getY() + " - column= " + car.getX();
        return output;
    }

    private void parseInstruction(String instruction) {
        String coordinatesString = instruction.substring(0, instruction.indexOf(":"));
        String commandString = instruction.substring(instruction.indexOf(":") + 1);
        String[] coordinates = coordinatesString.split(",");
        row = Integer.parseInt(coordinates[0]);
        column = Integer.parseInt(coordinates[1]);
        commands = commandString.toCharArray();
    }
}
