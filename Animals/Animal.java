public class Animal
{
    private String name;
    private int age;

    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;   
    }

    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return this.age;
    }

    public void makesNoise()
    {
        System.out.println("The " + this.name + " goes [noise]");
    }

}