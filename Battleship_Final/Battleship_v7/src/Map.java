/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */
public class Map {
    String map[][] = new String[11][8]; //We create a bidimensional map to make things easier
    //Unlike the common graphs X and Y where we first indicate the x and then the y it is the opposite, first the y and then the x.
    //It is because when you fill or read the array with two for cycles you get first all the elements of the second dimension, then
    //coordinates switch. So when you see in the code that there is a modification in any map it will specify the y first and then the x.
    
    public Map()
    {
        setMap(map);
    }

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        //Construct the map and fills it with "O"
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                map[i][j] = ".";
            }
        }
        this.map = map;
    }

    
    
}
