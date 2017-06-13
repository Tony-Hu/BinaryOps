/**
 * Java document can be seen here: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 * Created by warha on 6/12/2017.
 */
public class DummyBinary {

    public static void main(String[] args){
        int a = 0b1100;
        int b = 0b1011;
        int c = 0b1111;
//        byte d = (byte)0b11111111;//127
        byte d = (byte)0b10000000;//-128
//        byte d = -128;
        byte e = (byte)0b10000000;//-128
        int f = 0xB0000000;
        System.out.println("a & b (AND Operation)= " + (a & b));
        System.out.println("a | b (OR Operation)= " + (a | b));
        System.out.println("a ^ b (XOR Operation)= " + (a ^ b));
        System.out.println("c ^ c (XOR itself)= " + (c ^ c));
        System.out.println("~d = " + ~ d);
        System.out.println("e >> 1 = " + (e >> 1) + " should be " + (byte)0b11000000);
        System.out.println("f is " + f);
        System.out.println("f >>> 1 = " + (f >>> 1) + " should be " + 0x58000000);
    }
}
