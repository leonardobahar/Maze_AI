/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver.View;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mazesolver.Util.DepthFirstSolver;

/**
 *
 * @author john
 */
public class MazeView extends JFrame{
  private int[][] maze;
  
  private ArrayList<Integer> xpath;
  private ArrayList<Integer> ypath;
    
  public MazeView(int[][] maze, ArrayList<Integer> xpath, ArrayList<Integer> ypath){
    this.maze = maze;
    this.xpath = xpath;
    this.ypath = ypath;
    setTitle("Maze");
    setSize(640, 480);
    setLocation(0,0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }
  
  @Override
  public void paint(Graphics g){
    super.paint(g);
    g.translate(125, 80);
    
    for (int row=0; row<maze.length; row++){
        for (int col=0; col<maze[0].length; col++){
            Color color;
            switch  (maze[row][col]){
                    case 1  : color = Color.BLACK;
                              break;
                    case 2  : color = Color.GRAY;
                              break;
                    case 9  : color = Color.RED;
                              break;
                    default : color = Color.WHITE;
            }
            g.setColor(color);
            g.fillRect(30*col, 30*row, 30, 30);
            g.setColor(Color.BLACK);
            g.drawRect(30*col, 30*row, 30, 30);
        }
        
        for (int i = 0; i < xpath.size(); i++) {
            int pathX = xpath.get(i);
            int pathY = ypath.get(i);
            if  (maze[pathY][pathX]!=9) {
                g.setColor(Color.GREEN);
                g.fillRect(pathX * 30, pathY * 30, 30, 30);
            }
        }
    }
  }
  
  public Thread getView(){
      Thread viewThread = new Thread(new Runnable(){
        public void run(){
          //For visited path
          System.out.println("X Path : "+xpath);
          System.out.println("Y Path : "+ypath);
          MazeView view = new MazeView(maze, xpath, ypath);
          view.setVisible(true);
        }
      });
      
      return viewThread;
  }
  
}
