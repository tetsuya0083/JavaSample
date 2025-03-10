class Animal{
    private String species;
    private String name;
    private int count;

    Animal(){
        this.species = "default";
        this.name = "default";
        this.count = 0;
    }
    Animal(String species, String name){
        this.species = species;
        this.name = name;
        this.count = 0;
    }
    Animal(String name){
        this.species = "default";
        this.name = name;
        this.count = 0;
    }
    Animal(int count){
        this.species = "default";
        this.name = "default";
        this.count = count;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getSpecies() {
        return species;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
}

public class Zoo {
    public static void main(String[] args) {

        Animal elephant = new Animal("Mammals", "elephant");
        elephant.setCount(2);

        Animal monkeys = new Animal("monkey");
        monkeys.setSpecies("Primates");
        monkeys.setCount(11);

        Animal dog = new Animal(7);
        dog.setSpecies("Mammals");
        dog.setName("dog");

        System.out.println(elephant.getSpecies());
        System.out.println(elephant.getName());
        System.out.println(elephant.getCount());

        System.out.println(monkeys.getSpecies());
        System.out.println(monkeys.getName());
        System.out.println(monkeys.getCount());

        System.out.println(dog.getSpecies());
        System.out.println(dog.getName());
        System.out.println(dog.getCount());

    }
}
