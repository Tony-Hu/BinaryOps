import java.util.ArrayList;

/**
 * Created by Azrael on 6/13/2017.
 * [URL]: http://www.lintcode.com/en/problem/gray-code/
 * [Description]
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, find the sequence of gray code. A gray code sequence must begin with 0 and with cover all 2n integers.

 Notice

 For a given n, a gray code sequence is not uniquely defined.

 [0,2,3,1] is also a valid gray code sequence according to the above definition.

 Example
 Given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 * [Note]
 * Consider the following steps:
 * 0
 * 1 - P1
 * 11
 * 10 - P2
 * 110
 * 111
 * 101
 * 100 - P3
 * 1100
 * 1101
 * 1111
 * 1110
 * 1010
 * 1011
 * 1001
 * 1000 - P4
 *
 * Every phase contains all the previous phase's number in reverse order plus 1 << (P - 1).
 */
public class LintCode411 {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> grayCode(int n) {
        result.add(0);
        if (n == 0)
            return result;
        result.add(1);
        if (n == 1)
            return result;
        for (int i = 1; i < n;i++){
            int x = 1 << i;
            ArrayList<Integer> reverse = reverse();
            for (int j = 0, size = reverse.size(); j < size;j++)
                reverse.set(j,reverse.get(j) + x);
            result.addAll(reverse);
        }
        return result;
    }
    public ArrayList<Integer> reverse(){
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i = result.size() - 1;i >= 0;i--){
            reverse.add(result.get(i));
        }
        return reverse;
    }
}
