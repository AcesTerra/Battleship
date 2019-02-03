
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */

/*

    Almost everything in code is public or private, it means that any class of this package can modify the vales.
    It was designed like that because it is ment to be used by two people and they interact each other so it was
    easier to handle the code and we considered there was no reason to do it more complicated.

*/
public class Game {
    
    public static void main(String[] args) //Here is the flow of the game
    {
        System.out.println("Battleship");
        System.out.println("DO NOT LEAVE HOSTAGES!!!!!!!!");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of player 1");
        String name1 = keyboard.nextLine();
        System.out.println("Enter the name of player 2");
        String name2 = keyboard.nextLine();
        
        int count = 1;
        
        Player player1 = new Player(name1, count); //Creates a new Player called player1
        count++;
        Player player2 = new Player(name2, count); //Creates a new Player called player2
        
        System.out.println("Player 1: " + player1.name);
        System.out.println("Player 2: " + player2.name);
        System.out.println("");
        
        //Show both rival and own map of player1
        //System.out.println(player1.name + ", this is your rival map");
        //drawRivalMap(player1);
        //System.out.println("");
        System.out.println(player1.name + ", this is your own map");
        drawOwnMap(player1);
        System.out.println("");
        
        //Instructions
        System.out.println("P = Patrol boat");
        System.out.println("D = Destroyer");
        System.out.println("A = Aircraft");
        System.out.println("You have to enter the x coordinate and the y coordinate of every position of ships\n");
        
        //Player1 setting their ships
        System.out.println(player1.name + ", set your Patrol boat\n");
        setPatrol(player1);
        System.out.println(player1.name + ", set your Destroyer\n");
        setDestroyer(player1);
        System.out.println(player1.name + ", set your Aircraft\n");
        setAircraft(player1);
        
        //Show the rival map after setting the boats
        //System.out.println(player1.name + ", here is your enemy map");
        //drawRivalMap(player1);
        //System.out.println("");
        //Show the own map after setting the boats
        System.out.println(player1.name + ", here is your map");
        drawOwnMap(player1);
        System.out.println("Press enter");
        
        //Wait untill a user enter
        keyboard.nextLine();
        for(int i = 0; i < 50; i++)
        {
            System.out.println("----");
        }
        keyboard.nextLine();
        
        //Show both rival and own map of player2
        //System.out.println(player2.name + ", this is your rival map");
        //drawRivalMap(player2);
        //System.out.println("");
        System.out.println(player2.name + ", this is your own map");
        drawOwnMap(player2);
        System.out.println("");
        
        //Instructions
        System.out.println("P = Patrol boat");
        System.out.println("D = Destroyer");
        System.out.println("A = Aircraft");
        System.out.println("You have to enter the x coordinate and the y coordinate of every position of ships\n");
        
        //Player2 setting their ships
        System.out.println(player2.name + ", set your Patrol boat\n");
        setPatrol(player2);
        System.out.println(player2.name + ", set your Destroyer\n");
        setDestroyer(player2);
        System.out.println(player2.name + ", set your Aircraft\n");
        setAircraft(player2);
        
        //Show the rival map
        //System.out.println(player2.name + ", here is your enemy map");
        //drawRivalMap(player2);
        //System.out.println("");
        //Show the own map
        System.out.println(player2.name + ", here is your map");
        drawOwnMap(player2);
        System.out.println("Press enter");
        
        keyboard.nextLine();
        for(int i = 0; i < 50; i++)
        {
            System.out.println("-----");
        }
        keyboard.nextLine();
        
        //Begin the carnage!!!
        System.out.println(player1.name + " you go first\n");
        System.out.println("You will have to enter the x and y coordinate of your shoots.\n");
        System.out.println("Your shots will appear in your rival map\n");
        System.out.println("H = You have hit a part of a ship");
        System.out.println("X = You shot and there is nothing there");
        System.err.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Patrol boat can attack once each turn, and each shoot takes 1 life point of your rival's ship spot");
        System.err.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Destroyer can attack once each turn, and each shoot takes 2 life point of your rival's ship spot");
        System.err.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Aircraft can attack once each turn, and each shoot takes 3 life point of your rival's ship spot\n");
        System.out.println("Press enter");
            keyboard.nextLine();
        drawRivalMap(player1);
        System.out.println("");
        drawOwnMap(player1);
        System.out.println("");
        
        //Player1 is the first attacker
        attackShip(player1, player2);
        checkPlayerLife(player2);
        System.out.println("Turn over, press enter");
        
        keyboard.nextLine();
        for(int i = 0; i < 50; i++)
        {
            System.out.println("-------");
        }
        keyboard.nextLine();
        
        //Then goes player2
        System.out.println(player2.name + " it's your turn");
        System.out.println("You will have to enter the x and y coordinate of your shoots.\n");
        System.out.println("Your shots will appear in your rival map\n");
        System.out.println("H = You have hit a part of a ship");
        System.out.println("X = You shot and there is nothing there");
        System.err.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Patrol boat can attack once each turn, and each shoot takes 1 life point of your rival's ship spot");
        System.err.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Destroyer can attack once each turn, and each shoot takes 2 life point of your rival's ship spot");
        System.err.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Aircraft can attack once each turn, and each shoot takes 3 life point of your rival's ship spot");
        System.out.println("Press enter");
            keyboard.nextLine();
        drawRivalMap(player2);
        System.out.println("");
        drawOwnMap(player2);
        System.out.println("");
        
        attackShip(player2, player1);
        checkPlayerLife(player1);
        System.out.println("Turn over, press enter");
        
        keyboard.nextLine();
        for(int i = 0; i < 50; i++)
        {
            System.out.println("---------");
            System.out.println("Press enter");
            
        }
        keyboard.nextLine();
        
        do
        {
            System.out.println(player1.name + " it's your turn\n");
            drawRivalMap(player1);
            System.out.println("");
            drawOwnMap(player1);
            System.out.println("");
            //Player1 attacks
            attackShip(player1, player2);
            checkPlayerLife(player2);
            System.out.println("Turn over, press enter");
            keyboard.nextLine();
            for(int i = 0; i < 50; i++)
            {
                System.out.println("----------");
                System.out.println("Press enter");
            
            }
            keyboard.nextLine();
            if(player2.defeated == true)
            {
                System.out.println("All ships destroyed. " + player1.name + " wins!");
                break;
            }
            System.out.println(player2.name + " it's your turn\n");
            //Player1 attacks
            drawRivalMap(player2);
            System.out.println("");
            drawOwnMap(player2);
            System.out.println("");
            attackShip(player2, player1);
            checkPlayerLife(player1);
            System.out.println("Turn over, press enter");
            for(int i = 0; i < 50; i++)
            {
                System.out.println("---------");
                System.out.println("Press enter");
            
            }
            keyboard.nextLine();
            if(player1.defeated == true)
            {
                System.out.println("All ships destroyed. " + player2.name + " wins!");
                break;
            }
        }while(player1.defeated == false || player2.defeated == false);
    }
    
