package com.alb.mariobros.caracteres;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Gota extends Caracter{

    public final int VELOCIDAD_INICIAL=5;
    public static final int ANCHURA=64;
    public enum Tipo{
        NORMAL,MUNICION
    }

    public Tipo tipo;

    public Gota(Texture imagen, int posicionX) {
        super(imagen);

        posicion.y= Gdx.graphics.getHeight();
        posicion.x=posicionX;
        tipo=Tipo.NORMAL;
        velocidad=new Vector2(0,-VELOCIDAD_INICIAL);
    }
    public Gota(Texture imagen,boolean municion ,int posicionX){
        super(imagen);
        posicion.y= Gdx.graphics.getHeight();
        velocidad=new Vector2(0,-VELOCIDAD_INICIAL);
        posicion.x=posicionX;
        if(municion)
            tipo=Tipo.MUNICION;
        else
            tipo=Tipo.NORMAL;
    }
    public void caer(){
       mover();
    }
}
