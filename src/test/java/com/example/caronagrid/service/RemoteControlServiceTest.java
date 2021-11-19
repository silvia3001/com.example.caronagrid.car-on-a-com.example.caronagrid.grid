package com.example.caronagrid.service;

import com.example.caronagrid.model.grid.GridException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RemoteControlServiceTest {

    RemoteControlService remoteControlService = new RemoteControlService();


    public static Stream<Arguments> argsWillValidateInput() {
        return Stream.of(
                Arguments.of("5,5:RFLFRFLF", true),
                Arguments.of("15,15:RRRRRRR", true),
                Arguments.of("1,1:FFFFFFFFFFFFFFFFFF", true),
                Arguments.of("5,5:XFLFRFLF", false),
                Arguments.of("0,0:FLFRFLF", false),
                Arguments.of("abcde", false),
                Arguments.of(".", false),
                Arguments.of("x", false)
        );
    }

    @ParameterizedTest
    @MethodSource("argsWillValidateInput")
    public void willValidateInput(String instruction, boolean isValid) {
        assertThat(remoteControlService.validateInput(instruction)).isEqualTo(isValid);
    }

    public static Stream<Arguments> argsWillExecuteInstruction() {
        return Stream.of(
                Arguments.of("5,5:RFLFRFLF", "The new position is: row= 7 - column= 7"),
                Arguments.of("6,6:FFLFFLFFLFF", "The new position is: row= 6 - column= 6"),
                Arguments.of("5,5:FLFLFFRFFF", "The new position is: row= 4 - column= 1")
        );
    }

    @ParameterizedTest
    @MethodSource("argsWillExecuteInstruction")
    public void willExecuteInstruction(String instruction, String expectedOutput) throws GridException {
        assertThat(remoteControlService.executeInstruction(instruction)).isEqualTo(expectedOutput);
    }

    @Test
    public void willThrowGridException() {
        assertThrows(GridException.class, () -> {
            remoteControlService.executeInstruction("5,5:QFLFRFLF");
        });
    }


}