    public static void setPatrol(Player player) //Function to set Patrol
    {
         //We declare two variable that indicate if the row or the column are a sequence
        boolean rowSequence;
        boolean columnSequence;
        //We declare a variable to know if there are two positions in the same spot
        boolean sameSpot;
        
        do
        {
            rowSequence = true;
            columnSequence = true;
            sameSpot = false;
            System.out.println("Patrol boat takes 2 spaces on map. It has to be placed horizontaly or vertically, diagonally is not allowed");
            for(int i = 0; i < player.patrol.position.length; i++) //There are two iterations because Patrol class has two positions
            {
                System.out.println("Give me the no." + (i+1) + " x coordinate of your patrol boat");
                int xspot = new Game().validateX(); //Calls the validateX function so you don't have to worry about enters out of range of the map
                System.out.println("Give me the no." + (i+1) + " y coordinate of your patrol boat");
                int yspot = new Game().validateY(); //Calls the validateY function so you don't have to worry about enters out of range of the map
                player.patrol.position[i].x = xspot; //Both x and y values of position array are set
                player.patrol.position[i].y = yspot;

                //player.mapOwn.map[yspot][xspot] = "P";

            }

            //There are five different cases of a boat placed wrong:
            //1. Same row but columns are not a sequence.
            //2. Same column but rows are not a sequence.
            //3. Different column and different row(diagonally).
            //4. Position are in the same coordinates.
            //5. Two parts of the ship are in the same place.

            //To solve this issue we improve a method:

            //First we create two arrays, one with the x values and another with the y values of the positions of the boat
            int[] xarray = new int[player.patrol.position.length];
            int[] yarray = new int[player.patrol.position.length];

            //We fill the arrays
            for(int i = 0; i < player.patrol.position.length; i++)
            {
                xarray[i] = player.patrol.position[i].x;
                yarray[i] = player.patrol.position[i].y;
            }

            //Then we sort both arrays
            Arrays.sort(xarray);
            Arrays.sort(yarray);

            //We declare two variable to know if the positions are in the same row or in the same column
            int sameRow = 0;
            int sameColumn = 0;

            //See the two variables declared at the beggining of function
            
            //1. Same row but columns are not a sequence.
            //We read the array
            for(int i = 0; i < player.patrol.position.length - 1 ; i++)
            {
                //If the positions are in the same row the x values will remain the same and the y values will be defferent,
                //and if we subtract one of the elements of the array of x values from another element it alwayas must be cero.
                sameRow = xarray[i] - xarray[i+1];//So we can say that the positions are in the same row
            }    
            //Now that we know that they are in the same row we have to validate if the y positions are a sequence.
            if(sameRow == 0)
            {
                //We read the yarray backwards because between one element and another there must be a difference of 1
                for(int j = yarray.length - 1; j > 0 ; j--)
                {
                    if((yarray[j] - yarray[j-1]) > 1) //If there is a difference higher than 1 between one and another element then the positions are not a sequence
                    {
                        System.err.println("You cannot split a ship, the positions must be a sequence");
                        columnSequence = false;
                        //drawRivalMap(player);
                        drawOwnMap(player);
                    }
                }
            }
            
            //2. Same column but rows are not a sequence.
            //We read the array
            for(int i = 0; i < player.patrol.position.length - 1 ; i++)
            {
                //If the positions are in the same column the y values will remain the same and the x values will be defferent,
                //and if we subtract one of the elements of the array of y values from another element it alwayas must be cero.
                sameColumn = yarray[i] - yarray[i+1];//So we can say that the positions are in the same column
            }    
                //Now that we know that they are in the same column we have to validate if the x positions are a sequence.
            if(sameColumn == 0)
            {
                //We read the xarray backwards because between one element and another there must be a difference of 1
                for(int j = xarray.length - 1; j > 0 ; j--)
                {
                    if((xarray[j] - xarray[j-1]) > 1) //If there is a difference higher than 1 between one and another element then the positions are not a sequence
                    {
                        System.err.println("You cannot split a ship, the positions must be a sequence");
                        rowSequence = false;
                        //drawRivalMap(player);
                        drawOwnMap(player);
                    }
                }
            }
            
            //3. Different column and different row(diagonally)
            //If there is a difference hlower than 0 in both spots then the positions are diagonally
            if(sameRow <= -1 && sameColumn <= -1)
            {
                System.err.println("Positions are diagonally");
                rowSequence = false;
                //drawRivalMap(player);
                drawOwnMap(player);
            }
            
            //4. Position are in the same coordinates.
            //If the positions are the same then the substraction will be cero
            if(sameRow == 0 && sameColumn == 0)
            {
                System.err.println("You cannot place a ship in the same place");
                rowSequence = false;
                //drawRivalMap(player);
                drawOwnMap(player);
            }
            
            //5. Two parts of the ship are in the same place.
            //We compare each position, x and y and if there are two positions on the same spot it will show an error
            for(int i = 0; i < player.patrol.position.length - 1; i++)
            {
                if(((player.patrol.position[i].x) == (player.patrol.position[i+1].x)) && ((player.patrol.position[i].y) == (player.patrol.position[i+1].y)))
                {
                    System.err.println("You cannot place two parts of a ship in the same place");
                    sameSpot = true;
                    //drawRivalMap(player);
                    drawOwnMap(player);
                }
            }
            
        }while((rowSequence == false) || (columnSequence == false) || (sameSpot == true)); //It will ask the positions of the ship untill the player set it correctly.
        
        
        //After we validate that the positions are set correctly we fill the map of the player
        for(int i = 0; i < player.patrol.position.length; i++)
        {
            player.mapOwn.map[player.patrol.position[i].y][player.patrol.position[i].x] = "P";
        }
        
        //drawRivalMap(player);
        drawOwnMap(player);
    }
    
