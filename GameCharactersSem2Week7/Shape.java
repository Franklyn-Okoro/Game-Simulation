import java.util.Scanner;
/**
 * Write a description of class Shape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shape extends Avatar
{
    private String shape;
    private String colour;
    private int edge;
    
    public Shape()
    {
       super();
       this.shape = "";
       this.colour = "";
       this.edge = 0;
    }

    public Shape(String name, int lives, String shape , String colour,int edge)
    {
       super(name, lives);
       this.shape = shape;
       this.colour = colour;
       this.edge = edge;
    }
    
    public String getColour()
    {
        return this.colour;
    }
    
    public void setColour(String colour)
    {
        this.colour = colour;
    }
    
    public String getShape()
    {
        return this.shape;
    }
    
    public void setShape(String shape)
    {
        this.shape = shape;
    }
    
    public int getEdge()
    {
        return this.edge;
    }
    
    public void setEdge(int edge)
    {
        this.edge = edge;
    }
    
    public String toString()
    {
       return "\nThis is a shape avatar" + "\nShape: " + this.shape + super.toString() + "\n Colour: "
        + this.colour + "\nEdges: " + this.edge;
    }
    
    public void getBonusLives()
    {
        int lives = getNumberOfLives() + 10;
        setNumberOfLives(lives);
    }
    
    public boolean isAlive()
    {
        boolean alive = false;
        
        if(getNumberOfLives() > 0)
        {
            alive = true;
        }
        else
        {
            alive = false;
        }
        
        if( (this.colour.equalsIgnoreCase("red") && this.shape.equalsIgnoreCase("square")) ||
        (this.colour.equals("green") && this.shape.equalsIgnoreCase("circle")))
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
        if(character instanceof Animal)
        {
            this.numberOfLives = this.numberOfLives + 5;
            character.setNumberOfLives(character.getNumberOfLives() + 2);
            System.out.println("Both Avatars are both alive");
        }
    }
}
