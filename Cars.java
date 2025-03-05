/*
 * Author: Jordan Merriman
 * Date: 2/25/2025
 * Subject: Getters and setter in OOP
 */

import java.util.Scanner; // this is so I can get inputs and then in turn require a positive value in a setter

public class Cars
{
    public class Car
    {
        private String model;
        private int mileage;
        private String color;
        private String make;

            //constructor
        public Car(String model, int mileage, String color, String make)
        {
            this.model = model;
            this.mileage = mileage;
            this.color = color;
            this.make = make;
        }

            // getters
        public String getModel()
        {
            return this.model;
        }
        public String getMake()
        {
            return this.make;
        }
        public int getMileage()
        {
            return this.mileage;
        }
        public String getColor()
        {
            return this.color;
        }
            // setters
        public void setModel(String car)
        {
            this.model = car;
        }
        public void setMake(String car)
        {
            this.make = car;
        }
        public void setMileage(int car)
        {
            this.mileage = car;
        }
        public void setColor(String car)
        {
            this.color = car;
        }
        //void allows me to not return anything

        public String display()
        {
            return "the car is a " + this.make + " " + this.model + ", its is " + this.color + " and has " + this.mileage + " miles.";
        }
    }

        public static void main(String [] args)
    {
        Cars cars = new Cars(); // open car so it works
        Scanner input = new Scanner(System.in); //creates the scanner object
        Car one = cars.new Car("Journey", 18000, "Black", "Dodge"); // My car :) update as you please
        while (true){
            System.out.println("Welcome to the car editor type 'car' to see what your car is now, type 'make' to edit the make, type 'miles' to adjust the mileage\ntype 'color' to change the color, type 'model' to change the model, and type 'done' to end the program."); //give the user options
            String choice = input.nextLine().toLowerCase(); // read what they say and make it lowercase to allow errors
            switch (choice) //switch only doesn't allow operations which is why I set choice to lowercase as it's input. 
            {
                case "car": // essentially works as an if else if ladder.
                    System.out.println(" do you want the readable version(type 'read') or just the values(type anything else)?");
                    String choi = input.nextLine(); // just so I can check the get methods
                    if(choi.equalsIgnoreCase("read"))
                    {
                        System.out.println(one.display());
                    }
                    else
                    {
                        System.out.println(one.getModel() + " " + one.getMileage() + " " + one.getColor() + " " + one.getMake());
                    }
                    break; // unless fully ending code break statement so you can go back to normal
                case "make": 
                
                    System.out.println("What is the new make?");
                    String inputty = input.nextLine(); // reads the string so that the user can change the input
                    one.setMake(inputty);
                    System.out.println("Updated.");
                    break;
                case "miles":
                    System.out.println("What is the new mileage?");
                    while (true)
                    {
                        int inputMi = input.nextInt(); // takes an integer rather than a string
                        input.nextLine(); // makes a buffer so the scanner doesn't immediately try to use whatever isn't an int ak the next value
                        if (inputMi >= 0)
                        {
                            one.setMileage(inputMi);
                            System.out.println("Updated.");
                            break; // if value is postive no need to try again
                        }
                        else
                        {
                            System.out.println("Value must be positive. Try again");
                        }
                    }
                    break;
                
                case "color":
                    System.out.println("what is the new color?");
                    String inputCol = input.nextLine();
                    one.setColor(inputCol);
                    System.out.println("Updated.");
                    break;
            
                case "model":
                    System.out.println("What is the new model?");
                    String inputMod = input.nextLine();
                    one.setModel(inputMod);
                    System.out.println("Updated.");
                    break;

                case "done": // when they are done finish while true, close program
                
                    input.close(); //doesn't leave the scanner open
                    System.exit(1); // stops code completely
                
                default: // this is done so that if they don't follow the rules it doesn't break
                
                    System.out.println("Unknown command.");
            }
        }
    }
}