    public static void setDestroyer(Player player) //Function to set Destroyer
    {
         //We declare two variable that indicate if the row or the column are a sequence
        boolean rowSequence;
        boolean columnSequence;
        
        //We declare a variable to know if there are two positions in the same spot
        boolean sameSpot;
        
        //We declare a variable to know if there ir a ship in the position were you set your ship
        boolean occupiedSpot;
        
        do
        {
            rowSequence = true;
            columnSequence = true;
            sameSpot = false;
            occupiedSpot = false;
            System.out.println("Destroyer takes 3 spaces on map. It has to be placed horizontaly or vertically, diagonally is not allowed");
            for(int i = 0; i < player.destroyer.position.length; i++) //There are two iterations because Patrol class has two positions
            {
                System.out.println("Give me the no." + (i+1) + " x coordinate of your Destroyer");
                int xspot = new Game().validateX(); //Calls the validateX function so you don't have to worry about enters out of range of the map
                System.out.println("Give me the no." + (i+1) + " y coordinate of your Destroyer");
                int yspot = new Game().validateY(); //Calls the validateY function so you don't have to worry about enters out of range of the map
                player.destroyer.position[i].x = xspot; //Both x and y values of position array are set
                player.destroyer.position[i].y = yspot;

                //player.mapOwn.map[yspot][xspot] = "P";

            }

            //There are five different cases of a boat placed wrong:
            //1. Same row but columns are not a sequence.
            //2. Same column but rows are not a sequence.
            //3. Different column and different row(diagonally).
            //4. Position are in the same coordinates.
            //5. Two parts of the ship are in the same place.

            //To solve this issue we improve a method:

            //First we create two arrays, one with the x values and another with the y values of the positions of the boat
            int[] xarray = new int[player.destroyer.position.length];
            int[] yarray = new int[player.destroyer.position.length];

            //We fill the arrays
            for(int i = 0; i < player.destroyer.position.length; i++)
            {
                xarray[i] = player.destroyer.position[i].x;
                yarray[i] = player.destroyer.position[i].y;
            }

            //Then we sort both arrays
            Arrays.sort(xarray);
            Arrays.sort(yarray);

            //We declare two variable to know if the positions are in the same row or in the same column
            int sameRow = 0;
            int sameColumn = 0;

            //See the two variables declared at the beggining of function
            
            //1. Same row but columns are not a sequence.
            //We read the array
            for(int i = 0; i < player.destroyer.position.length - 1 ; i++)
            {
                //If the positions are in the same row the x values will remain the same and the y values will be defferent,
                //and if we subtract one of the elements of the array of x values from another element it alwayas must be cero.
                sameRow = xarray[i] - xarray[i+1];//So we can say that the positions are in the same row
            }    
            //Now that we know that they are in the same row we have to validate if the y positions are a sequence.
            if(sameRow == 0)
            {
                //We read the yarray backwards because between one element and another there must be a difference of 1
                for(int j = yarray.length - 1; j > 0 ; j--)
                {
                    if((yarray[j] - yarray[j-1]) > 1) //If there is a difference higher than 1 between one and another element then the positions are not a sequence
                    {
                        System.err.println("You cannot split a ship, the positions must be a sequence");
                        columnSequence = false;
                        //drawRivalMap(player);
                        drawOwnMap(player);
                    }
                }
            }
            
            //2. Same column but rows are not a sequence.
            //We read the array
            for(int i = 0; i < player.destroyer.position.length - 1 ; i++)
            {
                //If the positions are in the same column the y values will remain the same and the x values will be defferent,
                //and if we subtract one of the elements of the array of y values from another element it alwayas must be cero.
                sameColumn = yarray[i] - yarray[i+1];//So we can say that the positions are in the same column
            }    
                //Now that we know that they are in the same column we have to validate if the x positions are a sequence.
            if(sameColumn == 0)
            {
                //We read the xarray backwards because between one element and another there must be a difference of 1
                for(int j = xarray.length - 1; j > 0 ; j--)
                {
                    if((xarray[j] - xarray[j-1]) > 1) //If there is a difference higher than 1 between one and another element then the positions are not a sequence
                    {
                        System.err.println("You cannot split a ship, the positions must be a sequence");
                        rowSequence = false;
                        //drawRivalMap(player);
                        drawOwnMap(player);
                    }
                }
            }
            
            //3. Different column and different row(diagonally)
            //If there is a difference hlower than 0 in both spots then the positions are diagonally
            if(sameRow <= -1 && sameColumn <= -1)
            {
                System.err.println("Positions are diagonally");
                rowSequence = false;
                //drawRivalMap(player);
                drawOwnMap(player);
            }
            
            //4. Position are in the same coordinates.
            //If the positions are the same then the substraction will be cero
            if(sameRow == 0 && sameColumn == 0)
            {
                System.err.println("You cannot place a ship in the same place");
                rowSequence = false;
                //drawRivalMap(player);
                drawOwnMap(player);
            }
            
            //5. Two parts of the ship are in the same place.
            //We compare each position, x and y and if there are two positions on the same spot it will show an error
            for(int i = 0; i < player.destroyer.position.length - 1; i++)
            {
                if(((player.destroyer.position[i].x) == (player.destroyer.position[i+1].x)) && ((player.destroyer.position[i].y) == (player.destroyer.position[i+1].y)))
                {
                    System.err.println("You cannot two parts of a ship in the same place");
                    sameSpot = true;
                    //drawRivalMap(player);
                    drawOwnMap(player);
                }
            }
            
            //We add another case of ship wrong placed
            //6. If there is a ship on the spot were you want to place the Destroyer
            
            //We compare every position of Destroyer with every position of Patrol to verify the Destroyer does not take an occupied space
            for(int i = 0; i < player.destroyer.position.length; i++)
            {
                for(int j = 0; j < player.patrol.position.length; j++)
                {
                    if((player.destroyer.position[i].x == player.patrol.position[j].x) && (player.destroyer.position[i].y == player.patrol.position[j].y))
                    {
                        //If the x coordinate and the y coordinate are the same then it is an occupied spot and it is not allowed
                        occupiedSpot = true;
                    }
                }
            }
            
            if(occupiedSpot == true)
            {
               System.err.println("There is another ship on the postition");
               //drawRivalMap(player);
               drawOwnMap(player);
            }
            
        }while((rowSequence == false) || (columnSequence == false) || (sameSpot == true) || (occupiedSpot == true)); //It will ask the positions of the ship untill the player set it correctly.
        
        
        //After we validate that the positions are set correctly we fill the map of the player
        for(int i = 0; i < player.destroyer.position.length; i++)
        {
            player.mapOwn.map[player.destroyer.position[i].y][player.destroyer.position[i].x] = "D";
        }
        
        //drawRivalMap(player);
        drawOwnMap(player);
    }
    
