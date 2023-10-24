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
                        System.out.println("Enter heuristic type (M or m for Manhattan distance or E or e for Euclidean distance):");
                        heuristicType = scanner.next().toUpperCase().charAt(0);
                        while (heuristicType!='M'&&heuristicType!='E') {
                            System.out.println("Wrong input!");
                            System.out.println("Enter heuristic type (M or m for Manhattan distance or E or e for Euclidean distance):");
                            heuristicType = scanner.next().toUpperCase().charAt(0);
                        }
                    }
                    Search<Integer> aStar = new HeuristicSearch<>(heuristicType);
                    System.out.println("the result is: " + aStar.search(initialState, goalState));
                    System.out.println("Path from initial state to goal state:");
                    System.out.println(aStar.getPath(initialState, goalState));
                    System.out.println("Nodes expanded: " + aStar.getNodesExpanded());
                    System.out.println("Cost of path: " + aStar.getCostOfPath());
                    System.out.println("Depth: " + aStar.getDepth());
                }
                case 4 -> System.out.println("Bye :)");
                default -> System.out.println("Wrong input!");
            }
        }
    }
}