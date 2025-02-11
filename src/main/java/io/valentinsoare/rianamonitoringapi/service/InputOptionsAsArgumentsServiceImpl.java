package io.valentinsoare.rianamonitoringapi.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class InputOptionsAsArgumentsServiceImpl implements InputOptionsAsArgumentsService {
    private Options optionsAvailable;
    private final CommandLineParser commandLineParser;

    public InputOptionsAsArgumentsServiceImpl() {
        this.commandLineParser = new DefaultParser();
        prepareOptionsFromUser();
    }

    private Option createOption(String shortName, String longName,
                                String description) {

        return Option.builder(shortName)
                .longOpt(longName)
                .desc(description)
                .required(false)
                .build();
    }

    private void prepareOptionsFromUser() {
        this.optionsAvailable = new Options();

        Option soaValues = createOption("s", "soa_check", "compare Start Of Authority values from InfoBlox and Google DNS Resolver");
        Option nsValues = createOption("n", "ns_check", "check if the IP addresses of the nameservers have changed or not.");
        Option help = createOption("h", "help", "help page");

        this.optionsAvailable.addOption(soaValues)
                .addOption(nsValues);
    }

    @Override
    public void printHelp(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();

        String infoApp = """
                The Riana Monitoring API is a Spring Boot-based application designed to monitor DNS zones and records.
                It provides endpoints to retrieve DNS zone information from both internal and external sources, compare Start of Authority (SOA) values, and check the IP addresses of nameservers.
                The API leverages reactive programming with WebFlux and integrates with various libraries such as dnsjava for DNS operations, Jackson for JSON processing, and Caffeine for caching.
                Additionally, it includes command-line options for executing specific monitoring tasks.
                """;

        try (PrintWriter writer = new PrintWriter(System.out)) {
            writer.printf("%nRianaMonitoringAPI v0.0.1%n");
            writer.printf("%n%s%n", infoApp);

            helpFormatter.printUsage(writer, 100, "./riana-monitoring-api [OPTION]...", options);
            helpFormatter.printOptions(writer, 100, options, 2, 5);
            writer.printf("%n%s%n%s", "Written by DevNetOps team.", "Please report any bugs to devnetops@lseg.com");
        }

        System.exit(0);
    }

    @Override
    public List<String> extractTypeOfTasks(String[] arguments) {
        List<String> optionsFromUser = new ArrayList<>();

        try {
            CommandLine commandLine = commandLineParser.parse(optionsAvailable, arguments);

            for (Option o : commandLine.getOptions()) {
                if (commandLine.hasOption(o)) {
                    optionsFromUser.add(o.getLongOpt());
                }
            }
        } catch (ParseException e) {
            String m = e.getMessage()
                            .substring(e.getMessage().indexOf(":") + 1)
                            .trim()
                            .replace("-", "");

            for (String o : m.split("")) {
                if (!optionsAvailable.hasOption(o)) {
                    log.error("riana-monitoring-api: invalid option -- '{}'%nTry riana-monitoring-api -h|--help for more information.", o);
                }
            }

            System.exit(1);
        }

        return optionsFromUser;
    }

    @Override
    public Options getOptionsAvailable() {
        return optionsAvailable;
    }
}