    public static void setAircraft(Player player) //Function to set Aircraft
    {
         //We declare two variable that indicate if the row or the column are a sequence
        boolean rowSequence;
        boolean columnSequence;
        
        //We declare a variable to know if there are two positions in the same spot
        boolean sameSpot;
        
        //We declare a variable to know if there ir a ship in the position were you set your ship
        boolean occupiedSpot;
        
        do
        {
            rowSequence = true;
            columnSequence = true;
            sameSpot = false;
            occupiedSpot = false;
            System.out.println("Aircraft takes 5 spaces on map. It has to be placed horizontaly or vertically, diagonally is not allowed");
            for(int i = 0; i < player.aircraft.position.length; i++) //There are two iterations because Patrol class has two positions
            {
                System.out.println("Give me the no." + (i+1) + " x coordinate of your Aircraft");
                int xspot = new Game().validateX(); //Calls the validateX function so you don't have to worry about enters out of range of the map
                System.out.println("Give me the no." + (i+1) + " y coordinate of your Aircraft");
                int yspot = new Game().validateY(); //Calls the validateY function so you don't have to worry about enters out of range of the map
                player.aircraft.position[i].x = xspot; //Both x and y values of position array are set
                player.aircraft.position[i].y = yspot;
                //player.mapOwn.map[yspot][xspot] = "A";

            }

            //There are five different cases of a boat placed wrong:
            //1. Same row but columns are not a sequence.
            //2. Same column but rows are not a sequence.
            //3. Different column and different row(diagonally).
            //4. Position are in the same coordinates.
            //5. Two parts of the ship are in the same place.

            //To solve this issue we improve a method:

            //First we create two arrays, one with the x values and another with the y values of the positions of the boat
            int[] xarray = new int[player.aircraft.position.length];
            int[] yarray = new int[player.aircraft.position.length];

            //We fill the arrays
            for(int i = 0; i < player.aircraft.position.length; i++)
            {
                xarray[i] = player.aircraft.position[i].x;
                yarray[i] = player.aircraft.position[i].y;
            }

            //Then we sort both arrays
            Arrays.sort(xarray);
            Arrays.sort(yarray);

            //We declare two variable to know if the positions are in the same row or in the same column
            int sameRow = 0;
            int sameColumn = 0;

            //See the two variables declared at the beggining of function
            
            //1. Same row but columns are not a sequence.
            //We read the array
            for(int i = 0; i < player.aircraft.position.length - 1 ; i++)
            {
                //If the positions are in the same row the x values will remain the same and the y values will be defferent,
                //and if we subtract one of the elements of the array of x values from another element it alwayas must be cero.
                sameRow = xarray[i] - xarray[i+1];//So we can say that the positions are in the same row
            }    
            //Now that we know that they are in the same row we have to validate if the y positions are a sequence.
            if(sameRow == 0)
            {
                //We read the yarray backwards because between one element and another there must be a difference of 1
                for(int j = yarray.length - 1; j > 0 ; j--)
                {
                    if((yarray[j] - yarray[j-1]) > 1) //If there is a difference higher than 1 between one and another element then the positions are not a sequence
                    {
                        System.err.println("You cannot split a ship, the positions must be a sequence");
                        columnSequence = false;
                        //drawRivalMap(player);
                        drawOwnMap(player);
                    }
                }
            }
            
            //2. Same column but rows are not a sequence.
            //We read the array
            for(int i = 0; i < player.aircraft.position.length - 1 ; i++)
            {
                //If the positions are in the same column the y values will remain the same and the x values will be defferent,
                //and if we subtract one of the elements of the array of y values from another element it alwayas must be cero.
                sameColumn = yarray[i] - yarray[i+1];//So we can say that the positions are in the same column
            }    
                //Now that we know that they are in the same column we have to validate if the x positions are a sequence.
            if(sameColumn == 0)
            {
                //We read the xarray backwards because between one element and another there must be a difference of 1
                for(int j = xarray.length - 1; j > 0 ; j--)
                {
                    if((xarray[j] - xarray[j-1]) > 1) //If there is a difference higher than 1 between one and another element then the positions are not a sequence
                    {
                        System.err.println("You cannot split a ship, the positions must be a sequence");
                        rowSequence = false;
                        //drawRivalMap(player);
                        drawOwnMap(player);
                    }
                }
            }
            
            //3. Different column and different row(diagonally)
            //If there is a difference hlower than 0 in both spots then the positions are diagonally
            if(sameRow <= -1 && sameColumn <= -1)
            {
                System.err.println("Positions are diagonally");
                rowSequence = false;
                //drawRivalMap(player);
                drawOwnMap(player);
            }
            
            //4. Position are in the same coordinates.
            //If the positions are the same then the substraction will be cero
            if(sameRow == 0 && sameColumn == 0)
            {
                System.err.println("You cannot place a ship in the same place");
                rowSequence = false;
                //drawRivalMap(player);
                drawOwnMap(player);
            }
            
            //5. Two parts of the ship are in the same place.
            //We compare each position, x and y and if there are two positions on the same spot it will show an error
            for(int i = 0; i < player.aircraft.position.length - 1; i++)
            {
                if(((player.aircraft.position[i].x) == (player.aircraft.position[i+1].x)) && ((player.aircraft.position[i].y) == (player.aircraft.position[i+1].y)))
                {
                    System.err.println("You cannot two parts of a ship in the same place");
                    sameSpot = true;
                    //drawRivalMap(player);
                    drawOwnMap(player);
                }
            }
            
            //We add another case of ship wrong placed
            //6. If there is a ship on the spot were you want to place the Destroyer
            
            //We compare every position of Aircraft with every position of Patrol to verify the Destroyer does not take an occupied space
            for(int i = 0; i < player.aircraft.position.length; i++)
            {
                for(int j = 0; j < player.patrol.position.length; j++)
                {
                    if((player.aircraft.position[i].x == player.patrol.position[j].x) && (player.aircraft.position[i].y == player.patrol.position[j].y))
                    {
                        //If the x coordinate and the y coordinate are the same then it is an occupied spot and it is not allowed
                        occupiedSpot = true;
                    }
                }
            }
            
            //We compare every position of Aircraft with every position of Destroyer to verify the Destroyer does not take an occupied space
            for(int i = 0; i < player.aircraft.position.length; i++)
            {
                for(int j = 0; j < player.destroyer.position.length; j++)
                {
                    if((player.aircraft.position[i].x == player.destroyer.position[j].x) && (player.aircraft.position[i].y == player.destroyer.position[j].y))
                    {
                        //If the x coordinate and the y coordinate are the same then it is an occupied spot and it is not allowed
                        occupiedSpot = true;
                    }
                }
            }
            
            if(occupiedSpot == true)
            {
               System.err.println("There is another ship on the postition");
               //drawRivalMap(player);
               drawOwnMap(player);
            }
            
        }while((rowSequence == false) || (columnSequence == false) || (sameSpot == true) || (occupiedSpot == true)); //It will ask the positions of the ship untill the player set it correctly.
        
        
        //After we validate that the positions are set correctly we fill the map of the player
        for(int i = 0; i < player.aircraft.position.length; i++)
        {
            player.mapOwn.map[player.aircraft.position[i].y][player.aircraft.position[i].x] = "A";
        }
        
        //drawRivalMap(player);
        drawOwnMap(player);
    }
    
