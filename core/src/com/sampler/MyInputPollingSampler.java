package com.sampler;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyInputPollingSampler implements ApplicationListener {
    public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    public void draw() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        font.draw(batch, "mouseX = " + mouseX + " mouse Y = " + mouseY, 20f, 720 - 20f);

        boolean pressedLeft = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean pressedRight = Gdx.input.isKeyPressed(Input.Keys.RIGHT);


        font.draw(batch,
                pressedLeft ? "Left is pressed" : "Left is not pressed",
                20f,
                720 - 50f);

        font.draw(batch,
                pressedRight ? "Right is pressed" : "Right is not pressed",
                20f,
                720 - 80f);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
