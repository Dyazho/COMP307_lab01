package com.company;

import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
	// write your code here
        int userChoice;
        int userKey;
        String userInput;
        String result;

        Scanner input = new Scanner(System.in);
        System.out.println("Caesar Cipher:");
        System.out.print("Encryption(1);Decryption(2): ");
        userChoice = input.nextInt();
        System.out.print("Message: ");
        userInput = new Scanner(System.in).nextLine();
        System.out.print("Key: ");
        userKey = input.nextInt();



        System.out.print("Result: ");
        if(userChoice == 1){
            result =  caesarCipherEncrypt(userInput,userKey);
        }
        else if(userChoice == 2){
            result = caesarCipherDecrypt(userInput,userKey);
        }
        else {
            System.out.println("Choice not enter correctly!");
            result = "";
        }
        System.out.println(result);
    }

    public static char caesarCipher(char letter, int key){
        if(!Character.isLetter(letter)){
            return letter;
        }
        char offset;
        if(Character.isUpperCase(letter)){
            offset = 'A';
        }else {
            offset='a';
        }
        return (char)((((letter+key)-offset)%26)+offset);
    }

    public static String caesarCipherEncrypt(String phrase, int key){
        String result = "";
        for (char index : phrase.toCharArray()) {
            result += caesarCipher(index,key);
        }
        return result;
    }

    public static String caesarCipherDecrypt(String phrase, int key){
        return caesarCipherEncrypt(phrase,26-key);
    }
}
