// Interface Beverage
public interface Beverage {
    double cost();
}

// Boisson de base : Coffee
public class Coffee implements Beverage {
    public double cost() {
        return 3.0;
    }
}

// Boisson de base : Tea
public class Tea implements Beverage {
    public double cost() {
        return 2.5;
    }
}

// Exemple de décorateur : Milk
public class MilkDecorator implements Beverage {
    private Beverage beverage;

    public MilkDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost() + 0.5;
    }
}

// Exemple de décorateur : Sugar
public class SugarDecorator implements Beverage {
    private Beverage beverage;

    public SugarDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost() + 0.2;
    }
}

// Nouvelle boisson : HotChocolate
public class HotChocolate implements Beverage {
    public double cost() {
        return 3.5;
    }
}

// Test dans la classe principale
public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee = new MilkDecorator(coffee);   // Coffee + Milk
        coffee = new SugarDecorator(coffee);  // Coffee + Milk + Sugar
        System.out.println("Cost: " + coffee.cost()); // Affiche le coût total

        Beverage hotChocolate = new HotChocolate();
        hotChocolate = new SugarDecorator(hotChocolate); // HotChocolate + Sugar
        System.out.println("Cost: " + hotChocolate.cost()); // Affiche le coût total
    }
}
