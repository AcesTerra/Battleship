/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo and Hugo
 */
public class Position {
    int x;
    int y;
    int life;
    
    public Position(int life)
    {
        setX(x);
        setY(y);
        setLife(life);
    }

    public int getX() {
        return x;
    }
 
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
}
