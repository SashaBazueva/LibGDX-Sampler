package com.sampler.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ApplicationLauncher extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private LwjglAWTCanvas lwjglAWTCanvas;

    public ApplicationLauncher() throws HeadlessException {
        setTitle(ApplicationLauncher.class.getSimpleName());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);

        launchSample("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicationLauncher();
            }
        });
    }

    private void launchSample(String path){
        System.out.println("Launching class " + path);

        Container container = getContentPane();

        if (lwjglAWTCanvas!=null){
            lwjglAWTCanvas.stop();
            container.remove(lwjglAWTCanvas.getCanvas());
        }

        ApplicationListener sampler;

        try {
            Class<ApplicationListener> clazz = ClassReflection.forName(path);
            sampler = ClassReflection.newInstance(clazz);
        } catch (ReflectionException e) {
            throw new RuntimeException("Can't find class with name: " + path, e);
        }

        lwjglAWTCanvas = new LwjglAWTCanvas(sampler);
        lwjglAWTCanvas.getCanvas().setSize(WIDTH, HEIGHT);
        container.add(lwjglAWTCanvas.getCanvas(), BorderLayout.CENTER);

        pack();
    }

}
