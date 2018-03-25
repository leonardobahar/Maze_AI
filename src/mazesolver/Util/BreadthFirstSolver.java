/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver.Util;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class BreadthFirstSolver{
    public static boolean searchPath(int[][] maze, int x, int y, ArrayList<Integer> xpath, ArrayList<Integer> ypath){
        if (maze[y][x]==9) {
           xpath.add(x);
           ypath.add(y);
           return true;
        }
        
        if  (maze[y][x]==0) {
            maze[y][x]=2;
            if (searchPath(maze, x+1, y, xpath, ypath) || searchPath(maze, x-1, y, xpath, ypath) || searchPath(maze, x, y+1, xpath, ypath)|| searchPath(maze, x, y-1, xpath, ypath)) {
               xpath.add(x);
               ypath.add(y);
               return true;
            }
        }
        return false;
    }
}
