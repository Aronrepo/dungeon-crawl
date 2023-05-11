package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.enemy.Farquad;
import com.codecool.dungeoncrawl.data.actors.enemy.Skeleton;

import java.util.ArrayList;
import java.util.List;

import com.codecool.dungeoncrawl.data.actors.friend.Dragon;
import com.codecool.dungeoncrawl.data.actors.friend.Fiona;
import com.codecool.dungeoncrawl.data.items.Fire;


public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private Player player;
    private final List<Skeleton> skeletons = new ArrayList<>();
    private Farquad farquad;
    private Dragon dragon;
    private Fiona fiona;


    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setFiona(Fiona fiona) {
        this.fiona = fiona;
    }

    public Fiona getFiona() {
        return fiona;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Farquad getFarquad() {
        return farquad;
    }

    public void setFarquad(Farquad farquad) {
        this.farquad = farquad;
    }

    public void moveSKeletons() {
        for (Skeleton skeleton : skeletons) {
            skeleton.move();
        }
    }

    public void setSkeleton(Skeleton skeleton) {
        skeletons.add(skeleton);
    }


    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public Dragon getDragon() {
        return dragon;
    }

}
