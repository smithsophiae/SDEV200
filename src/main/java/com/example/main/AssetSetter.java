//AssetSetter places the House object on the map
package com.example.main;

import com.example.object.ObjHouse;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;

    }

    public void setObject() {
        // placing obj

        // House, end goal
        gp.obj[0] = new ObjHouse();
        gp.obj[0].x = 14 * gp.tileSize;
        gp.obj[0].y = gp.tileSize;

    }
}
