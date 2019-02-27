package com.alb.mariobros.caracteres;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Roca extends Caracter{

    public final int VELOCIDAD_INICIAL=5;
    public enum Tipo{
        GRANDE,MEDIANA,PEQUEÑA
    }

    public Tipo tipo;
    public int vidas;

    public Roca(Texture imagen) {
        super(imagen);
        tipo=Tipo.PEQUEÑA;
        vidas=1;
        velocidad=new Vector2(0,-VELOCIDAD_INICIAL);
    }

    public Roca(Texture imagen, Tipo tipo){
        super(imagen);
        velocidad=new Vector2(0,-VELOCIDAD_INICIAL);
        this.tipo=tipo;
        switch (tipo){
            case GRANDE:
                vidas=3;
                break;
            case MEDIANA:
                vidas=2;
                break;
            case PEQUEÑA:
                vidas=1;
                break;

        }
    }
}
