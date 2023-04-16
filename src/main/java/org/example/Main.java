package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static ArrayList<Toys> arrayToys = new ArrayList<>();

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {


        System.out.println("Введите цифру, что мы делаем:\n" +
                "1 - Добавить игрушку\n" +
                "2 - Провести розыгрыш\n" +
                "0 - Выход\n");
        Scanner scan = new Scanner(System.in);
        String menuChoice = scan.next();
        switch (menuChoice) {
            case "1" -> {
                System.out.println("Введите название игрушки\n");
                String name = scan.next();
                System.out.println("Введите вес игрушки\n");
                int weight = scan.nextInt();
                Toys toy = new Toys(GenID.idGenerete(), name, weight);
                arrayToys.add(toy);
                menu();
            }
            case "2" -> {
                System.out.println("Проводим розыгрыш!\n" +
                        "Вы выиграли...");
                ArrayList<String> nameToys = new ArrayList<>();
                if (arrayToys.size() > 0) {
                    for (Toys toy : arrayToys
                    ) {
                        for (int i = 0; i < toy.getFrequency(); i++) {
                            nameToys.add(toy.getNomenklature());
                        }
                    }
                    int randomNum = ThreadLocalRandom.current().nextInt(0, nameToys.size() + 1);
                    String surprise = nameToys.get(randomNum);
                    System.out.println(surprise);
                    writeResultToFile(surprise);
                    for (Toys toy : arrayToys
                    ) {
                        if (surprise.equals(toy.getNomenklature())) {
                            toy.setFrequency(toy.getFrequency() - 1);
                        }
                    }
                    menu();
                } else {
                    System.out.println("Сначала добавьте призы\n");
                    menu();
                }

            }

            case "0" -> System.out.println("Всего хорошего!");

            default -> {
                System.out.println("Нет такого варианта. Попробуйте еще раз\n");
                menu();
            }
        }
    }

    private static void writeResultToFile(String surprise) {
        try {
            FileWriter writer = new FileWriter("Result.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(surprise+"\n");
            bufferWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

