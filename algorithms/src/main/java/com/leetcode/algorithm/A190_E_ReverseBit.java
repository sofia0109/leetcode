package com.leetcode.algorithm;

/**
 *Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * @author yujianmei on 2017-09-14
 *
 */
public class A190_E_ReverseBit {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            //note: 1L << ((31 - i)). pay attention to 1L, not 1
            result = (n >>> i & 1) * (1L << (31 - i)) + result;
        }
        return (int)result;
    }
}