    public int validateX() //Verifies the x cordinate. It cannot be more than 8 or less than 1 because the map is 8x11
    {
        int x = -1;
        Scanner keyboard = new Scanner(System.in);
        do 
        {
            System.out.println("Enter the column");//Recieve the input of user.
            try
            {
                x = keyboard.nextInt() - 1; //Minus 1 because arrays, internally, start in 0, not in 1 as the user enters
            }
            catch(InputMismatchException ime) //If user enters something that is not a number then it will catch an exception
            {
                x = -1;
            }
            if((x < 0) || (x > 7))
            {
                System.out.println("Invalid column");
            }
        }while((x < 0) || (x > 7));//If it is less than 0 or more than 7 it will show an error and will repeat untill the user enters a valid input
        return x;
    }
    
    public int validateY() //Verifies the y cordinate. It cannot be more than 11 or less than 1 because the map is 8x11
    {
        int y = -1;
        do
        {
            Scanner keyboard = new Scanner(System.in); //Recieve the input of user.
            System.out.println("Enter the row");
            try
            {
                y = keyboard.nextInt() - 1; //Minus 1 because arrays, internally, start in 0, not in 1 as the user enters
            }
            catch(InputMismatchException ime) //If user enters something that is not a number then it will catch an exception
            {
                y = -1;
            }
            if((y < 0) || (y > 10)) 
            {
                System.out.println("Invalid row");
            }
        }while((y < 0) || (y > 10));//If it is less than 0 or more than 10 it will show an error and will repeat untill the user enters a valid input
        return y;
    }

