package com.beust.jcommander.command;

import com.beust.jcommander.JCommander;
import org.junit.Test;

import static org.testng.Assert.*;

public class CommandWithDefaultAnnotationTest {

    @Test public void emptyArgsPickupDefaultFromAnnotation() {

        CommandWithDefaultAnnotation cmd = new CommandWithDefaultAnnotation();

        JCommander jc = JCommander.newBuilder()
                .addObject(cmd)
                .args(new String[]{"--parsed"})
                .build();

        assertTrue(cmd.parsed);
        assertEquals(cmd.echo, CommandWithDefaultAnnotation.DEFAULT_ECHO);

    }

}