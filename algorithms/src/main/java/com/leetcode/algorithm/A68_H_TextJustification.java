package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary
so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words,
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.
 */
public class A68_H_TextJustification {
    /**
     * Preconditions : the length of all string in words is less or equal to maxWidth
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<String>();
        int total = 0, index = 0, tail = 0;
        while (index < words.length) {
            //step 1 : find the word between [index..tail)
            total += words[index].length();
            tail = index + 1;
            while (tail < words.length) {
                if (total + 1 + words[tail].length() > maxWidth) {
                    break;
                }
                total += (1 + words[tail].length());
                tail++;
            }

            int offset = tail - index;
            // if last line or line with only one word
            if (offset == 1 || tail == words.length) {
                StringBuilder sb = new StringBuilder();
                for (int i = index; i < tail; i++) {
                    sb.append(words[i]);
                    if (! ((i == tail - 1) || words[i].length() >= maxWidth)) {
                        sb.append(" ");
                    }
                }
                //line 50-55 is added to conquer corner case
                int cur = sb.length();
                while (cur < maxWidth) {
                    sb.append(" ");
                    cur++;
                }
                result.add(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                int wordLen = 0;
                for (int i = index; i < tail; i++) {
                   wordLen += words[i].length();
                }
                int averageSpace = (maxWidth - wordLen) / (offset - 1);
                int leftSpace = (maxWidth - wordLen) % (offset - 1);
                for (int i = index; i < tail; i++) {
                    sb.append(words[i]);
                    if (! ((i == tail - 1) || words[i].length() >= maxWidth)) {
                        for (int j = 0; j < averageSpace; j++) {
                            sb.append(" ");
                        }
                        if (leftSpace > 0) {
                            sb.append(" ");
                            leftSpace--;
                        }
                    }
                }
                result.add(sb.toString());
            }

            //reset
            index = tail;
            total = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        // pass this test care first time. excellent
        String []  words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = fullJustify(words, 16);
        for (String s : result) {
            System.out.println(s);
        }

        //failed to pass this test case
        String [] coreCase = {""};
        List<String> result1 = fullJustify(coreCase, 2);
        for (String s : result1) {
            System.out.println(s);
        }
    }
}
