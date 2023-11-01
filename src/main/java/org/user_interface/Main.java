package org.user_interface;

import search_algorithms.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                Welcome To 8-Puzzle Solver :)
                Enter your choice:
                1. DFS
                2. BFS
                3. A*
                4. Exit""");

        int choice = 0;
        while (choice != 4) {
            Scanner scanner = new Scanner(System.in);
            int initialState;
            int goalState;

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    GetStates:
                    {
                        System.out.println("Enter initial state:");
                        initialState = scanner.nextInt();
                        System.out.println("Enter goal state:");
                        goalState = scanner.nextInt();
                    }
                    Search<Integer> dfs = new FirstSearch<>('D');
                    dfs.search(initialState, goalState);
                }
                case 2 -> {
                    GetStates:
                    {
                        System.out.println("Enter initial state:");
                        initialState = scanner.nextInt();
                        System.out.println("Enter goal state:");
                        goalState = scanner.nextInt();
                    }
                    Search<Integer> bfs = new FirstSearch<>('B');
                    bfs.search(initialState, goalState);
                }
                case 3 -> {
                    char heuristicType;
                    System.out.println("محدش مهتم");
                    GetStates:
                    {
                        System.out.println("Enter initial state:");
                        initialState = scanner.nextInt();
                        System.out.println("Enter goal state:");
                        goalState = scanner.nextInt();
                        System.out.println("Enter heuristic type(m for Manhattan, e for Euclidean):");
                        heuristicType = scanner.next().charAt(0);

                    }

                    HeuristicSearch<Integer> A_M = new HeuristicSearch<>('M');
                    boolean success=A_M.search(initialState, goalState);
                    if(success){
                        System.out.println("Depth: "+A_M.getDepth());
                        System.out.println("Cost: "+A_M.getCostOfPath());
                        System.out.println("Nodes Expanded: "+A_M.getNodesExpanded());
                        System.out.println("Running Time: "+A_M.getRunningTime());
                    }
                    else{
                        System.out.println("No Solution");
                    }

                }
                case 4 -> System.out.println("Bye :)");
                default -> System.out.println("Wrong input!");
            }
        }
    }
}