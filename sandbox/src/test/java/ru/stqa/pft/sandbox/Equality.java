package ru.stqa.pft.sandbox;

/**
 * Created by fbi on 03.09.2017.
 */
public class Equality {

    public static void main(String[] args) {
        String s1 = "chrome";
        String s2 = s1;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
