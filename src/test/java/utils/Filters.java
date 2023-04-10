package utils;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;


public class Filters {
    private static PickleStepTestStep currentStep;
    private int counter = 0;
    public void removeDirectoryEvidence() {
        File directory = new File(System.getProperty("user.dir") + "/src/test/resources/relatorios");
        try {
            FileUtils.deleteDirectory(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
