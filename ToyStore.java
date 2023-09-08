import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class ToyStore {
    private List<Toy> toys;
    public ToyStore() {
        toys = new ArrayList<>();
    }
    public void addToy(Toy toy) {
        toys.add(toy);
    }
    public void updateToyWeight(String id, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId().equals(id)) {
                toy.weight = newWeight;
                break;
            }
        }
    }
    public Toy drawToy() {
        Random random = new Random();
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        double randomWeight = random.nextDouble() * totalWeight;
        double weightSum = 0;
        for (Toy toy : toys) {
            weightSum += toy.getWeight();
            if (randomWeight <= weightSum) {
                toy.decreaseQuantity();
                return toy;
            }
        }
        return null;
    }
}