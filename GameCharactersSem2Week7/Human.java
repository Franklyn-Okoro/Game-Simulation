import java.util.Scanner;
/**
 * Write a description of class Human here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Human extends Avatar
{
    private String gender;
    private String hColour;
    private String tool;

    public Human()
    {
        super();
        this.gender = "";
        this.hColour ="";
        this.tool = "";
    }

    public Human(String name, int lives, String gender, String hColour, String tool)

    {
        super(name , lives);
        this.gender = gender;
        this.hColour = hColour;
        this.tool = tool;        
    }

    public String getGender()
    {
        return this.gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String gethColour()
    {
        return this.hColour;
    }
    
    public void sethColour(String hColour)
    {
        this.hColour = hColour;
    }

    public String getTool()
    {
        return this.tool;
    }
    
    public void setTool(String tool)
    {
        this.tool = tool;
    }
    
    public String toString()
    {
        return "\nThis is a human avatar" + "\nGender: " + this.gender + super.toString() + "\nHair Colour: "
        + this.hColour + "\nTool:" + this.tool;
    }
    
    public void correctTool()
    {
        /** =   I use a single equals when carrying out an assignment statement */
        /** ==  test for equality for ints, chars, doubles amd booleans only */
        /** equals() equalsIgnoreCase() ; test for equality for Strings only */
        
        if(getTool().equals("saw") || getTool().equals("spear")
        || getTool().equals("shovel"))
        {
            System.out.println(getName() + " is using a " + getTool());
        }
        else
        {
           this.tool = "saw";
        }
    }
    
    public void getBonusLives()
    {
        int lives = getNumberOfLives() + 20;
        setNumberOfLives(lives);
    }
    
    public boolean isAlive()
    {
        int temp = 0;
        Scanner scan = new Scanner(System.in);
        boolean alive = false;
        
        System.out.println("Enter temperature for human avatar");
        temp = scan.nextInt();
        
        if(temp >= 22 && temp <= 42 && getNumberOfLives() > 0)
        {
            alive = true;
            System.out.println("The human avatar is alive");
        }
        else
        {
            alive = false;            
            System.out.println("The human avatar is dead");
        }
                
        return alive;
    }
    
    public void interact(Avatar character)
    {
        
    }
}
