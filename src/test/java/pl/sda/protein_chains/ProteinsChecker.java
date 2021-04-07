package pl.sda.protein_chains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ProteinsChecker {

    private String proteinChains = 
            "BDDFPQPPRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGCHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
            "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
            "AABBCC\n" +
            "ACBBCA\n" +
            "BCBACA\n" +
            "ACBBCA\n" +
            "AABBCC\n" +
            "BCBACA\n" +
            "BCBACA\n" +
            "AABBCCC\n" +
            "AABBCC\n" +
            "AABBCC\n" +
            "ABBBCC\n" +
            "AABCCC\n" +
            "ABCAC\n" +
            "CACBA\n" +
            "AAAAAAAAAAAAAAAAAAAAB\n" +
            "AAAAAAAAAAAAAAAAAAAAA\n" +
            "QOOOOOOOOOOOOOOOOOOOO\n" +
            "OOOOOOOOOOOOOOOOOOOOQ";


    public void checkePosibilities(List<String> list){

        List<String> lines = list;
        for (int i = 0; i < list.size(); i=i+2) {
            System.out.println(changePosible(list.get(i), list.get(i+1)));
        }
    }

    private boolean changePosible(String line1, String line2) {
        if(line1.length() != line2.length()){
            return false;
        }
        if (line1.equals(line2)) {
            return true;
        }
        char[] chars1 = line1.toCharArray();
        char[] chars2 = line1.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

}
