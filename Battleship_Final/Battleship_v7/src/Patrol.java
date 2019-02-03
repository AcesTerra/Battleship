/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */
public class Patrol {
    Position[] position = new Position[]{new Position(1), new Position(1)}; //The Patrol boat has two positions with values in x and y respectively. They also have 1 life each
    int attack = 1; //It can attack once each turn
    boolean available = true; //At the beginning all ships are availables
}
