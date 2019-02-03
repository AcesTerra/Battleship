/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */
public class Destroyer {
    Position[] position = new Position[]{new Position(2), new Position(2), new Position(2)}; //The Destroyer has three positions with values in x and y respectively. They also have 2 lifes each
    int attack = 2; //It can attack twice each turn
    boolean available = true; //At the beginning all ships are availables
    int ammo = 2; //A variable to validate the turns that it has to wait untill the ammo is full
}
