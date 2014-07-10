/**
 * Created by hzeng on 6/26/14.
 */
import java.lang.System;

public class Calculate {
    public static void main(String[] args) {

        //1m / 4 + 10cm * 3 – 5mm = 545mm = 54.5cm = 0.545m
        Length len1m = Length.getLength(1,Unit.M);
        Length len10cm = Length.getLength(10, Unit.CM);
        Length len5mm = Length.getLength(5, Unit.MM);

        Length resultLen = len1m.divide(4).add(len10cm.multiply(3)).subtract(len5mm);

        System.out.println(len1m);
        System.out.println(len10cm);
        System.out.println(len5mm);
        System.out.println(resultLen);
    }
}
