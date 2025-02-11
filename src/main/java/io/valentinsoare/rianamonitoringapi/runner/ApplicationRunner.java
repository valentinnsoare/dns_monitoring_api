package io.valentinsoare.rianamonitoringapi.runner;

import io.valentinsoare.rianamonitoringapi.service.ActionsOnDnsInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final InputStream inputStream;
    private final ActionsOnDnsInputService actionsOnDnsInputService;

    @Autowired
    public ApplicationRunner(ActionsOnDnsInputService actionsOnDnsInputService) {
        this.inputStream = System.in;
        this.actionsOnDnsInputService = actionsOnDnsInputService;
    }

    @Override
    public void run(String... args) {
        actionsOnDnsInputService.runTasksFromInput(args, inputStream);
    }
}
