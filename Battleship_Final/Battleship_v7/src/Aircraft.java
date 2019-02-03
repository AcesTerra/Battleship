/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */
public class Aircraft {
    Position[] position = new Position[]{new Position(4), new Position(4), new Position(4), new Position(4), new Position(4)}; //The Destroyer has five positions with values in x and y respectively. They also have 3 lifes each
    int attack = 3; //It can attack three times each turn
    boolean available = true; //At the beginning all ships are availables
    int ammo = 3; //A variable to validate the turns that it has to wait untill the ammo is full
}
