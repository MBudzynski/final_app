package pl.sda.protein_chains;


import org.junit.jupiter.api.Test;

import java.util.List;


public class TestFileReader {

    ReadSequenceFromFile readSequenceFromFile = new ReadSequenceFromFile();
    ProteinsChecker proteinsChecker = new ProteinsChecker();


    @Test
    void shouldReturnStringsFromFile() {

        List<String> strings = readSequenceFromFile.readProteinSequenceFile();

        proteinsChecker.checkePosibilities(strings);

    }


}
