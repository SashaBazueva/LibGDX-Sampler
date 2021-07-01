package com.sampler.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sampler.MySampler;
import com.sampler.MySamplerForLookingLifecycle;

public class DesktopLauncherListener {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MySamplerForLookingLifecycle(), config);
	}
}
