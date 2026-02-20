
/**
 * Write a description of class Animal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animal extends Avatar
{
    private String animal;
    private boolean predator;
    private double speed;

    public Animal()
    {
        super();
        this.animal ="";
        this.predator = false;
        this.speed = 0;
    }

    public Animal(String name, int lives, String animal, boolean predator, double speed)
    {
        super(name, lives);
        this.animal = animal;
        this.predator = predator;
        this.speed = speed;
    }

    public String getAnimal()
    {
        return this.animal;
    }

    public void setAnimal(String animal)
    {
        this.animal = animal;
    }

    public boolean predator()
    {
        return this.predator;
    }

    public void setPredator(boolean predator)
    {
        this.predator = predator;
    }

    public double getSpeed()
    {
        return this.speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public boolean isDangerous()
    {
        if(this.speed > 30)
        {
            this.predator = true;
        }
        else
        {
            this.predator = false;
        }

        return this.predator;
    }
    
    public String toString()
    {
        return "\nThis is a animal avatar" +  "\nAnimal: " + this.animal + super.toString() + "\nIS this a Predator: "
        + this.predator + "\nSpeed in KM: " + this.speed ;
    }
    
    public void testToString()
    {
        System.out.print("\f");
        System.out.println(toString());
    }
    
    public void getBonusLives()
    {
        int lives = getNumberOfLives() + 30;
        setNumberOfLives(lives);
    }
    
    public boolean isAlive()
    {
        boolean alive = false;
        
        if(getNumberOfLives() > 0 && this.speed > 0)
        {
            alive = true;
        }
        else
        {
            alive = false;
        }
                
        return alive;
    }
    
    public void interact(Avatar character)
    {
        Human h = null;
        if(character instanceof Shape)
        {
            this.numberOfLives = this.numberOfLives + 2;
            character.setNumberOfLives(character.getNumberOfLives() + 5);
        }
        
        if(character instanceof Human)
        {           
            if(h.getTool().equalsIgnoreCase("spear"))
            {
                this.numberOfLives = this.numberOfLives - this.numberOfLives;
                System.out.println("The animal has been killed, lives = " + this.numberOfLives);
            }
            else
            {
                character.setNumberOfLives(0);
                System.out.println("The Human has been killed: lives = " + character.getNumberOfLives());
            }
        }
    }
}
