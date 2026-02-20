import java.util.Scanner;
/**
 * Write a description of class Avatar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Avatar
{
    
    protected String name;
    protected int numberOfLives;

    public Avatar()
    {
        this.name = "";
        this.numberOfLives = 0;
    }

    public Avatar(String name, int lives)
    {
        this.name = name;
        this.numberOfLives = lives;
    }
    
    public String getName()
    {
        return this.name;
    }
    
     public void setName (String name)
    {
        this.name = name;
    }
    
    public int getNumberOfLives()
    {
        return this.numberOfLives;
    }

    public void setNumberOfLives(int lives)
    {
        this.numberOfLives = lives;
    }
    
    public String toString()
    {
        return "\nName = " + this.name + "\nNumber Of Lives = " + this.numberOfLives; 
        
    }
    
    public abstract boolean isAlive();
    
    public void getBonusLives()
    {
        this.numberOfLives = this.numberOfLives;
    }
    
    public void revive()
    {
        int lives = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many lives would you like?");
        lives = scan.nextInt(); scan.nextLine();
        
        this.numberOfLives = this.numberOfLives + lives;
    }
    
    public void revive(int lives)
    {
        this.numberOfLives = lives;
    }
    
    public abstract void interact(Avatar character);
}
