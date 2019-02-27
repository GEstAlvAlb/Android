package com.alb.mariobros.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.File;

public class R {
    public static AssetManager assets=new AssetManager();

    public static void cargarRecursos(){
        assets.load("gotabros.atlas", TextureAtlas.class);
        assets.load("sounds"+ File.separator+"waterdrop.wav",Sound.class);
        assets.load("sounds"+File.separator+"undertreeinrain.mp3",Music.class);

    }

    public static TextureRegion getRegion(String nombre){
        return assets.get("gotabros.atlas",TextureAtlas.class).findRegion(nombre);
    }

    public static Sound getSonido(String nombre){
        return assets.get(nombre,Sound.class);
    }
    public static Music getMusica(String nombre){
        return assets.get(nombre,Music.class);
    }

}
