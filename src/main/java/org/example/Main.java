package org.example;
import java.util.Scanner;

// лаба 2 - калькулятор здоровья

public class Main {
    public static final String GREEN = "\u001B[32m";
    public static final String RES_COLOR = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(GREEN + " >>> КАЛЬКУЛЯТОР ЗДОРОВЬЯ <<<" + GREEN);
        System.out.println(RES_COLOR + "-------------------------------");

        System.out.print("Введите свой текущий вес: ");
        double weight = sc.nextDouble();

        System.out.print("Введите свой текущий рост (в сантиметрах): ");
        double heightCM = sc.nextDouble();
        double height = heightCM / 100.0;

        System.out.print("Введите свой текущий возраст: ");
        int age = sc.nextInt();

        double height_2 = height * height;
        double imt_notform = (weight)/height_2;
        double imt = Math.round(imt_notform * 10.0) / 10.0;

        double perfect_weight_f = 24.9*height_2;
        double perfect_weight = Math.round(perfect_weight_f * 10.0) / 10.0;

        double weight_diff = weight - perfect_weight;

        // формула Харрисона-Бенедикта: 655,1 + (9.6 х массу тела в кг) + (1.85 х рост) - (возраст х 4.68)
        double formula = 655.1 + (9.6 * weight) + (1.85 * height) - (age * 4.68);
        int norm = (int)formula;

        if (imt > 24.9 && weight_diff > 0) {
            double weight_difff = weight - perfect_weight;
            double weight_diff1 = Math.round(weight_difff * 10.0) / 10.0;
                System.out.println("Рекомендуется снизить вес для достижения идеального веса. Идеальный вес: " +
                        perfect_weight + " Необходимо сбросить: " + weight_diff1 +
                        " Рекомендуемый дневной прием калорий: " + (norm-500) );
            System.out.println("Индекс массы тела: " + imt);
        }

        else if (imt < 18.5) {
            double diff = perfect_weight - weight;
            double difff = Math.round(diff * 10.0) / 10.0;
            System.out.println("Рекомендуется увеличить потребление пищи для набора веса. Идеальный вес: " +
                    perfect_weight + " Нужно набрать: " + difff + " Рекомендуемый дневной прием калорий: " + (norm+500));
            System.out.println("Индекс массы тела: " + imt);
        }

        else {
            System.out.println("Ваш вес находится в пределах нормы. " +
                    " Идеальный вес: " + perfect_weight +
                    " Рекомендуемый дневной прием калорий: " + (norm));
            System.out.println("Индекс массы тела: " + imt);
        }
    }
}