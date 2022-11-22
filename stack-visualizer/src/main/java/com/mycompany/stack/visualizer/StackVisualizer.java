package com.mycompany.stack.visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Stack;

public class StackVisualizer implements WindowListener, ActionListener {

    JFrame frame;
    Container container;
    int monitorWidth, monitorHeight;
    int screenWidth, screenHeight;
    int defaultSpace;

    JButton insertButton, popButton;

    Stack personStack;
    StackDraw draw;

    public StackVisualizer(int screenWidth, int screenHeight) {
        this.frame = new JFrame();
        this.container = this.frame.getContentPane();

        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.monitorWidth = (int) monitorSize.width;
        this.monitorHeight = (int) monitorSize.height;

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setTitle("Stack visualizer");

        this.frame.setBounds((this.monitorWidth - this.screenWidth) / 2,
                (this.monitorHeight - this.screenHeight) / 2,
                this.screenWidth, this.screenHeight);

        this.frame.addWindowListener(this);

        this.defaultSpace = 50;

        this.insertButton = this.createButton("Insert", 1);
        this.popButton = this.createButton("Pop", 2);

        this.personStack = new Stack();

        JLabel titleTextLabel = this.createTextLabel("Your stack will grow here:", 20, this.defaultSpace, this.defaultSpace - 20);
        titleTextLabel.setForeground(Color.WHITE);

        this.draw = new StackDraw(this.screenWidth, this.screenHeight, this.personStack, this.defaultSpace);
        this.container.add(draw);
    }

    public JButton createButton(String text, int buttonNumber) {
        JButton button = new JButton(text);

        int buttonX, buttonY, buttonWidth, buttonHeight;

        Color backgroundColor = new Color(59, 89, 182);
        Color foregroundColor = Color.WHITE;

        Font helveticaFont = new Font("Helvetica", Font.BOLD, 16);

        buttonWidth = 100;
        buttonHeight = 40;

        buttonX = this.screenWidth - (this.defaultSpace + buttonWidth);
        buttonY = this.screenHeight - buttonNumber * (this.defaultSpace + buttonHeight);

        button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.setFont(helveticaFont);

        button.addActionListener(this);
        this.container.add(button);

        return button;
    }

    public JLabel createTextLabel(String text, int fontSize, int x, int y) {
        JLabel label = new JLabel(text);

        Font helveticaFont = new Font("Helvetica", Font.PLAIN, fontSize);

        label.setFont(helveticaFont);
        label.setBounds(x, y, fontSize * text.length(), fontSize);

        this.frame.add(label);

        return label;

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StackVisualizer(800, 800); 
            }
        });
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        this.frame.dispose();
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent we) {
        this.frame.dispose();
        System.exit(1);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.insertButton) {
            RandomPersonGenerator generator = new RandomPersonGenerator();
            Person randomPerson = generator.generate();

            this.personStack.add(randomPerson);

            System.out.println(randomPerson);
        }

        if (event.getSource() == this.popButton) {
            System.out.println("Pop clicked");

            if (this.personStack.empty() == false) {
                this.personStack.pop();
            }
        }
    }

}
