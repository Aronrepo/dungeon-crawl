package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.enemy.Farquad;
import com.codecool.dungeoncrawl.data.actors.enemy.Skeleton;
import com.codecool.dungeoncrawl.data.actors.friend.Donkey;
import com.codecool.dungeoncrawl.data.actors.friend.Dragon;
import com.codecool.dungeoncrawl.data.actors.friend.Fiona;
import com.codecool.dungeoncrawl.data.actors.friend.PussInBoots;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(DayPeriod dayPeriod) {
        InputStream is = MapLoader.class.getResourceAsStream("/oldMap.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.setSkeleton(new Skeleton(cell,dayPeriod));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell, dayPeriod));
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new PussInBoots(cell, dayPeriod);
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            new Donkey(cell, dayPeriod);
                            break;
                        case 'D' :
                            cell.setType(CellType.GROUND);
                            new Dragon(cell, dayPeriod);
                            break;
                        case 'F' :
                            cell.setType(CellType.FLOOR);
                            map.setFarquad(new Farquad(cell, dayPeriod));
                            break;
                        case 'f' :
                            cell.setType(CellType.FLOOR);
                            new Fiona(cell, dayPeriod);
                            break;
                        case 'l' :
                            cell.setType(CellType.LAVA);
                            break;
                        case 't' :
                            cell.setType(CellType.TREE);
                            break;
                        case 'c':
                            cell.setType(CellType.CASTLE);
                            break;
                        case 'm':
                            cell.setType(CellType.MUD);
                            break;
                        case 'g':
                            cell.setType(CellType.GROUND);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
