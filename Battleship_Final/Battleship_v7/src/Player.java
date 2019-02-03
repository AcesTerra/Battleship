/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */
public class Player {
    //Every player has two maps: 
    Map mapOwn = new Map(); //One with their ships called mapOwn
    Map mapRival = new Map(); //And another with their shots and hits called map Rival
    String name = new String(); //Every player has a name
    //Every player has a Patrol boat, a Destroyer and an Aircraft
    Patrol patrol = new Patrol();
    Destroyer destroyer = new Destroyer();
    Aircraft aircraft = new Aircraft();
    //Every player has a boolean to know if it is defeated or not
    boolean defeated = true;
    
    public Player(String name, int count)
    {
        setName(name, count);
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name, int count) {
        if(name != null && !name.isEmpty())
        {
            this.name = name;
        }
        else
        {
            System.out.println("Default name: Player" + count);
            name = "Player " + count;
        }
        this.name = name;
    }
    
    
}
