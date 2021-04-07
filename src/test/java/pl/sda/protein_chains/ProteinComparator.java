package pl.sda.protein_chains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProteinComparator {


    public boolean changePossible(String protein1, String protein2) {

        char[] charsFromProtein1 = protein1.toCharArray();
        char[] charsFromProtein2 = protein2.toCharArray();

        Map<Character, Integer> charsMapFromProtein1 = new HashMap<>();
        Map<Character, Integer> charsMapFromProtein2 = new HashMap<>();


        if (charsFromProtein1.length != charsFromProtein2.length) {
            return false;
        } else if (numberFromChars(charsFromProtein1) != numberFromChars(charsFromProtein2)) {
            return false;
        } else {
            addCharsToMap(protein1.toCharArray(), charsMapFromProtein1);
            addCharsToMap(protein2.toCharArray(), charsMapFromProtein2);
        }
        if (!charsMapFromProtein1.keySet().equals(charsMapFromProtein2.keySet())) {
            return false;
        } else {
            addCountOfCharsToMap(charsFromProtein1, charsMapFromProtein1);
            addCountOfCharsToMap(charsFromProtein2, charsMapFromProtein2);
            return compareMaps(charsMapFromProtein1, charsMapFromProtein2);
        }
    }

    private boolean compareMaps(Map<Character, Integer> charsMapFromProtein1, Map<Character, Integer> charsMapFromProtein2) {
        List<Character> colection = charsMapFromProtein1.keySet().stream().filter(c -> !charsMapFromProtein1.get(c).equals(charsMapFromProtein2.get(c))).collect(Collectors.toList());
        if (colection.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private void addCountOfCharsToMap(char[] charsTable, Map<Character, Integer> charsMap) {
        for (int i = 0; i < charsTable.length; i++) {
            charsMap.replace(charsTable[i], charsMap.get(charsTable[i]) + 1);
        }
    }

    private void addCharsToMap(char[] charsTable, Map<Character, Integer> charsMap) {
        for (int i = 0; i < charsTable.length; i++) {
            charsMap.put(charsTable[i], 0);
        }
    }

    public int numberFromChars(char[] chars) {
        int sum = 0;
        for (char aChar : chars) {
            sum = sum + aChar;
        }
        return sum;
    }


}
