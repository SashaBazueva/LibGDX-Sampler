package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyInputHandlingSampler implements ApplicationListener, InputProcessor {

    private static final Logger logger = new Logger(MyInputHandlingSampler.class.getName(), Logger.DEBUG);

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    private static final byte MAX_MESSAGE_COUNT = 15;
    private final Array<String> messages = new Array<>(MAX_MESSAGE_COUNT);

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.input.setInputProcessor(this);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("oswald-32.fnt"));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    public void draw() {
        for (int i = 0; i < messages.size; i++) {
            font.draw(batch, messages.get(i), 20f, 720 - 40f * (i + 1));
        }
    }

    private void addMessage(String message) {
        messages.add(message);

        if (messages.size == MAX_MESSAGE_COUNT) {
            messages.removeIndex(0);
        }
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

    @Override
    public boolean keyDown(int keycode) {
        String message = "keyDown keycode=" + keycode;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        String message = "keyUp keycode=" + keycode;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        String message = "keyTyped character=" + character;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        String message = "touchDown screenX=" + screenX + " screenY= " + screenY;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        String message = "touchUp screenX=" + screenX + " screenY= " + screenY;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        String message = "touchDragged screenX=" + screenX + " screenY= " + screenY;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        String message = "mouseMoved screenX=" + screenX + " screenY= " + screenY;
        addMessage(message);
        logger.debug(message);
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        String message = "scrolled amountX=" + amountX + " amountY= " + amountY;
        addMessage(message);
        logger.debug(message);
        return true;
    }
}
