package com.alb.mariobros.Pantallas;


import com.alb.mariobros.caracteres.Cubo;
import com.alb.mariobros.caracteres.Gota;
import com.alb.mariobros.caracteres.Nube;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

public class PantallaJuego implements Screen {
    SpriteBatch batch;
    Cubo cubo;
    Nube nube;
    Array<Gota> gotas;
    final float RITMO_GOTAS=0.1f;
    long tiempoUlGota=0;
    long ritmoGotas=1000;
    boolean pausea=false;


    @Override
    public void show() {
        batch = new SpriteBatch();
        cubo=new Cubo(new Texture("sprites/bucket.png"));
        //img = new Texture("sprites/bucket.png"); //las imagenes estan en assets sprites la musica esta en sounds
        gotas=new Array<Gota>();
        Music musica= Gdx.audio.newMusic(new FileHandle("sounds/undertreeinrain.mp3"));
        musica.play();

        tiempoUlGota= TimeUtils.millis(); //a mano
        //generarJuvia(); con timer
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.P))
            pausea=true;

        if(!pausea) {
            comprobarBordes();
            comprobarTeclado();
            generarJuvia();


            for (Gota gota : gotas) {
                gota.caer();
                if (gota.posicion.y + gota.tamano.y < 0) {
                    gotas.removeValue(gota, true);
                }
                //la gota desaparece al chocar
                if (gota.rect.overlaps(cubo.rect)) {
                    gotas.removeValue(gota, true);
                    Sound sound = Gdx.audio.newSound(new FileHandle("sounds/waterdrop.wav"));
                    sound.play();

                }

            }
            if(nube!=null) {
                nube.mover();
                if(nube.posicion.y>Gdx.graphics.getHeight()) nube=null;

            }

        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




        batch.begin();
        cubo.pintar(batch);
        for(Gota gota:gotas)
            gota.pintar(batch);
        if(nube !=null)
            nube.pintar(batch);

        batch.end();



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
        batch.dispose();
        cubo.dispose();
    }
    public void comprobarTeclado(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            cubo.mover(cubo.velocidad);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){

            cubo.mover( new Vector2(-10,0));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            if(nube==null)
                nube=cubo.disparar();

        }

    }
    private void comprobarBordes(){

        if(cubo.posicion.x<0)
            cubo.posicion.x=0;

        if((cubo.posicion.x+cubo.tamano.x)>Gdx.graphics.getWidth())
            cubo.posicion.x=Gdx.graphics.getWidth()-cubo.tamano.x;
    }


    private void generarJuvia(){
        if((TimeUtils.timeSinceMillis(tiempoUlGota))>ritmoGotas){

            int posicionY = MathUtils.random(0, Gdx.graphics.getWidth() - Gota.ANCHURA);
            Gota gota = new Gota(new Texture("sprites/droplet.png"), posicionY);
            gotas.add(gota);
            tiempoUlGota=TimeUtils.millis();
            ritmoGotas=ritmoGotas-10;
        }

    }

    private void generarJuviaConTimer(){
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                int posicionY= MathUtils.random(0,Gdx.graphics.getWidth()-Gota.ANCHURA);
                Gota gota=new Gota(new Texture("sprites/droplet.png"),posicionY);
                gotas.add(gota);
            }
        },0,RITMO_GOTAS);

    }
}
