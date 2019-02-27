package com.alb.mariobros.Pantallas;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

public class PantallaMenuPrincipal implements Screen {

    Stage stage;
    @Override
    public void show() {
        if(!VisUI.isLoaded())
            VisUI.load();

        stage=new Stage();
        VisTable tabla=new VisTable();
        tabla.setFillParent(true);
        stage.addActor(tabla);

        VisTextButton btJugar=new VisTextButton("Jugar");
        btJugar.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y){
                ((Game) Gdx.app.getApplicationListener()).setScreen(new PantallaJuego());
            }
        });

        VisTextButton btSalir=new VisTextButton("Salir");
        btSalir.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                dispose();
                System.exit(0);
            }
        }
        );

        VisLabel titulo=new VisLabel("GotaBros v0.1");
        tabla.row();
        tabla.add(btJugar).center().width(200).height(50).pad(5);
        tabla.row();
        tabla.add(btSalir).center().width(200).height(50).pad(5);
        tabla.row();
        tabla.add(titulo).center().width(200).height(100).pad(5);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float dt) {
       Gdx.gl.glClearColor(1f,0.9f,0.9f,1f);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

       stage.act(dt);
       stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
