package jy16.androidintent;

import java.io.Serializable;

/**
 * Created by Vermoths on 2017/10/12.
 */

public class ItemInfo implements Serializable {
    private String name;
    private int attack;
    private int life;
    private int speed;

    public ItemInfo(String name, int attack, int life, int speed) {
        this.name = name;
        this.attack = attack;
        this.life = life;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
