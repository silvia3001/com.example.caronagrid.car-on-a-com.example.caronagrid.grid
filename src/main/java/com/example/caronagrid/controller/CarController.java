package com.example.caronagrid.controller;

import com.example.caronagrid.model.grid.GridException;
import com.example.caronagrid.service.RemoteControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/grid") //http://localhost:8080/grid/car
public class CarController {

    @Autowired
    private RemoteControlService remoteControlService;

    @GetMapping("/car")
    public ResponseEntity<String> car(@RequestParam String instruction) {

        try {
            if(remoteControlService.validateInput(instruction)){
                return new ResponseEntity<>(remoteControlService.executeInstruction(instruction), HttpStatus.OK);
            }
        } catch (GridException e) {
            return new ResponseEntity<>("Invalid instruction", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Invalid instruction", HttpStatus.BAD_REQUEST);
    }

}
