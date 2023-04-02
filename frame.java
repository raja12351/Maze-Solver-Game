package Maze_Solver;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class frame extends JFrame{
//     designing the 2d-matrix to assign and create the paths and pattern of the maze
    private int[][] maze =
            {{1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,0,1,0,1,0,1,0,0,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,1},
                    {1,0,1,0,0,0,1,1,1,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1},
            };
    
//     creating an arraylist to store the paths from starting to the ending of the maze 
    public ArrayList<Integer> path = new ArrayList<>();
    
//     creating the constructor of frame class to implement the interface of the main frame
    public frame(){
//         setting the title of the interface
        this.setTitle("Maze Solver");
//         setting the default closing operation of the frame with backend functioning 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setting the size and location of the frame
        this.setSize(570,450);
        this.setLocation(285,100);
//         set visibility of the frame
        this.setVisible(true);
//         using dfs logic to find the path in maze
        DFS_Logic.searchPath(maze,1,1,path);
//        System.out.println(path);
    }

//     using paint function to draw and fill the maze blocks with the required color
    @Override
    public void paint(Graphics g){
        g.translate(100,50);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
//                 creating the color class to fill the  blocks according
                Color color;
                switch (maze[i][j]){
                    case 1:color = Color.BLACK;break;
                    case 9:color = Color.BLUE;break;
                    default:color = Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.red);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            g.setColor(Color.yellow);
            g.fillRect(30*pathx,30*pathy,30,30);
        }
    }

    public static void main(String[] args) {
        frame view = new frame();
    }
}
