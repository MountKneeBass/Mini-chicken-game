import java.util.Scanner;

/**
 * This program starts up and displays an interactive chicken game by using various methods.  This program allows you to feed, hit, get eggs, and have the chickens play with eachother.
 * The program will not allow you to feed a dead chicken, feed a chicken a negative amount, have dead chiken play with a live one, have a chicken play with itself, hit a dead chicken, get eggs
 * from a dead chicken, ect. once two chickens die the play option becomes blocked and once all three chickens die the program shuts off.
 * 
 * Me, Monty and Zak worked on a lot this project together.  Monty worked a lot of the methods, me and Zak worked on most of the ChickenCraft class.  Even though we worked on it together we all went
 * went through what we did with each other and made sure we all understood.  we also seperated once the base of the code had been made and debugged on our own.
 *
 * @author Nevis Macintyre
 * @version V1.00
 */
public class ChickenCraft{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int choice;//menu option
        int which;//chicken option
        int which2;//second chicken for play option
        double amount;//amount of seed
        int allDead = 0;//total dead chickens
        int chicksFed = 0;
        
        Chicken chick1 = new Chicken("Eggman");
        Chicken chick2 = new Chicken("rex");
        Chicken chick3 = new Chicken();

        while(true){
            allDead = 0;
            chicksFed = 0;

            //Check how many chickens are dead

            if(chick1.getAlive().contains( "DEAD")){
                allDead++;

            }
            if(chick2.getAlive().contains( "DEAD")){
                allDead++;

            }
            if(chick3.getAlive().contains( "DEAD")){
                allDead++;

            }
            if(allDead == 3){//if all chickens are dead end the game
                System.out.println("All chicken are dead.  Game Over");
                break;
            }
            
            
            if(chick1.getAlive().contains( "DEAD") || chick1.getSeed() < 0.25){//makes sure you don't get stuck in the get eggs menu
                chicksFed++;

            }
            if(chick2.getAlive().contains( "DEAD") || chick2.getSeed() < 0.25){
                chicksFed++;

            }
            if(chick3.getAlive().contains( "DEAD")  || chick3.getSeed() < 0.25){
                chicksFed++;

            }
            
            

            //display main menu

            System.out.println("1. " + chick1);
            System.out.println("2. " + chick2);
            System.out.println("3. " + chick3);

            System.out.println();
            System.out.println();
            System.out.println("What do you want to do? Please enter a number from 1 - 5:");
            System.out.println("\t1. Feed");
            System.out.println("\t2. Play");
            System.out.println("\t3. Hit");
            System.out.println("\t4. Get Eggs");
            System.out.println("\t5. Quit");
            choice = input.nextInt();

            for(int i = 0; i < 1;){
                if(allDead == 2 && choice == 2){//check if choice 2 is an option, if not forces a different choice 
                    System.out.println("Too many dead chickens. choose again.  Choose again.\n");
                    System.out.println("1. " + chick1);
                    System.out.println("2. " + chick2);
                    System.out.println("3. " + chick3);

                    System.out.println();
                    System.out.println();
                    System.out.println("What do you want to do? Please enter a number from 1 - 5:");
                    System.out.println("\t1. Feed");
                    System.out.println("\t2. Play");
                    System.out.println("\t3. Hit");
                    System.out.println("\t4. Get Eggs");
                    System.out.println("\t5. Quit");
                    choice = input.nextInt();
                }
                else if(choice > 5 || choice < 1){//checks to make sure an invalid option has not been chosen, if it has force a different choice
                    System.out.println("Invalid choice.  Choose again.\n");
                    System.out.println("1. " + chick1);
                    System.out.println("2. " + chick2);
                    System.out.println("3. " + chick3);

                    System.out.println();
                    System.out.println();
                    System.out.println("What do you want to do? Please enter a number from 1 - 5:");
                    System.out.println("\t1. Feed");
                    System.out.println("\t2. Play");
                    System.out.println("\t3. Hit");
                    System.out.println("\t4. Get Eggs");
                    System.out.println("\t5. Quit");
                    choice = input.nextInt();
                }
                else if(choice == 4 && chicksFed == 3){// makes sure you dont get stuck in the eggs option
                    System.out.println("Atleast one chicken needs over 0.25 seed.  Choose again.\n");
                    System.out.println("1. " + chick1);
                    System.out.println("2. " + chick2);
                    System.out.println("3. " + chick3);

                    System.out.println();
                    System.out.println();
                    System.out.println("What do you want to do? Please enter a number from 1 - 5:");
                    System.out.println("\t1. Feed");
                    System.out.println("\t2. Play");
                    System.out.println("\t3. Hit");
                    System.out.println("\t4. Get Eggs");
                    System.out.println("\t5. Quit");
                    choice = input.nextInt();
                }
                else{//if a valid choice has been made, break loop
                    i++;
                }
            }

            if(choice == 1){
                System.out.println("How much would you like to feed the chicken?");
                amount = input.nextDouble();
                for(int i = 0; i < 1;){
                    if( amount < 0){//make sure a chicken has not been fed a negative value, if it has force another amount
                        System.out.println("You can't unfeed a chicken");
                        System.out.println("How much would you like to feed the chicken?");
                        amount = input.nextDouble();
                    }
                    else{// if no conditions met break loop
                        i++;
                    }
                }
                System.out.println("Which chicken do you want to feed (1 - 3)");
                which = input.nextInt();
                for(int i =0; i < 1;){
                    if (which  > 3  || which < 1){//check choice is valid
                        System.out.println("invalid choice");
                        System.out.println("Which chicken do you want to feed (1 - 3)");
                        which = input.nextInt();
                    }

                    //make sure chickens are alive

                    else if(chick1.getAlive().contains("DEAD") && which == 1){
                        System.out.println("Dead chickens can't eat");
                        System.out.println("Which chicken do you want to feed (1 - 3)");
                        which = input.nextInt();
                    }
                    else if(chick2.getAlive().contains("DEAD") && which == 2){
                        System.out.println("Dead chickens can't eat");
                        System.out.println("Which chicken do you want to feed (1 - 3)");
                        which = input.nextInt();
                    }
                    else if(chick3.getAlive().contains("DEAD") && which == 3){
                        System.out.println("Dead chickens can't eat");
                        System.out.println("Which chicken do you want to feed (1 - 3)");
                        which = input.nextInt();
                    }
                    else{//if no conditions are met, break loop
                        i++;
                    }
                }

                //takes the chicken, the amount, and runs it through the feed method 

                if(which == 1){chick1.feed(amount);}
                else if(which == 2){chick2.feed(amount);}
                else if(which == 3){chick3.feed(amount);}

            }

            else if(choice == 2){

                System.out.println("Which chicken do you want to play (1 - 3)");
                which = input.nextInt();
                for(int i= 0; i < 1;){
                    if(which > 3 || which < 1){//makes sure choice is valid
                        System.out.println("invalid choice");
                        System.out.println("Which chicken do you want to play (1 - 3)");
                        which = input.nextInt();
                    }

                    //makes sure the chicken isn't dead

                    else if(chick1.getAlive().contains( "DEAD") && which == 1){
                        System.out.println("Let him rest in peace");
                        System.out.println("Which chicken do you want to play (1 - 3)");
                        which = input.nextInt();

                    }
                    else if(chick2.getAlive().contains( "DEAD") && which == 2){
                        System.out.println("Let him rest in peace");
                        System.out.println("Which chicken do you want to play (1 - 3)");
                        which = input.nextInt();

                    }
                    else if(chick3.getAlive().contains( "DEAD") && which == 3){
                        System.out.println("Let him rest in peace");
                        System.out.println("Which chicken do you want to play (1 - 3)");
                        which = input.nextInt();

                    }
                    else{//if no conditions are met break loop
                        i++;
                    }
                }
                System.out.println("Who do you want them to play with? (1 - 3)");
                which2 = input.nextInt();
                for(int i = 0; i < 1;){
                    if(which2 > 3 || which2 < 1){//makes sure choice is valid
                        System.out.println("invalid choice");
                        System.out.println("Who do you want them to play with? (1 - 3)");
                        which2 = input.nextInt();
                    }
                    else if(which == which2){//makes sure chicken isn't playing with itself
                        System.out.println("Chicken needs a friend");
                        System.out.println("Who do you want them to play with? (1 - 3)");
                        which2 = input.nextInt();

                    }

                    //makes sure chicken isn't dead

                    else if(chick1.getAlive().contains( "DEAD") && which2 == 1){
                        System.out.println("Let him rest in peace");
                        System.out.println("Who do you want them to play with? (1 - 3)");
                        which2 = input.nextInt();

                    }
                    else if(chick2.getAlive().contains( "DEAD") && which2 == 2){
                        System.out.println("Let him rest in peace");
                        System.out.println("Who do you want them to play with? (1 - 3)");
                        which2 = input.nextInt();

                    }
                    else if(chick3.getAlive().contains( "DEAD") && which2 == 3){
                        System.out.println("Let him rest in peace");
                        System.out.println("Who do you want them to play with? (1 - 3)");
                        which2 = input.nextInt();

                    }
                    else{//if no conditions are met break loop
                        i++;
                    }
                }

                //runs first chosen chicken through play method

                if(which == 1){chick1.play();}
                else if(which == 2){chick2.play();}
                else if(which == 3){chick3.play();}

                //runs second chosen chicken through play method

                if(which2 == 1){chick1.play();}
                else if(which2 == 2){chick2.play();}
                else if(which2 == 3){chick3.play();}

                System.out.println("Yay, playdate!");
            }

            else if(choice == 3){
                System.out.println("Which chicken do you want to hit (1 - 3)");
                which = input.nextInt();
                for(int i = 0; i < 1;){
                    if(which > 3 || which < 1){//makes sure choice is valid 
                        System.out.println("invalid choice");
                        System.out.println("Which chicken do you want to hit (1 - 3)");
                        which = input.nextInt();
                    }

                    //makes sure chicken isn't dead

                    else if(chick1.getAlive().contains( "DEAD") && which == 1){
                        System.out.println("You monster");
                        System.out.println("Which chicken do you want to hit (1 - 3)");
                        which = input.nextInt();

                    }
                    else if(chick2.getAlive().contains( "DEAD") && which == 2){
                        System.out.println("You monster");
                        System.out.println("Which chicken do you want to hit (1 - 3)");
                        which = input.nextInt();

                    }
                    else if(chick3.getAlive().contains( "DEAD") && which == 3){
                        System.out.println("You monster");
                        System.out.println("Which chicken do you want to hit (1 - 3)");
                        which = input.nextInt();

                    }

                    else{//if no conditions are met, break loop
                        i++;
                    }
                }

                //run chicken through hit method

                if(which == 1){chick1.hit();}
                else if(which == 2){chick2.hit();}
                else if(which == 3){chick3.hit();}
            }

            else if(choice == 4){
                System.out.println("Who do you want to get eggs from (1 - 3)");
                which = input.nextInt();
                for(int i= 0; i < 1;){
                    if(which > 3 || which < 1){//makes sure choice is valid
                        System.out.println("invalid choice");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();
                    }

                    //makes sure chicken isn't dead

                    else if(chick1.getAlive().contains( "DEAD") && which == 1){
                        System.out.println("Dead chickens don't lay eggs");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();

                    }
                    else if(chick2.getAlive().contains( "DEAD") && which == 2){
                        System.out.println("Dead chickens don't lay eggs");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();

                    }
                    else if(chick3.getAlive().contains( "DEAD") && which == 3){
                        System.out.println("Dead chickens don't lay eggs");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();

                    }

                    //makes sure the chicken has enough seed

                    else if(which == 1 && chick1.getEggs()< 0 ){ 
                        System.out.println("Chicken need more seed");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();
                    }
                    else if(which == 2 && chick2.getEggs() < 0 ) {
                        System.out.println("Chicken need more seed");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();
                    }
                    else if(which == 3 && chick3.getEggs() < 0 ) {
                        System.out.println("Chicken need more seed");
                        System.out.println("Who do you want to get eggs from (1 - 3)");
                        which = input.nextInt();
                    }
                    else{//if no conditioins are met break the loop
                        i++;
                    }
                }

                if(which == 1){ System.out.println("you got "+chick1.getEggs()+ "eggs!");}
                else if(which == 2 ) {System.out.println("you got "+chick2.getEggs()+ "eggs!");}
                else if(which == 3) {System.out.println("you got "+chick3.getEggs()+ "eggs!");}

            }
            else if(choice == 5){//exit game
                break;
            }

        }
        System.out.println("Thanks for playing ChickenCraft!");
    }
}
