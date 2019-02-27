package com.alb.mariobros.caracteres;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Cubo extends Caracter {

    public final int VELOCIDAD_INCIAL=10;
    public int vidas;
    public int municion;


    public Cubo(Texture imagen) {
        super(imagen);
        vidas=3;
        municion=0;
        velocidad=new Vector2(VELOCIDAD_INCIAL,0);
    }
    public Nube disparar(){
        Nube nube=new Nube(new Texture("sprites/enemy_blue_dead.png"));
        nube.posicion.x=posicion.x+(tamano.x/2)-nube.tamano.x/2;
        nube.posicion.y=posicion.y+tamano.y;
        return nube;
    }
}
