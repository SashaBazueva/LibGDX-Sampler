package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;

public class MySamplerForLookingLifecycle implements ApplicationListener {

    private static final Logger logger = new Logger(MySamplerForLookingLifecycle.class.getName(), Logger.DEBUG);
    private boolean renderInterrupter = true;

    @Override
    public void create() {
        //used to initialize and load resources
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        logger.debug("create()");
    }

    @Override
    public void resize(int width, int height) {
        //called after create(), used to setting size of window
        logger.debug("resize() with width " + width + " | height" + height);
    }

    @Override
    public void render() {
        //called 60 times per second, used to update and render game elements
        if (renderInterrupter) {
            logger.debug("render()");
            renderInterrupter = false;
        }
    }

    @Override
    public void pause() {
        //used to save game state, when application lose the focus
        logger.debug("pause()");
        renderInterrupter = true;
    }

    @Override
    public void resume() {
        //used to activate game state after pause()
        logger.debug("resume()");
        renderInterrupter = true;
    }

    @Override
    public void dispose() {
        //called when application is closing, used to free resources from memories and cleanup
        logger.debug("dispose()");
    }
}
