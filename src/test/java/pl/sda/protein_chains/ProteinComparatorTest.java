package pl.sda.protein_chains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ProteinComparatorTest {

    ProteinComparator proteinComparator = new ProteinComparator();

    @Test
    void shouldReturnNumberFromChars() {
        //given
        char[] chars = {'A', 'B', 'C', 'D'};
        int expected = 266;
        //when
        int sum = proteinComparator.numberFromChars(chars);
        //than
        Assertions.assertEquals(sum, expected);
    }

    @Test
    void shouldReturnTrue() {
        //given
        boolean expected = true;
        String s1 = "ATDTSTATDHDTADNADFUAKEUFBKEFBKBFKABFKABFKEFBKUEFBKAEFBKEHBFKABFKAVDJAWFBKEBFKUAUBFKBFKBFKAUBFUKABWFKABFKFBKDBFKDBVKFEBKUSBFKUSFBKUEBFKSBVUKSUDBVKBSFUKSFYGYSJFGVJSFVJGFJSFGE|GFJSGFJE|GFJEGFJSGFVJSGVJGF|GFJSFYGESJFGSGFVKSUGFUKUSHFKSUFHKSEHFKUEFGKSUVKBDVYSDGSUFGIYEGUUAWAAFIHKUSFJSGBVKSGFVWFKU";
        String s2 = "ATDTSTATDHDTADNADFUAKEUFBKEFBKBFKABFKABFKEFBKUEFBKAEFBKEHBFKABFKAVDJAWFBKEBFKUAUBFKBFKBFKAUBFUKABWFKABFKFBKDBFKDBVKFEBKUSBFKUSFBKUEBFKSBVUKSUDBVKBSFUKSFYGYSJFGVJSFVJGFJSFGE|GFJSGFJE|GFJEGFJSGFVJSGVJGF|GFJSFYGESJFGSGFVKSUGFUKUSHFKSUFHKSEHFKUEFGKSUVKBDVYSDGSUFGIYEGUUAWAAFIHKUSFJSGBVKSGFVWFKU";
        //when
        boolean result = proteinComparator.changePossible(s1, s2);
        //than
        Assertions.assertEquals(result, expected);
    }

    @Test
    void shouldReturnFalseWhenStringHaveDifferentSize() {
        //given
        boolean expected = true;
        String s1 = "ATDTSTAGFV";
        String s2 = "ATDTSTAGFDTADNALV";
        //when
        boolean result = proteinComparator.changePossible(s1, s2);
        //than
        Assertions.assertEquals(result, expected);
    }

    @Test
    void shouldReturnFalseWhenSumCharactersIsDifferent() {
        //given
        boolean expected = true;
        String s1 = "ATDTSTAGFV";
        String s2 = "ATDTSFAGFV";
        //when
        boolean result = proteinComparator.changePossible(s1, s2);
        //than
        Assertions.assertEquals(result, expected);
    }


    @Test
    void shouldWitchStringAreTheSame() {

        String s1 = "BDDFPQPPRRAGGHPOPDKJKPEQAAER";
        String s2 = "BDDFPQPFRRAGGHPOPDKJKPEQAAER";
        String s3 = "BDDFPQPFRRAGCHPOPDKJKPEQAAER";
        String s4 = "BDDFPQPFRRAGGHPOPDKJKPEQAAER";
        String s5 = "BDDFPOPFRRAGCHPOPDKJKPEQAAER";
        String s6 = "BDDFPOPFRRAGCHPOPDKJKPEQAAER";
        String s7 = "AABBCC";
        String s8 = "ACBBCA";
        String s9 = "BCBACA";
        String s10 = "ACBBCA";
        String s11 = "AABBCC";
        String s12 = "BCBACA";
        String s13 = "BCBACA";
        String s14 = "AABBCCC";
        String s15 = "AABBCC";
        String s16 = "AABBCC";
        String s17 = "ABBBCC";
        String s18 = "AABCCC";
        String s19 = "ABCAC";
        String s20 = "CACBA";
        String s21 = "AAAAAAAAAAAAAAAAAAAAB";
        String s22 = "AAAAAAAAAAAAAAAAAAAAA";
        String s23 = "QOOOOOOOOOOOOOOOOOOOO";
        String s24 = "OOOOOOOOOOOOOOOOOOOOQ";


        System.out.println("s1 - s2:" + proteinComparator.changePossible(s1, s2));
        System.out.println("s3 - s4:" + proteinComparator.changePossible(s3, s4));
        System.out.println("s5 - s6:" + proteinComparator.changePossible(s5, s6));
        System.out.println("s7 - s8:" + proteinComparator.changePossible(s7, s8));
        System.out.println("s9 - 10:" + proteinComparator.changePossible(s9, s10));
        System.out.println("s11 - s12:" + proteinComparator.changePossible(s11, s12));
        System.out.println("s13 - s14:" + proteinComparator.changePossible(s13, s14));
        System.out.println("s15 - s16:" + proteinComparator.changePossible(s15, s16));
        System.out.println("s17 - s18:" + proteinComparator.changePossible(s17, s18));
        System.out.println("s19 - s20:" + proteinComparator.changePossible(s19, s20));
        System.out.println("s21 - s22:" + proteinComparator.changePossible(s21, s22));
        System.out.println("s23 - s24:" + proteinComparator.changePossible(s23, s24));

    }




}
