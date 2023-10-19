# 8-Puzzle Solver

This project was originally an assignment for the edX course [ColumbiaX: CSMM.101x Artificial Intelligence (AI)](https://www.edx.org/course/artificial-intelligence-ai) and we will use JAVA language to implement and solve the 8-puzzle game using various search algorithms and heuristics.

## Overview

An instance of the 8-puzzle game consists of a board holding eight distinct movable tiles and an empty space. The goal is to arrange all tiles in ascending order (0, 1, 2, 3, 4, 5, 6, 7, 8) by legally swapping the empty space with adjacent tiles (horizontally or vertically). The blank space is represented by the number 0.

The search problem involves finding a sequence of moves that transitions the initial state to the goal state. The search space includes all possible states reachable from the initial state. The cost of moving from one configuration to another is one, making the total cost of a path equal to the number of moves.

## Application

### Algorithms

You will need to implement the 8-puzzle search problem using three search algorithms:

1. **BFS (Breadth-First Search):** This algorithm explores nodes in breadth-first order.
2. DFS (Depth-First Search): This algorithm explores nodes in depth-first order.
3. **A* (A-Star): An informed search algorithm that uses heuristics to guide the search.

### Heuristics

For the A* algorithm, we will use two heuristics, Manhattan and Euclidean, and compare their performance in terms of the number of nodes expanded and output paths to determine which heuristic is more admissible.

1. Manhattan Distance:
It is the sum of absolute differences in x and y coordinates between the current cell and the goal cell.
Formula: `h = abs(current cell:x - goal:x) + abs(current cell:y - goal:y)`

2. Euclidean Distance:
It is the Euclidean distance between the current cell and the goal cell using the distance formula.
Formula: `h = sqrt((current cell:x - goal:x)^2 + (current cell:y - goal:y)^2)`

### Data Structures

In this project, we use the following data structures:

**Queue:** Used in BFS for node exploration.
**Stack:** Used in DFS for node exploration.
**Priority Queue:** Used in A* for node exploration with priority based on heuristics.

## Usage

Please refer to the specific algorithm implementations in the code for usage details.
