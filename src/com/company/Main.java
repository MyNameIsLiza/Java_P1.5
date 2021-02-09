package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size, right, left;
        ArrayList<Integer> arr = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                arr.clear();
                System.out.println("Меню");
                System.out.println("1 : Згенерувати масив рандомом");
                System.out.println("2 : Ввести масив з клавіатури");
                System.out.println("3 : Зчитати масив з файлу");
                int m_item = input_menu_item(reader);
                switch (m_item){
                    case 1: System.out.println("--------Заповнення масива рандомом--------");
                        System.out.println("Введіть розмір");
                        size = input_size(reader);

                        System.out.println("Введіть ліву границю");
                        left = input_int(reader);
                        System.out.println("Введіть праву границю");
                        right = input_int(reader);
                        for (int i = 0; i < size; i ++)
                            arr.add((int) (Math.random() * (right - left + 1) + left));
                        System.out.println("Наш масив");
                        for (int i = 0; i < size; i ++)
                            System.out.print(arr.get(i) + " ");
                        System.out.println("\nРозмір масива = " + arr.size());
                        break;
                    case 2: System.out.println("--------Заповнення масива вручну--------");
                        System.out.println("Введіть розмір");
                        size = input_size(reader);
                        System.out.println("Введіть елементи цілочисельного масиву");
                        for (int i = 0; i < size; i ++)
                            arr.add(input_int(reader));
                        System.out.println("Наш масив");
                        for (int i = 0; i < size; i ++)
                            System.out.print(arr.get(i) + " ");
                        System.out.println("\nРозмір масива = " + arr.size());
                    break;
                    case 3: System.out.println("--------Заповнення масива з файлу--------");
                        FileReader fr = new FileReader("C:\\workspace\\IdeaProjects\\Java_P1\\T1.5\\arr.txt");
                        Scanner scan = new Scanner(fr);
                        String arrr = "";
                        while(scan.hasNextLine()) arrr += scan.nextLine();
                        String[] s_arr = arrr.split(" ");
                        for(int i = 0; i< s_arr.length; i++)
                            arr.add(Integer.parseInt(s_arr[i]));
                        System.out.println("Наш масив");
                        for(int i = 0; i< s_arr.length; i++)
                            System.out.print(arr.get(i) + " ");
                        System.out.println("\nРозмір масива = " + arr.size());
                        fr.close();
                        break;
                }
                System.out.println("Новий масив, який складається тільки з неповторюваних елементів");
                ArrayList<Integer> diff_arr = different(arr);
                for(int i = 0; i< diff_arr.size(); i++)
                    System.out.print(diff_arr.get(i) + " ");
                System.out.println("\nРозмір масива = " + diff_arr.size());
            }

        } catch (IOException e) {
            System.out.println("QoQ");
        }
    }

    public static int input_size(BufferedReader reader) throws IOException {
        String t = reader.readLine();
        int m;
        try {
            m = Integer.parseInt(t);
            if(m<0){
                System.out.println("Невдача, розмір масиву не може бути від`ємним,\n введіть число ще раз");
                m = input_size(reader);
            }
        }catch (NumberFormatException e) {
            System.out.println("Невдача, введіть число ще раз");
            m = input_size(reader);
        }
        return m;
    }
    public static int input_int(BufferedReader reader) throws IOException {
        String t = reader.readLine();
        int m;
        try {
            m = Integer.parseInt(t);
        }catch (NumberFormatException e) {
            System.out.println("Невдача, введіть число ще раз");
            m = input_int(reader);
        }
        return m;
    }
    public static int input_menu_item(BufferedReader reader) throws IOException {
        String t = reader.readLine();
        int m;
        try {
            m = Integer.parseInt(t);
            if(m < 0 || m > 3){
                System.out.println("Невдача, розмір масиву не може бути від`ємним,\n введіть число ще раз");
                m = input_menu_item(reader);
            }
        }catch (NumberFormatException e) {
            System.out.println("Невдача, введіть число ще раз");
            m = input_menu_item(reader);
        }
        return m;
    }
    public static ArrayList<Integer>  different(ArrayList<Integer> arr) throws IOException {
        ArrayList<Integer> new_arr = new ArrayList<>();

        for(int i = 0; i < arr.size(); i++){
            if(!is(new_arr, arr.get(i)))new_arr.add(arr.get(i));
        }
        return new_arr;
    }
    public static boolean is(ArrayList<Integer> arr, int a){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == a)return true;
        }
        return false;
    }

}
