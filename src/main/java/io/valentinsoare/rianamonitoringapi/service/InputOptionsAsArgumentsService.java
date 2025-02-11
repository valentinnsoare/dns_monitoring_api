package io.valentinsoare.rianamonitoringapi.service;

import org.apache.commons.cli.Options;

import java.util.List;


public interface InputOptionsAsArgumentsService {
    List<String> extractTypeOfTasks(String[] arguments);
    void printHelp(Options options);
    Options getOptionsAvailable();
}
