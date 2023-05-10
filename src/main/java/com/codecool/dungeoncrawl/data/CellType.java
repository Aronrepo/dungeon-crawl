package com.codecool.dungeoncrawl.data;

import com.sun.prism.impl.ps.CachingRoundRectRep;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    LAVA("lava"),
    TREE("tree"),
    CASTLE("castle"),
    MUD("mud"),
    GROUND("ground");
    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
