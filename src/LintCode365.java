/**
 * Created by Azrael on 6/12/2017.
 * [URL]: http://www.lintcode.com/en/problem/count-1-in-binary/
 * [Description]
 * Count how many 1 in binary representation of a 32-bit integer.
 * Given 32, return 1

 Given 5, return 2

 Given 1023, return 9
 */
public class LintCode365 {

    //Method 1 : O(32) Total Runtime: 1493 ms
    public int countOnes(int num) {
        int counter = 0;
        for (int i = 0; i < 32; i++){
            if ((num & 1) == 1)
                counter++;
            num = num >> 1;
        }
        return counter;
    }

    //Method 2: O(m) m is the bit of an integer. Total Runtime: 2838 ms
    public int countOnes2(int num) {
        int counter = 0;
        while (num != 0){
            num &= (num - 1);
            counter++;
        }
        return counter;
    }
}
