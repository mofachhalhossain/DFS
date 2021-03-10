package com.DFS;

import java.util.List;

public class dfs {

    public static boolean searchPath(int[][] maze, int a, int b, List<Integer> path){

        if(maze[b][a]==9){
            path.add(a);
            path.add(b);
            return true;
        }

        if(maze[b][a] == 0){
            maze[b][a] = 2;

            int da = -1;
            int db = 0;
            if(searchPath(maze, a+da, b+db, path)){
                path.add(a);
                path.add(b);
                return true;
            }

            da = 1;
            db = 0;
            if(searchPath(maze, a+da, b+db, path)){
                path.add(a);
                path.add(b);
                return true;
            }

            da = 0;
            db = -1;
            if(searchPath(maze, a+da, b+db, path)){
                path.add(a);
                path.add(b);
                return true;
            }

            da = 0;
            db = 1;
            if(searchPath(maze, a+da, b+db, path)){
                path.add(a);
                path.add(b);
                return true;
            }

        }

        return false;
    }
}
