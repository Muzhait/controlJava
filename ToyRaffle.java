import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ToyRaffle {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy("1", "Игрушка1", 10, 20));
        toyStore.addToy(new Toy("2", "Игрушка2", 5, 30));
        toyStore.addToy(new Toy("3", "Игрушка3", 7, 50));
        Toy drawnToy = toyStore.drawToy();
        if (drawnToy != null) {
            System.out.println("Выпавшая игрушка: " + drawnToy.getName());
            saveToFile(drawnToy);
        } else {
            System.out.println("Нет доступных игрушек для розыгрыша.");
        }
    }
    private static void saveToFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize.txt"))) {
            writer.write("Выигрышная игрушка: " + toy.getName());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}