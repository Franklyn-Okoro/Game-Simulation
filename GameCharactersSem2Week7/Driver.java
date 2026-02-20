import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    ArrayList<Avatar> list;

    public Driver()
    {
        list = new ArrayList<Avatar>();
        int option = 0;
        Scanner scan = new Scanner(System.in);
        Human h;
        Animal a;
        Shape s;
        String name, gender, hColour, tool, animal, shape , colour;
        int lives = 0;
        double speed = 0;
        boolean predator = true;

        while(option != 4)
        {
            System.out.println("\f");

            System.out.println("\tCreating Avatars Menu");
            System.out.println("\t------------");
            System.out.println("\t1. Input a Human Avatar");
            System.out.println("\t2. Input a Shape Avatar");
            System.out.println("\t3. Input a Animal Avatar");
            System.out.println("\t4. Exit this menu and continue with rest of the program");
            option = processMenu();

            if (option == 1)
            {
                insertHumanAvatars();
            }
            else if (option == 2)
            {
                insertShapeAvatars();
            }
            else if(option == 3)
            {
                insertAnimalAvatars();
            }
            else
            {
                System.out.println("you have exitted the menu.");
            }

            System.out.println("Press enter to continue:");
            scan.nextLine();
        }

        //insertAvatars();
        displayAllAvatars();
        isAlive();
        displayHumans();
        deleteGreenShapes();
        //displayAllAvatars();
        removeDangerousAnimals();
        //displayAllAvatars();
        getExtraLives();
        displayAllAvatars();
        updateLives();
        displayLives();

        for(Avatar ava: list)
        {
            System.out.println(ava.getName() + " The character is alive: " + ava.isAlive());
        }
        shapeDetails();
        calculateLargestShape();
    }

    public int processMenu()
    {
        int option = 0;
        Scanner scan = new Scanner(System.in);

        do
        {
            System.out.print("\nEnter menu option (1-4): ");
            option = scan.nextInt();
        }while (option < 1 || option > 4);

        return option;
    }

    public void insertHumanAvatars()
    {
        Scanner scan = new Scanner(System.in);
        Human h;
        String name, gender, hColour, tool;
        int lives = 0;

        System.out.print("\f ");

        for(int i = 0; i < 1;i++)
        {
            System.out.println("\nInputting a new human...");

            System.out.println("\n\nEnter name : ");
            name = scan.nextLine();
            System.out.println("\n\nEnter number of lives : ");
            lives = scan.nextInt(); 
            scan.nextLine();
            System.out.println("\n\nEnter gender for avatar : ");
            gender = scan.nextLine();            
            System.out.println("\n\nEnter hair colour for avatar : ");
            hColour = scan.nextLine();
            System.out.println("\n\nEnter tool used by avatar : ");
            tool = scan.nextLine();

            h = new Human(name, lives, gender, hColour, tool);
            list.add(h);

        }
    }

    public void insertShapeAvatars()
    {
        Scanner scan = new Scanner(System.in);
        Shape s;
        String name, shape , colour;
        int lives = 0;
        int edge = 0;

        System.out.print("\f ");
        for(int i = 0; i < 1;i++)
        {
            System.out.println("\nInputting a new shape...");

            System.out.println("\n\nEnter name : ");
            name = scan.nextLine();
            System.out.println("\n\nEnter number of lives : ");
            lives = scan.nextInt(); 
            scan.nextLine();
            System.out.println("\n\nEnter a shape : ");
            shape = scan.nextLine();
            System.out.println("\n\nEnter a colour : ");
            colour = scan.nextLine();
            System.out.println("\n\nEnter number of edges: ");
            edge = scan.nextInt();

            s = new Shape(name, lives, shape, colour,edge);
            list.add(s);
        }
    }

    public void insertAnimalAvatars()
    {
        Scanner scan = new Scanner(System.in);
        Animal a;
        String name, animal;
        int lives = 0;
        double speed = 0;
        boolean predator = true;

        System.out.print("\f ");
        for(int i = 0; i < 1;i++)
        {
            System.out.println("\nInputting a new animal...");

            System.out.println("\nEnter name : ");
            name = scan.nextLine();
            System.out.println("\nEnter number of lives : ");
            lives = scan.nextInt(); 
            scan.nextLine();
            System.out.println("\nEnter animal : ");
            animal = scan.nextLine();            
            System.out.println("\nIs the animal a predator : ");
            predator = scan.nextBoolean();            
            System.out.println("\nEnter animals speed : ");
            speed = scan.nextDouble();
            scan.nextLine();

            a = new Animal(name, lives, animal, predator, speed);
            list.add(a);
        }
    }

    public void displayAllAvatars()
    {
        System.out.println("Displaying all Avatars...");
        Human h;
        Animal a;
        Shape s;
        double speed;
        String name;
        String animal;

        for(Avatar ava : list)
        {

            System.out.println(ava.toString());                

        }

        for(Avatar ava: list)
        {

            if(ava instanceof Animal)
            {
                a = (Animal) ava;
                speed = a.getSpeed();
                name = a.getName();
                animal = a.getAnimal();
                System.out.println("Display the animals that are dangerous...");

                if(a.getSpeed() > 30)
                {
                    System.out.println(a.getName() + ", the " +  a.getAnimal() + " is dangerous...");
                }
                else
                {
                    System.out.println(a.getName() + ",the " +  a.getAnimal() + " is not dangerous...");
                }
            }

        }
    }

    public void isAlive()
    {
        boolean alive = true;
        String name ="";
        int lives = 0;
        int count = 0;

        for(Avatar ava: list)
        {
            alive = ava.isAlive();
            name = ava.getName();
            lives = ava.getNumberOfLives();

            if(alive == true)
            {
                count++;                
                System.out.println("\n\nThere are " + count + " avatars alive.");                                               
                System.out.println("\n\n" + ava.getName() + ",This avatar has " + ava.getNumberOfLives() + " live(s) left.");                               
            }                      
        }

    }

    public void displayHumans()
    {
        Human h;
        String tool;

        for(Avatar ava : list)
        {
            if(ava instanceof Human)
            {
                h = (Human) ava;

                h.correctTool();
                System.out.println(h.toString() + "\n");
            }
        }
    }

    public void deleteGreenShapes()
    {
        Shape s;
        boolean moreShapes = false;

        do
        {
            s = null;
            moreShapes = false;
            for(Avatar ava: list)
            {
                if(ava instanceof Shape)
                {
                    s = (Shape) ava;
                    if(s.getColour().equalsIgnoreCase("green"))
                    {
                        moreShapes = true;
                    }
                }
            }
            if(moreShapes)
            {  
                System.out.println("\nRemoving " + s.getName());
                list.remove(s);
            }
        }while(moreShapes);

    }

    public void removeDangerousAnimals()
    {
        int lives = 0;
        Animal a;

        for(Avatar ava : list)
        {
            if(ava instanceof Animal )
            {
                a = (Animal) ava;
                lives = a.getNumberOfLives();
                if(a.isDangerous() == true)
                {
                    a.setNumberOfLives(0);
                }
            }
        }

    }

    public void getExtraLives()
    {

        for(Avatar ava: list)
        {
            ava.getBonusLives();
        }

    }

    public void updateLives()
    {
        Human h;
        Shape s;
        Animal a;

        for(Avatar ava : list)
        {
            if(ava instanceof Human)
            {
                h = (Human) ava;
                ava.revive(10);
            }
            else
            {
                ava.revive();
            }
        }
    }

    public void displayLives()
    {
        Human h;
        Shape s;
        Animal a;

        for(Avatar ava: list)
        {
            if(ava instanceof Human)
            {
                h = (Human) ava;
                System.out.println("This is a human avatar and has " + h.getNumberOfLives() + " lives left");               
            }
            else if(ava instanceof Animal)
            {
                a = (Animal) ava;
                System.out.println("This is a animal avatar and has " + a.getNumberOfLives() + " lives left");   
            }
            else if(ava instanceof Shape)
            {
                s = (Shape) ava;
                System.out.println("This is a shape avatar and has " + s.getNumberOfLives()+ " lives left");
            }
        }       
    }

    public void shapeDetails()
    {
        Shape s;

        for(Avatar ava: list)
        {
            if(ava instanceof Shape)
            {
                s = (Shape) ava;
                System.out.println("Shape details:");
                System.out.println("\nName: " + s.getName());
                System.out.println("Shape: " + s.getShape());
                System.out.println("Edges: " + s.getEdge());
            }

        }
    }

    public void calculateLargestShape()
    {
        Shape s ;
        Shape largeShape = null;
        int largest=0;
        String name = "";

        for(Avatar ava: list)
        {
            if(ava instanceof Shape)
            {
                s = (Shape) ava;
                if(s.getEdge() > largest)
                {
                    largeShape = s;
                    largest = s.getEdge();
                }

            }
        }
        System.out.println(largeShape.getName() + "'s shape has the largest number of edges");
        System.out.println("The shape is " + largeShape.getShape());
        System.out.println("It has " + largeShape.getEdge() + " edges");
    }

    public static void main(String []args)
    {
        new Driver();
    }
}
