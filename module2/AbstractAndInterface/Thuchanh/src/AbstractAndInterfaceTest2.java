import animal.Animal;
import animal.Chicken2;
import animal.Tiger;
import edible.Edible;

public class AbstractAndInterfaceTest2 {

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken2();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken2) {
                Edible edibler = (Chicken2) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}