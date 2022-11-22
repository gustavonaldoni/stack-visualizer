package com.mycompany.stack.visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;
import javax.swing.JPanel;

public class StackDraw extends JPanel {
    int screenWidth, screenHeight;
    Stack personStack;
    int defaultSpace;
    
    public StackDraw(int screenWidth, int screenHeight, Stack personStack, int defaultSpace) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.personStack = personStack;
        this.defaultSpace = defaultSpace;
        
        setBounds(0, 0, (int)(0.75f * (float)screenWidth), screenHeight);
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        
        int i, x, y;
        int nodeSpace, nodeWidth, nodeHeight;
        
        nodeSpace = 20;
        nodeWidth = 300; nodeHeight = 80;
        
        for (i = 0; i < this.personStack.size(); i++) {
            x = this.defaultSpace;
            y = this.screenHeight - (i + 1) * (nodeHeight + nodeSpace);
            
            graphic.setColor(Color.WHITE);
            graphic.drawRect(x, y, nodeWidth, nodeHeight);
        }
           
    }
}
