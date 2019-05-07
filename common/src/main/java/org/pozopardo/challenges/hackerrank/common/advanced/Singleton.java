package org.pozopardo.challenges.hackerrank.common.advanced;

public class Singleton {

    public String str;
    private static final Singleton singleton = new Singleton();

    private Singleton() { }

    public static Singleton getSingleInstance() {
        return singleton;
    }
}
