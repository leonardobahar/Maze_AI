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
    private int[][] maze = 
  { 
    {1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,0,1,0,1,0,1,0,0,0,0,0,1},
    {1,0,1,0,0,0,1,0,1,1,1,0,1},
    {1,0,0,0,1,1,1,0,0,0,0,0,1},
    {1,0,1,0,0,0,0,0,1,1,1,0,1},
    {1,0,1,0,1,1,1,0,1,0,0,0,1},
    {1,0,1,0,1,0,0,0,1,1,1,0,1},
    {1,0,1,0,1,1,1,0,1,0,1,0,1},
    {1,0,0,0,0,0,0,9,0,0,1,0,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1}
  }; //goal at 11,8
  /*
    1 - Wall / Obstacles
    
    2 - Visited Node
    9 - Goal  
  */
  private final List<Integer> path = new ArrayList<Integer>();
    
  public MazeView(){
    setTitle("Maze");
    setSize(640, 480);
    setLocation(0,0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    
    //For visited path
    DepthFirstSolver.searchPath(maze, 1, 1, path);
    System.out.println(path);
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
        
        for (int i = 0; i < path.size(); i+=2) {
            int pathX = path.get(i);
            int pathY = path.get(i+1);
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
          MazeView view = new MazeView();
          view.setVisible(true);
        }
      });
      
      return viewThread;
  }
  
}
