/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver.Controller;

import javax.swing.JFrame;
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
        MazeView maze = new MazeView();
        maze.getView().start();
    }
    
}