package com.beust.jcommander.command;

import com.beust.jcommander.Parameter;

public class CommandWithDefaultAnnotation {

    @Parameter(names = "--echo", defaultIfNull = DEFAULT_ECHO)
    public String echo;

    @Parameter(names = "--parsed")
    public boolean parsed;

    public static final String DEFAULT_ECHO = "echo";
}
