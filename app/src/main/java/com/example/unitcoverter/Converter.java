package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;}

    public static float toKilogram(float kah) {
         return (float) (kah*0.45359237);
        }

        //converts inches to centimeters
    public static float toCentimeters(float kah) {
        return (float) (kah*2.54);
    }

    //converts quarts to liters

    public static float toLiters(float kah) {
        return (float) (kah*0.946353);
    }

}
