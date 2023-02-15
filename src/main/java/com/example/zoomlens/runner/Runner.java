package com.example.zoomlens.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,1));
        frame.add(new JPanel(), BorderLayout.NORTH);
        frame.add(new JPanel(), BorderLayout.SOUTH);
        frame.add(new JPanel(), BorderLayout.EAST);
        frame.add(new JPanel(), BorderLayout.WEST);
        frame.setBounds(0,0,500, 500);

        frame.setVisible(true);
        Point lastLocation  = new Point(0,0);
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                lastLocation.move(e.getX(), e.getY());
            }
        });
        frame.addMouseMotionListener(new MouseMotionAdapter() {
//            volatile boolean moving = false;
            @Override
            public synchronized void mouseDragged(MouseEvent e) {
//                if(!moving) {
//                    moving=true;
                    super.mouseDragged(e);
                    int deltaX=e.getX() - lastLocation.x;
                    int deltaY=e.getY() - lastLocation.y;

                    frame.setLocation(((int) (frame.getLocation().getX() + deltaX)), ((int) (frame.getLocation().getY() + deltaY)));
//                }
//                moving = false;
            }
        });
    }
}
