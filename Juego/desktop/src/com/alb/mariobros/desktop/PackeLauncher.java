package com.alb.mariobros.desktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class PackeLauncher {
    public static void main(String args[]){
        TexturePacker.Settings settings=new TexturePacker.Settings();
        settings.maxWidth=1024;
        settings.maxHeight=1024;
        settings.filterMag= Texture.TextureFilter.Linear;
        settings.filterMin= Texture.TextureFilter.Linear;

        TexturePacker.process("android/assets/sprites","android/assets","gotabros");
    }
}
