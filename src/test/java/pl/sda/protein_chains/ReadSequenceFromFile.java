package pl.sda.protein_chains;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadSequenceFromFile {

    private List<String> proteinList = new ArrayList();

    public ReadSequenceFromFile() {
        this.proteinList = readProteinSequenceFile();
    }

    public List<String> readProteinSequenceFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource("proteinSequence.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            lines = Collections.EMPTY_LIST;
        }
        return lines;
    }

    public List<String> getProteinList() {
        return proteinList;
    }

}
