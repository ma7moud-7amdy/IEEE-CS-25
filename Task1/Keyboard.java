package com.mycompany.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] charSeq = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                          'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';',
                          'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/',};
        int charNum = charSeq.length;
        Map charMap = new HashMap<Character, Integer>();
        for (int i = 0; i < charNum; i++) {
            charMap.put(charSeq[i], i);
        }
        // input 
        char direction = input.nextLine().charAt(0);
        String message = input.next();
        int shift = direction == 'R' ? -1 : 1;
        int messageLength = message.length();
        char[] original = new char[messageLength];

        for (int i = 0; i < messageLength; i++) {
            int curr = (int) charMap.get(message.charAt(i)) + shift;
            original[i] = charSeq[curr];
        }
        System.out.println(original);

    }

}
