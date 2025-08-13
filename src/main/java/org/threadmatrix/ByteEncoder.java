package org.threadmatrix;

import java.math.BigInteger;

/**
 * ByteEncoder is a utility class that converts strings in various numeral systems
 * (binary, octal, hexadecimal, and base32) into byte arrays.
 * It provides methods to validate the input format and convert it to a byte array.
 */
public class ByteEncoder {


    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Please provide two arguments.");
            return;
        }

        String format = args[0];
        String inputString = args[1];

        byte[] output = null;
        switch(format.toLowerCase()) {
            case "binary":
                if (!inputString.matches("[01]+")) {
                    System.out.println("Invalid binary number: " + inputString);
                    break;
                }
                output = getBinaryToByteEncodedArray(inputString);
                break;
            case "octal":
                if (!inputString.matches("[0-7]+")) {
                    System.out.println("Invalid octal number: " + inputString);
                    break;
                }
                output = getOctalToByteEncodedArray(inputString);
                break;
            case "hexa":
                if (!inputString.matches("[0-9a-fA-F]+")) {
                    System.out.println("Invalid hexadecimal number: " + inputString);
                    break;
                }
                output = getHexaToByteEncodedArray(inputString);
                break;
            case "base32":
                if (!inputString.matches("[0-9a-vA-V]+")) {
                    System.out.println("Invalid base32 number: " + inputString);
                    break;
                }
                output = getBase32ToByteEncodedArray(inputString);
                break;
            default:
                System.out.println("Unknown format: " + format);
                output = null;
        }

        if (output != null) {
            System.out.println("Encoded byte array: ");
            for (byte b : output) {
                System.out.print(b + ", ");
            }
            System.out.println();
        }
    }

    public static byte[] getOctalToByteEncodedArray(String inputString){
        return getEncodedArray(inputString, "8");
    }


    public static byte[] getBinaryToByteEncodedArray(String inputString){
        return getEncodedArray(inputString, "2");
    }

    public static byte[] getHexaToByteEncodedArray(String inputString){
        return getEncodedArray(inputString, "16");
    }

    public static byte[] getBase32ToByteEncodedArray(String inputString){
        return getEncodedArray(inputString, "32");
    }

    private static byte[] getEncodedArray(String inputString , String base){

        BigInteger decimalNumber = getDecimalNumber(inputString, base);
        System.out.println("Decimal Number: " + decimalNumber);
        return decimalNumber.toByteArray();
    }

    public static BigInteger getDecimalNumber(String inputString, String base){
        BigInteger decimalNumber = new BigInteger("0");
        int power = 0;
        BigInteger baseNumber = new BigInteger(base);
        BigInteger currentNumber = new BigInteger("0");
        for(int index = inputString.length()-1; index >= 0 ; index--){
            currentNumber = new BigInteger(getCurrentNumber(inputString, index, base));
            currentNumber = currentNumber.multiply(baseNumber.pow(power));
            decimalNumber = decimalNumber.add(currentNumber);
            power++;
        }
        return decimalNumber;
    }

    private static String getCurrentNumber(String inputString, int index, String base){
        String currentString = inputString.substring(index,index+1);
        if(base.equals("2") || base.equals("8")) {
            return currentString;
        }else if(base.equals("16")){
            switch(currentString.toLowerCase()) {
                case "a":
                    currentString = "10";
                    break;
                case "b":
                    currentString = "11";
                    break;
                case "c":
                    currentString = "12";
                    break;
                case "d":
                    currentString = "13";
                    break;
                case "e":
                    currentString = "14";
                    break;
                case "f":
                    currentString = "15";
                    break;
                default:
                    currentString = currentString;
            }
        }else if(base.equals("32")){
            switch(currentString.toLowerCase()) {
                case "a":
                    currentString = "10";
                    break;
                case "b":
                    currentString = "11";
                    break;
                case "c":
                    currentString = "12";
                    break;
                case "d":
                    currentString = "13";
                    break;
                case "e":
                    currentString = "14";
                    break;
                case "f":
                    currentString = "15";
                    break;
                case "g":
                    currentString = "16";
                    break;
                case "h":
                    currentString = "17";
                    break;
                case "i":
                    currentString = "18";
                    break;
                case "j":
                    currentString = "19";
                    break;
                case "k":
                    currentString = "20";
                    break;
                case "l":
                    currentString = "21";
                    break;
                case "m":
                    currentString = "22";
                    break;
                case "n":
                    currentString = "23";
                    break;
                case "o":
                    currentString = "24";
                    break;
                case "p":
                    currentString = "25";
                    break;
                case "q":
                    currentString = "26";
                    break;
                case "r":
                    currentString = "27";
                    break;
                case "s":
                    currentString = "28";
                    break;
                case "t":
                    currentString = "29";
                    break;
                case "u":
                    currentString = "30";
                    break;
                case "v":
                    currentString = "31";
                    break;
                default:
                    currentString = currentString;
            }
        }
        return currentString;
    }

}