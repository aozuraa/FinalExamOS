
package com;

import java.util.Scanner;


public class misc {
        public static boolean YesOrNo() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Input again (y/n)? ");
            String input = scan.nextLine();
            
            if(input.equals("Y") || input.equals("y")){
                return true;
            }else if(input.equals("N") || input.equals("n")){
                return false;
            }
        }
    }
    public static int InputReq() {
        Scanner scan = new Scanner(System.in);
        int output = 0;
        try {
            System.out.print("Input number of request [max of 10]: ");
            int x = scan.nextInt();
            if (1 <= x && x <= 10) {
                output = x;
            } else {
                System.out.println("Invalid Input! Try [2-9]");
                output = InputReq();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input! Try again:");
            output = InputReq();
        }
        return output;
    }

    public static int InputProcess() {
        Scanner scan = new Scanner(System.in);
        int output = 0;
        try {
            System.out.print("Input no. of processes [2-9]: ");
            int x = scan.nextInt();
            if (2 <= x && x <= 9) {
                output = x;
            } else {
                System.out.println("Invalid Input! Try [2-9]");
                output = InputProcess();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input! Try again:");
            output = InputProcess();
        }
        return output;
    }
    public static int InputInt(String text){
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try{
            System.out.print(text);
            num = scan.nextInt();
        } catch (Exception e){
            num = InputInt(text);
        }
        return num;
    }
    public static int InputSize(String text, int pos){
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try{
            System.out.print(text);
            num = scan.nextInt();
            if (num < pos){
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Invalid: Input number greater than "+pos);
            num = InputSize(text, pos);
        }
        return num;
    }

    public static int[] InputAT(int x) {
        Scanner scan = new Scanner(System.in);
        int[] atOuput = new int[x];
        try {
            System.out.println("Input individual arrival time: ");
            for (int i = 0; i < x; i++) {
                System.out.print("AT" + (i + 1) + ": ");
                atOuput[i] = scan.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input! Try again:");
            atOuput = InputAT(x);
        }
        return atOuput;
    }

    public static int[] InputBT(int x) {
        Scanner scan = new Scanner(System.in);
        int[] btOuput = new int[x];
        try {
            System.out.println("Input individual burst time: ");
            for (int i = 0; i < x; i++) {
                System.out.print("BT" + (i + 1) + ": ");
                btOuput[i] = scan.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input! Try again:");
            btOuput = InputBT(x);
        }
        return btOuput;
    }
    public static int[] InputLoc(int x, int size) {
        Scanner scan = new Scanner(System.in);
        int[] LocOuput = new int[x];
        try {
            for (int i = 0; i < x; i++) {
                System.out.print("Loc " + (i + 1) + ": ");
                LocOuput[i] = scan.nextInt();
                if(LocOuput[i] > size){
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input! Try again:");
            LocOuput = InputLoc(x,size);
        }
        return LocOuput;
    }
}
