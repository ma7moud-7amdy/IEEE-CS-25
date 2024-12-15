package com.mycompany.task5;

import java.util.*;

public class CreatingStrings {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        Set<String> result = new TreeSet<>();

        findStrings(charArray, 0, result);

        // Output the number of permutations and the permutations themselves
        System.out.println(result.size());
        for (String a : result) {
            System.out.println(a);
        }
    }

    public static void findStrings(char[] str, int index, Set<String> result) {
        // Base case
        if (index == str.length) {
            result.add(new String(str));
            return;
        }

        // Generate strings by swap chars
        for (int i = index; i < str.length; i++) {
            // no dublication
            if (i != index && str[i] == str[index]) {
                continue;
            }
            // swap
            char temp = str[index];
            str[index] = str[i];
            str[i] = temp;

            findStrings(str, index + 1, result);
            // swap again
            temp = str[index];
            str[index] = str[i];
            str[i] = temp;
        }
    }

}
