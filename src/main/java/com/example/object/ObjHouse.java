//OBJ house extends superobject and initalize house object
package com.example.object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjHouse extends SuperObject {
    // constructor
    public ObjHouse() {
        name = "House";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/house/dog_house.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
