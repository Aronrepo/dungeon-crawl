package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tilesetDay = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Image tilesetNight = new Image("/tiles-night.png", 542 * 2, 542 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        // i : to the right from 1
        // j : down from 0
        tileMap.put("empty", new Tile(6, 0));
        tileMap.put("wall", new Tile(3, 2));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(20, 9));
        tileMap.put("pussInBoots", new Tile(30,7));
        tileMap.put("donkey", new Tile(28,7));
        tileMap.put("dragon", new Tile(26, 8));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("farquad", new Tile(26, 9));
        tileMap.put("fiona", new Tile(29, 3));
        tileMap.put("lava", new Tile(12,18));
        tileMap.put("tree", new Tile(4,1));
        tileMap.put("castle", new Tile(7,19));
        tileMap.put("mud", new Tile(5,0));
        tileMap.put("ground", new Tile(0,0));
        tileMap.put("sword", new Tile(0, 30));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y, DayPeriod dayPeriod) {
        Tile tile = tileMap.get(d.getTileName());
        if (dayPeriod == DayPeriod.DAY) {
            context.drawImage(tilesetDay, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
        }
        else {
            context.drawImage(tilesetNight, tile.x, tile.y, tile.w, tile.h,
                    x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
        }
    }
}
