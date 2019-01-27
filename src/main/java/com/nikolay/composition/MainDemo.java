package com.nikolay.composition;

public class MainDemo {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220b", "Dell",
                "248", dimensions);
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27,
                new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus",
                4, 6, "v2.44");

        PC thePc = new PC(theCase, theMonitor, theMotherboard);

        thePc.getMonitor().drawPixelAt(150, 200, "red");
        thePc.getMotherboard().loadProgram("Windows 1.1");
        thePc.getTheCase().pressPowerButton();

    }
}
