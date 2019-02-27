package com.alb.mariobros.caracteres;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Nube extends Caracter {
    public Nube(Texture imagen) {
        super(imagen);
        velocidad=new Vector2(0,10);
    }
}
