/**
 * Created by Azrael on 6/12/2017.
 * [URL]: http://www.lintcode.com/problem/add-binary
 * [Description]
 * Given two binary strings, return their sum (also a binary string).
 * Example
 a = 11

 b = 1

 Return 100
 */
public class LintCode408 {

    //Method 1. Stupid long.
    public String addBinary(String a, String b) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        int lengthA = a.length();
        int lengthB = b.length();
        int minLength = Math.min(lengthA, lengthB);
        boolean overFlow = false;
        for (int i = 0; i < minLength; i++){
            char charA = a.charAt(lengthA - i - 1);
            char charB = b.charAt(lengthB - i - 1);
            if (overFlow){
                if ((charA == '1') && (charB == '1')) {
                    overFlow = true;
                    sb.append(1);
                }
                else if ((charA == '1') && (charB == '0')){
                    overFlow = true;
                    sb.append(0);
                }
                else if ((charA == '0') && (charB == '1')){
                    overFlow = true;
                    sb.append(0);
                }
                else{
                    overFlow = false;
                    sb.append(1);
                }
            }
            else{
                if ((charA == '1') && (charB == '1')) {
                    overFlow = true;
                    sb.append(0);
                }
                else if ((charA == '1') && (charB == '0')){
                    overFlow = false;
                    sb.append(1);
                }
                else if ((charA == '0') && (charB == '1')){
                    overFlow = false;
                    sb.append(1);
                }
                else{
                    overFlow = false;
                    sb.append(0);
                }
            }
        }
        for (int i = minLength; i < lengthA;i++){
            char charA = a.charAt(lengthA - i - 1);
            if (overFlow)
            {
                if (charA == '1'){
                    sb.append(0);
                }
                else{
                    overFlow = false;
                    sb.append(1);
                }
            }
            else
                sb.append(charA);
        }
        for (int i = minLength; i < lengthB;i++){
            char charB = b.charAt(lengthB - i - 1);
            if (overFlow)
            {
                if (charB == '1'){
                    sb.append(0);
                }
                else{
                    overFlow = false;
                    sb.append(1);
                }
            }
            else
                sb.append(charB);
        }
        if (overFlow)
            sb.append(1);
        return sb.reverse().toString();
    }

    //Test of Method 2
    public void testChar2Integer(){
        char a = '1';
        System.out.println("a - 1 = " + (int)(a - '1'));
    }

    //Method 2 - Treat every bit as an integer.
    public String addBinary2(String a, String b) {
        // Write your code here
        //Keep length of a >= length of b.
        if (a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;
        int overFlow = 0;
        StringBuilder sb = new StringBuilder();
        while (lengthB >= 0){
            int bitResult = (int)(a.charAt(lengthA--) - '0') + (int)(b.charAt(lengthB--) - '0') + overFlow;
            sb.append(bitResult % 2);
            overFlow = bitResult / 2;
        }
        while (lengthA >= 0){
            int bitResult = (int)(a.charAt(lengthA--) - '0') + overFlow;
            sb.append(bitResult % 2);
            overFlow = bitResult / 2;
        }
        if (overFlow == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        LintCode408 lintCode408 = new LintCode408();
        lintCode408.testChar2Integer();
    }
}