    public static void drawOwnMap(Player player) //Function to draw the own map of player sent as argument
    {
        System.err.println("|||||||||||||Own map||||||||||||");
        System.out.println("   1   2   3   4   5   6   7   8");
        System.out.println("   -----------------------------");
        for(int i = 0; i < player.mapOwn.map.length; i++)
        {
            if(i < 9)
            {
                System.out.print((i+1) + "  ");
            }
            else
            {
                System.out.print((i+1) + " ");
            }
            for(int j = 0; j < player.mapOwn.map[i].length; j++)
            {
                System.out.print(player.mapOwn.map[i][j] + "   ");
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    public static void drawRivalMap(Player player) //Function to draw the rival map of player sent as argument
    {
        System.err.println("|||||||||||||Rival map||||||||||");
        System.out.println("   1   2   3   4   5   6   7   8");
        System.out.println("   -----------------------------");
        for(int i = 0; i < player.mapRival.map.length; i++)
        {
            if(i < 9)
            {
                System.out.print((i+1) + "  ");
            }
            else
            {
                System.out.print((i+1) + " ");
            }
            for(int j = 0; j < player.mapRival.map[i].length; j++)
            {
                System.out.print(player.mapRival.map[i][j] + "   ");
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    public static void attackShip(Player attackerPlayer, Player defenderPlayer) //Generic function to make a shot
    {
        //We crate a variable to know if the ship if available
        boolean availableShip;
        
        //We create a variable to know if the ship is out of ammo
        boolean outOfAmmo;
        
        do
        {
            defenderPlayer.defeated = true; //Becomes the player defeated
            availableShip = true;
            outOfAmmo = false;
            //Variable to know what ship to use
            int selectShip;
            Scanner keyboard = new Scanner(System.in);
            do 
            {
                System.out.println("Enter the ship you want yo use");
                System.out.println("1. Patrol boat");
                System.out.println("2. Destroyer");
                System.out.println("3. Aircraft");
                try
                {
                    selectShip = keyboard.nextInt();//Recieve the option selected
                }
                catch(InputMismatchException ime) //If user enters something that is not a number then it will catch an exception
                {
                    selectShip = -1;
                }
                if((selectShip < 0) || (selectShip > 3))
                {
                    System.out.println("Invalid option");
                }
            }while((selectShip < 0) || (selectShip > 3));

            //We create two variables which are going to be the x and y of the shot
            int x;
            int y;

            //Now that we know what ship to use we are going to attack the number of times the ship can attack
            //We created a switch to validate the option selected
            switch (selectShip)
            {
                //The code is the same for every option, the only difference is the damage that the ship make
                case 1:
                    //We validate if the ship is available
                    if(attackerPlayer.patrol.available == true)
                    {
                        System.out.println("Enter the coordinates of your shoot");
                        x = new Game().validateX(); //Validates the x coordinate
                        y = new Game().validateY();
                        //Now that we have the coordinates we start comparing the coordinates with the own map of defenderPlayer
                        //There are 6 possible states of a position
                        //P = There is a part of a Patrol on that position
                        //D = There is a part of a Destroyer on that position
                        //A = There is a part of an Aircraft on that position
                        //H = There is a part of a ship that has been hit
                        //O = There is nothing there
                        //X = You already have fired in that position and there is nothing there

                        //If there is an "O" or an "X" in the position you shot it means that there is nothing there so nothing happens
                        if((defenderPlayer.mapOwn.map[y][x] == "O") || (defenderPlayer.mapOwn.map[y][x] == "X"))
                        {
                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{You have missed the shot!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                            System.out.println("Press enter");
                            keyboard.nextLine();
                            attackerPlayer.mapRival.map[y][x] = "X";
                            defenderPlayer.mapOwn.map[y][x] = "X";
                            drawRivalMap(attackerPlayer);
                            drawOwnMap(attackerPlayer);
                        }

                        //If there is a "P" or a "D" or an "A" or an "H" in the position you shot it means there is something there so it will compare the coordinates entered
                        //with every coordinate of the ships
                        if((defenderPlayer.mapOwn.map[y][x] == "P") || (defenderPlayer.mapOwn.map[y][x] == "D") || (defenderPlayer.mapOwn.map[y][x] == "A") || (defenderPlayer.mapOwn.map[y][x] == "H"))
                        {
                            //We read the positions of Patrol
                            for(int j = 0; j < defenderPlayer.patrol.position.length; j++)
                            {
                                if((defenderPlayer.patrol.position[j].x == x) && (defenderPlayer.patrol.position[j].y == y))
                                {
                                    //If the shot hit a position on patrol it will automatically decrease the position life
                                    defenderPlayer.patrol.position[j].life--;
                                    //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                    attackerPlayer.mapRival.map[y][x] = "H";
                                    defenderPlayer.mapOwn.map[y][x] = "H";
                                    System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                    System.out.println("Press enter");
                                     keyboard.nextLine();
                                        //Also validate if the life of that position is over
                                    if(defenderPlayer.patrol.position[j].life <= 0)
                                    {
                                        //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                        attackerPlayer.mapRival.map[y][x] = "X";
                                        defenderPlayer.mapOwn.map[y][x] = "X";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        System.out.println("Press enter");
                                            keyboard.nextLine();
                                    }
                                }
                            }

                            //Checks if the life of all positions is over and becomes the ship unavailable
                            if(defenderPlayer.patrol.position[0].life <= 0 && defenderPlayer.patrol.position[1].life <= 0)
                            {
                                defenderPlayer.patrol.available = false;
                            }

                            //We read the positions of Destroyer
                            for(int j = 0; j < defenderPlayer.destroyer.position.length; j++)
                            {
                                if((defenderPlayer.destroyer.position[j].x == x) && (defenderPlayer.destroyer.position[j].y == y))
                                {
                                    //If the shot hit a position on Destroyer it will automatically decrease the position life
                                    defenderPlayer.destroyer.position[j].life--;
                                    //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                    attackerPlayer.mapRival.map[y][x] = "H";
                                    defenderPlayer.mapOwn.map[y][x] = "H";
                                    System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                    System.out.println("Press enter");
                                    keyboard.nextLine();
                                    //Also validate if the life of that position is over
                                    if(defenderPlayer.destroyer.position[j].life <= 0)
                                    {
                                        //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                        attackerPlayer.mapRival.map[y][x] = "X";
                                        defenderPlayer.mapOwn.map[y][x] = "X";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        System.out.println("Press enter");
                                            keyboard.nextLine();
                                    }
                                }
                            }

                            //Checks if the life of all positions is over and becomes the ship unavailable
                            if(defenderPlayer.destroyer.position[0].life <= 0 && defenderPlayer.destroyer.position[1].life <= 0 && defenderPlayer.destroyer.position[2].life <= 0)
                            {
                                defenderPlayer.destroyer.available = false;
                            }

                            //We read the positions of Aircraft
                            for(int j = 0; j < defenderPlayer.aircraft.position.length; j++)
                            {
                                if((defenderPlayer.aircraft.position[j].x == x) && (defenderPlayer.aircraft.position[j].y == y))
                                {
                                    //If the shot hit a position on Aircraft it will automatically decrease the position life
                                    defenderPlayer.aircraft.position[j].life--;
                                    //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                    attackerPlayer.mapRival.map[y][x] = "H";
                                    defenderPlayer.mapOwn.map[y][x] = "H";
                                    System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                    System.out.println("Press enter");
                                        keyboard.nextLine();
                                            //Also validate if the life of that position is over
                                    if(defenderPlayer.aircraft.position[j].life <= 0)
                                    {
                                        //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                        attackerPlayer.mapRival.map[y][x] = "X";
                                        defenderPlayer.mapOwn.map[y][x] = "X";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        System.out.println("Press enter");
                                        keyboard.nextLine();
                                    }
                                }
                            }

                            //Checks if the life of all positions is over and becomes the ship unavailable
                            if(defenderPlayer.aircraft.position[0].life <= 0 && defenderPlayer.aircraft.position[1].life <= 0 && defenderPlayer.aircraft.position[2].life <= 0 && defenderPlayer.aircraft.position[3].life <= 0 && defenderPlayer.aircraft.position[4].life <= 0)
                            {
                                defenderPlayer.aircraft.available = false;
                            }
                            drawRivalMap(attackerPlayer);
                            drawOwnMap(attackerPlayer);
                        }
                        attackerPlayer.destroyer.ammo++;
                        attackerPlayer.aircraft.ammo++;    
                    }
                    else
                    {
                        System.out.println("Ship unavailable");
                        System.err.println("oooooooooooooooooooooooooo Your patrol has been destroyer ooooooooooooooooooooooooooooooo");
                        if(attackerPlayer.aircraft.ammo < 3 && attackerPlayer.destroyer.ammo < 2){
                        
                            attackerPlayer.destroyer.ammo++;
                            attackerPlayer.aircraft.ammo++;
                            break;
                        }
                        
                        availableShip = false;
                    }
                break;
                case 2:
                    //We validate if the ship is available
                    if(attackerPlayer.destroyer.available == true)
                    {
                        if(attackerPlayer.destroyer.ammo > 1)
                        {
                            System.out.println("Enter the coordinates of your shoot");
                            x = new Game().validateX(); //Validates the x coordinate
                            y = new Game().validateY();
                            //Now that we have the coordinates we start comparing the coordinates with the own map of defenderPlayer
                            //There are 6 possible states of a position
                            //P = There is a part of a Patrol on that position
                            //D = There is a part of a Destroyer on that position
                            //A = There is a part of an Aircraft on that position
                            //H = There is a part of a ship that has been hit
                            //O = There is nothing there
                            //X = You already have fired in that position and there is nothing there

                            //If there is an "O" or an "X" in the position you shot it means that there is nothing there so nothing happens
                            if((defenderPlayer.mapOwn.map[y][x] == "O") || (defenderPlayer.mapOwn.map[y][x] == "X"))
                            {
                                System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{You have missed the shot!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                System.out.println("Press enter");
                                keyboard.nextLine();
                                attackerPlayer.mapRival.map[y][x] = "X";
                                defenderPlayer.mapOwn.map[y][x] = "X";
                                drawRivalMap(attackerPlayer);
                                drawOwnMap(attackerPlayer);
                            }

                            //If there is a "P" or a "D" or an "A" or an "H" in the position you shot it means there is something there so it will compare the coordinates entered
                            //with every coordinate of the ships
                            if((defenderPlayer.mapOwn.map[y][x] == "P") || (defenderPlayer.mapOwn.map[y][x] == "D") || (defenderPlayer.mapOwn.map[y][x] == "A") || (defenderPlayer.mapOwn.map[y][x] == "H"))
                            {
                                //We read the positions of Patrol
                                for(int j = 0; j < defenderPlayer.patrol.position.length; j++)
                                {
                                    if((defenderPlayer.patrol.position[j].x == x) && (defenderPlayer.patrol.position[j].y == y))
                                    {
                                        //If the shot hit a position on patrol it will automatically decrease the position life by 2
                                        defenderPlayer.patrol.position[j].life -= 2;
                                        //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                        attackerPlayer.mapRival.map[y][x] = "H";
                                        defenderPlayer.mapOwn.map[y][x] = "H";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                            System.out.println("Press enter");
                                        keyboard.nextLine();
                                            //Also validate if the life of that position is over
                                        if(defenderPlayer.patrol.position[j].life <= 0)
                                        {
                                            //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                            attackerPlayer.mapRival.map[y][x] = "X";
                                            defenderPlayer.mapOwn.map[y][x] = "X";
                                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        }
                                    }
                                }

                                //Checks if the life of all positions is over and becomes the ship unavailable
                                if(defenderPlayer.patrol.position[0].life <= 0 && defenderPlayer.patrol.position[1].life <= 0)
                                {
                                    defenderPlayer.patrol.available = false;
                                }

                                //We read the positions of Destroyer
                                for(int j = 0; j < defenderPlayer.destroyer.position.length; j++)
                                {
                                    if((defenderPlayer.destroyer.position[j].x == x) && (defenderPlayer.destroyer.position[j].y == y))
                                    {
                                        //If the shot hit a position on Destroyer it will automatically decrease the position life
                                        defenderPlayer.destroyer.position[j].life -= 2;
                                        //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                        attackerPlayer.mapRival.map[y][x] = "H";
                                        defenderPlayer.mapOwn.map[y][x] = "H";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        //Also validate if the life of that position is over
                                        if(defenderPlayer.destroyer.position[j].life <= 0)
                                        {
                                            //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                            attackerPlayer.mapRival.map[y][x] = "X";
                                            defenderPlayer.mapOwn.map[y][x] = "X";
                                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        }
                                    }
                                }

                                //Checks if the life of all positions is over and becomes the ship unavailable
                                if(defenderPlayer.destroyer.position[0].life <= 0 && defenderPlayer.destroyer.position[1].life <= 0 && defenderPlayer.destroyer.position[2].life <= 0)
                                {
                                    defenderPlayer.destroyer.available = false;
                                }

                                //We read the positions of Aircraft
                                for(int j = 0; j < defenderPlayer.aircraft.position.length; j++)
                                {
                                    if((defenderPlayer.aircraft.position[j].x == x) && (defenderPlayer.aircraft.position[j].y == y))
                                    {
                                        //If the shot hit a position on Aircraft it will automatically decrease the position life
                                        defenderPlayer.aircraft.position[j].life -= 2;
                                        //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                        attackerPlayer.mapRival.map[y][x] = "H";
                                        defenderPlayer.mapOwn.map[y][x] = "H";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        //Also validate if the life of that position is over
                                        if(defenderPlayer.aircraft.position[j].life <= 0)
                                        {
                                            //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                            attackerPlayer.mapRival.map[y][x] = "X";
                                            defenderPlayer.mapOwn.map[y][x] = "X";
                                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        }
                                    }
                                }

                                //Checks if the life of all positions is over and becomes the ship unavailable
                                if(defenderPlayer.aircraft.position[0].life <= 0 && defenderPlayer.aircraft.position[1].life <= 0 && defenderPlayer.aircraft.position[2].life <= 0 && defenderPlayer.aircraft.position[3].life <= 0 && defenderPlayer.aircraft.position[4].life <= 0)
                                {
                                    defenderPlayer.aircraft.available = false;
                                }
                                drawRivalMap(attackerPlayer);
                                drawOwnMap(attackerPlayer);
                            }
                            attackerPlayer.destroyer.ammo = 0;
                            attackerPlayer.aircraft.ammo++;
                        }
                        else
                        {
                            System.out.println("Ship out of ammo");
                            outOfAmmo = true;
                        }
                    }
                    else
                    {
                        System.out.println("Ship unavailable");
                        availableShip = false;
                    }
                break;
                case 3:
                    //We validate if the ship is available
                    if(attackerPlayer.aircraft.available == true)
                    {
                        //Checks if the ship is out of ammo
                        if(attackerPlayer.aircraft.ammo > 2)
                        {
                            System.out.println("Enter the coordinates of your shoot");
                            x = new Game().validateX(); //Validates the x coordinate
                            y = new Game().validateY();
                            //Now that we have the coordinates we start comparing the coordinates with the own map of defenderPlayer
                            //There are 6 possible states of a position
                            //P = There is a part of a Patrol on that position
                            //D = There is a part of a Destroyer on that position
                            //A = There is a part of an Aircraft on that position
                            //H = There is a part of a ship that has been hit
                            //O = There is nothing there
                            //X = You already have fired in that position and there is nothing there

                            //If there is an "O" or an "X" in the position you shot it means that there is nothing there so nothing happens
                            if((defenderPlayer.mapOwn.map[y][x] == "O") || (defenderPlayer.mapOwn.map[y][x] == "X"))
                            {
                                System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{You have missed the shot!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                attackerPlayer.mapRival.map[y][x] = "X";
                                defenderPlayer.mapOwn.map[y][x] = "X";
                                drawRivalMap(attackerPlayer);
                                drawOwnMap(attackerPlayer);
                            }

                            //If there is a "P" or a "D" or an "A" or an "H" in the position you shot it means there is something there so it will compare the coordinates entered
                            //with every coordinate of the ships
                            if((defenderPlayer.mapOwn.map[y][x] == "P") || (defenderPlayer.mapOwn.map[y][x] == "D") || (defenderPlayer.mapOwn.map[y][x] == "A") || (defenderPlayer.mapOwn.map[y][x] == "H"))
                            {
                                //We read the positions of Patrol
                                for(int j = 0; j < defenderPlayer.patrol.position.length; j++)
                                {
                                    if((defenderPlayer.patrol.position[j].x == x) && (defenderPlayer.patrol.position[j].y == y))
                                    {
                                        //If the shot hit a position on patrol it will automatically decrease the position life
                                        defenderPlayer.patrol.position[j].life -= 3;
                                        //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                        attackerPlayer.mapRival.map[y][x] = "H";
                                        defenderPlayer.mapOwn.map[y][x] = "H";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        //Also validate if the life of that position is over
                                        if(defenderPlayer.patrol.position[j].life <= 0)
                                        {
                                            //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                            attackerPlayer.mapRival.map[y][x] = "X";
                                            defenderPlayer.mapOwn.map[y][x] = "X";
                                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        }
                                    }
                                }
                                
                                //Checks if the life of all positions is over and becomes the ship unavailable
                                if(defenderPlayer.patrol.position[0].life <= 0 && defenderPlayer.patrol.position[1].life <= 0)
                                {
                                    defenderPlayer.patrol.available = false;
                                }
                                
                                //We read the positions of Destroyer
                                for(int j = 0; j < defenderPlayer.destroyer.position.length; j++)
                                {
                                    if((defenderPlayer.destroyer.position[j].x == x) && (defenderPlayer.destroyer.position[j].y == y))
                                    {
                                        //If the shot hit a position on Destroyer it will automatically decrease the position life
                                        defenderPlayer.destroyer.position[j].life -= 3;
                                        //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                        attackerPlayer.mapRival.map[y][x] = "H";
                                        defenderPlayer.mapOwn.map[y][x] = "H";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        //Also validate if the life of that position is over
                                        if(defenderPlayer.destroyer.position[j].life <= 0)
                                        {
                                            //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                            attackerPlayer.mapRival.map[y][x] = "X";
                                            defenderPlayer.mapOwn.map[y][x] = "X";
                                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        }
                                    }
                                }
                                
                                //Checks if the life of all positions is over and becomes the ship unavailable
                                if(defenderPlayer.destroyer.position[0].life <= 0 && defenderPlayer.destroyer.position[1].life <= 0 && defenderPlayer.destroyer.position[2].life <= 0)
                                {
                                    defenderPlayer.destroyer.available = false;
                                }
                                
                                //We read the positions of Aircraft
                                for(int j = 0; j < defenderPlayer.aircraft.position.length; j++)
                                {
                                    if((defenderPlayer.aircraft.position[j].x == x) && (defenderPlayer.aircraft.position[j].y == y))
                                    {
                                        //If the shot hit a position on Aircraft it will automatically decrease the position life
                                        defenderPlayer.aircraft.position[j].life -= 3;
                                        //and it will change the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "H"
                                        attackerPlayer.mapRival.map[y][x] = "H";
                                        defenderPlayer.mapOwn.map[y][x] = "H";
                                        System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{Partial damage on an enemy ship!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        //Also validate if the life of that position is over
                                        if(defenderPlayer.aircraft.position[j].life <= 0)
                                        {
                                            //If it is over then changes the positions both in mapRival of attackerPlayer and in mapOwn of defenderPlayer to an "X"
                                            attackerPlayer.mapRival.map[y][x] = "X";
                                            defenderPlayer.mapOwn.map[y][x] = "X";
                                            System.err.println("\n{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{POSITION DESTROYED!}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}\n");
                                        }
                                    }
                                }
                                
                                //Checks if the life of all positions is over and becomes the ship unavailable
                                if(defenderPlayer.aircraft.position[0].life <= 0 && defenderPlayer.aircraft.position[1].life <= 0 && defenderPlayer.aircraft.position[2].life <= 0 && defenderPlayer.aircraft.position[3].life <= 0 && defenderPlayer.aircraft.position[4].life <= 0)
                                {
                                    defenderPlayer.aircraft.available = false;
                                }
                                drawRivalMap(attackerPlayer);
                                drawOwnMap(attackerPlayer);
                            }
                            attackerPlayer.aircraft.ammo = 0;
                            attackerPlayer.destroyer.ammo++;
                        }
                        else
                        {
                            System.err.println("<<<<<<<<<<<<<<Ship out of ammo, wait until your ship reload the canon>>>>>>>>>>>>>>>");
                            outOfAmmo = true;
                        }
                    }
                    else
                    {
                        System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Ship unavailable>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        availableShip = false;
                    }
                break;
            }
        }while(availableShip == false || outOfAmmo == true); //Repeats untill an available ship is selected
        
    }
    
    public static void checkPlayerLife(Player player) //Function to check if player is still alive
    {
        //When you recieve an attack it becomes you defeated but if there is at least 1 position alive you remain in the game
        
        //Check all positions of Patrol boat
        for(int i = 0; i < player.patrol.position.length; i++)
        {
            if(player.patrol.position[i].life > 0)
            {
                player.defeated = false;
            }
        }
        
        //Check all positions of Destroyer
        for(int i = 0; i < player.destroyer.position.length; i++)
        {
            if(player.destroyer.position[i].life > 0)
            {
                player.defeated = false;
            }
        }
        
        //Check all positions of Aircraft
        for(int i = 0; i < player.aircraft.position.length; i++)
        {
            if(player.aircraft.position[i].life > 0)
            {
                player.defeated = false;
            }
        }
    }
}
