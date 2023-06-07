/**
 * This class stores the information of the chicken.  This class has a method for each function of the chicken used in the ChickenCraft class
 *
 * @author Nevis Macintyre
 * @version V1.00
 */
public class Chicken{

    //instance variables
    private boolean isHappy;
    private boolean isAlive;
    private String name;
    private int hearts;
    private double seed;
    private int eggs;

    /** 
     *
     * It is a constructor. 
     *
     */
    public Chicken(){ 

        this("NANCY");
    }

    /** 
     *
     * It is a constructor. 
     *
     * @param name  the name
     */
    public Chicken( String name ){ 

        isHappy = true;
        isAlive = true;
        this.name = name;
        hearts = 4;
        seed = 0.1;        
    }    

    /** 
     *
     * Sets the name
     *
     * @param name  the name
     */
    public void setName(String name){ 

        name = this.name;
    }

    /** 
     *
     * Gets the name
     *
     * @return the name
     */
    public String getName(){ 

        return name;
    }

    /** 
     *
     * Sets the alive
     *
     * @param alive  alive
     */
    public void setAlive(String alive){ 

        if(alive.toUpperCase() == "ALIVE"){
            isAlive = true;
        }
        else{
            isAlive = false;   
        }
    }

    /** 
     *
     * Gets the alive
     *
     * @return the alive
     */
    public String getAlive(){ 

        String alive = "DEAD";
        if(isAlive){
            alive = "ALIVE";
        }
        return alive;        
    }    

    /** 
     *
     * Sets the mood
     *
     * @param mood  the mood
     */
    public void setMood(String mood){ 

        if(mood.toUpperCase() == "HAPPY"){
            isHappy = true;
        }
        else{
            isHappy = false;   
        }
    }

    /** 
     *
     * Gets the mood
     *
     * @return the mood
     */
    public String getMood(){ 

        String mood = "UNHAPPY";
        if(isHappy){
            mood = "HAPPY";
        }
        return mood;        
    }

    /** 
     *
     * Feeds the chicken
     *
     * @param amount  the amount of seed
     */
    public void feed(double amount){ 

        if(isAlive == true){
            seed += amount;
            if(hearts < 4 && hearts > 0){
                hearts++;
            }
            if(seed > 2.0){
                isAlive = false;
                hearts = 0;
            }
        }
    }
    
    public double getSeed(){
        return seed;
    }

    /** 
     *
     * Changes mood after playing
     *
     */
    public void play(){ 

        if(isAlive == true){
            isHappy = true;
        }
    }

    /** 
     *
     * Lowers health and changes mood after hit.
     *
     */
    public void hit(){ 

        isHappy = false;
        if(hearts > 0){
            hearts--;
        }
        if(hearts == 0){
            isAlive = false;
        }
    }

    /** 
     *
     * Gets the eggs
     *
     * @return the eggs
     */
    public int getEggs(){ 

        eggs = 0;
        if(isAlive == true && seed >= 0.25){
            seed -= 0.25;
            if(seed < 0){
                isAlive = false; 
                hearts = 0;
            }
            if(isHappy == true && isAlive == true){
                eggs = 2;
                isHappy = false;
            }
            else if(isHappy == false && isAlive == true){
                eggs = 1;

            }
        }
        else if(isAlive == true && seed < 0.25){
            eggs = -1;
        }
        else{
            eggs =0;
        }

        return eggs;
    }

    /** 
     *
     * To string
     *
     * @return String
     */
    public String toString(){ 

        String mood;
        mood = "UNHAPPY";
        if(isHappy == true){
            mood = "HAPPY";
        }

        String alive;
        alive = "DEAD";
        if(isAlive == true){
            alive = "ALIVE";
        }

        String output = String.format("%-8s %8s %6s %4d HEARTS \t %.2f Kg of seed", name, mood, alive, hearts, seed);
        return output;

    }   
}
