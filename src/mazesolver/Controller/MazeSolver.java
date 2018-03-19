/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver.Controller;

import java.util.ArrayList;
import javax.swing.JFrame;
import mazesolver.Util.DepthFirstSolver;
import mazesolver.View.MazeView;

/**
 *
 * @author john
 * Controller Class
 */
public class MazeSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final ArrayList<Integer> xpath = new ArrayList<Integer>();
        final ArrayList<Integer> ypath = new ArrayList<Integer>();
        
        int maze[][]={ 
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
        DepthFirstSolver.searchPath(maze, 1, 1, xpath, ypath);
        MazeView mazeView = new MazeView(maze, xpath, ypath);
        mazeView.getView().start();
    }
    
}