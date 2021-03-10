package com.DFS;

import javax.swing.*;
import javax.xml.xpath.XPath;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class view extends JFrame {

//    maze [row][col]
//    Values: 0 = not visited nodes
//            1 = wall or blocked
//            2 = visited node
//            9 = targeted node

    private int [][] maze={

                    {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,9,1}, //row 11 column 7
                    {1,0,0,0,0,0,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public List<Integer> path = new ArrayList<Integer>();
    public view(){
        setTitle("Maze solver");
        setSize(650,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        dfs.searchPath(maze,1,1,path);
        System.out.println(path);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.translate(50,50);

        for(int row = 0; row< maze.length; row++){
            for(int col = 0; col < maze[0].length; col++){
                Color color;
                switch (maze[row][col]){
                    case 1: color = Color.YELLOW;break;
                    case 9: color = Color.BLACK;break;
                    default:color = Color.BLUE;
                }
                g.setColor(color);
                g.fillRect(40*col, 40*row, 40,40);
                g.setColor(Color.WHITE);
                g.drawRect(40*col, 40*row, 40,40);
            }
        }

        for(int p = 0; p < path.size(); p+=2){
            int pathX= path.get(p);
            int pathY= path.get(p+1);
            g.setColor(Color.PINK);
            g.fillRect(pathX*40,pathY*40,40,40);
        }

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view View = new view();
                View.setVisible(true);
            }
        });
    }

}
