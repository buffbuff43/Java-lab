package org.example;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class Main {
    public static void searchWord(List<String> words) {
        System.out.println(words.stream()
                .collect(groupingBy(w -> w, counting())) // группировка слов по количеству их повторений
                .entrySet().stream()
                .collect(groupingBy(
                        Map.Entry::getValue, // группировка по количеству повторений
                        mapping(Map.Entry::getKey, toList()) // преобразование в список слов
                ))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getKey)) // нахождение группы с максимальным количеством повторений
                .map(Map.Entry::getValue) // извлечение списка слов с максимальным количеством повторений
                .orElse(Collections.emptyList())
                .stream().collect(groupingBy(String::length)) // группировка слов по их длине
                .entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getKey)) // нахождение группы с минимальной длиной слов
                .map(Map.Entry::getValue) // извлечение списка слов с минимальной длиной
                .orElse(Collections.emptyList())
                .stream().collect(Collectors.joining(", ")));
    }

    public static void main(String[] args) {
        System.out.println(" — Задание №1");
        List<String> words = new ArrayList<>(Arrays.asList("ябло","ябло", "банан", "киви", "киви"));
        searchWord(words);

        System.out.println("\n — Задание №2");
        Product[] allProducts = {
                new Product("Оригинальная зарядка для айфона", "США", 5000.0, 130),
                new Product("Неоригинальная зарядка для айфона", "Китай", 500.0, 4000),
                new Product("Айфон", "США", 50000.0, 80),
                new Product("Инструмент", "Россия", 3000.0, 4900),
                new Product("Зарядка для самсунга", "Китай", 300.0, 6000),
                new Product("Запчасть для автомобиля", "Германия", 2000.0, 7000),
                new Product("МакБук", "США", 100000.0, 50),
                new Product("Часы", "Швейцария", 2000.0, 2100),
                new Product("Нож", "Швейцария", 2000.0, 3100),
                new Product("Тесла", "США", 9000000.0, 30),
                new Product("Кроссовки найк", "США", 30000.0, 40),


        };

        findRareProducts(allProducts, "США", 3);
    }

    public static void findRareProducts(Product[] products, String filterCountry, int N) {
        System.out.println(Arrays.stream(products)
                .filter(p -> p.getCountry().equals(filterCountry))
                .sorted(Comparator.comparingDouble(Product::getQuantity))
                .limit(N)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .map(p -> p.getName())
                .collect(joining(", ", N + "редких продуктов на складе:", "")));
    }
}