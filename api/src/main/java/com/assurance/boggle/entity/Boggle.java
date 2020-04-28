package com.assurance.boggle.entity;

import java.io.IOException;
import java.util.*;

public class Boggle {

    private DictionaryTrie dictionaryTrie;
    private int dim;
    private char[][] matrix;

    public Boggle(int dim, char[][] matrix) throws IOException {
        this.dim = dim;
        this.matrix = matrix;
        this.dictionaryTrie = new DictionaryTrie();
    }

    public Boggle(int dim, char[][] matrix, DictionaryTrie dt) {
        this.dim = dim;
        this.matrix = matrix;
        this.dictionaryTrie = dt;
    }

    public List<String> solve() {
        List<String> solutions = new ArrayList<>();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                solutions.addAll(dfsFind(new Coordinate(i, j)));
            }
        }
        return solutions;
    }


    private List<String> dfsFind(Coordinate coord) {
        List<String> wordList = new ArrayList<>();
        List<Coordinate> usedLetters = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        TrieNode currNode = dictionaryTrie.getRoot();
        // TrieNode prevNode = null;
        TrieNode child;

        Stack<Coordinate> s = new Stack<>();
        s.push(coord);

        while (!s.empty()) {
            Coordinate curr = s.pop();
            char currChar = matrix[curr.row][curr.col];

            //int sbLen = sb.length() + 1;

            while (curr.level != sb.length() + 1) {
                // Backtrack to a letter the same distance away from our start coordinate
                sb.deleteCharAt(sb.length() - 1);
                usedLetters.remove(usedLetters.size() - 1);
                //sbLen--;
            }

            if (usedLetters.contains(curr)) {
                // We can't use the same letter twice in a single word
                continue;
            }

            child = null;
            if (sb.length() == 0) {
                child = currNode.getNodeFor(currChar);
            } else {
                child = dictionaryTrie.getRoot().getEndOfPrefix(sb.toString());
            }


            if (child != null) {
                // If words exist with this prefix add it to stringBuilder
                sb.append(currChar);
                usedLetters.add(curr);

                //prevNode = currNode;
                currNode = child;

                if (sb.length() > 2 && dictionaryTrie.getRoot().exists(sb.toString())) {
                    wordList.add(sb.toString());
                }

                for (Coordinate c : getAdjacent(curr)) {
                    c.level = curr.level + 1;
                    s.push(c);
                }

            }

        }

        return wordList;

    }

    private List<BoggleLetter> getAdjacent(BoggleLetter bl) {
        int row = bl.getCoordinate().row;
        int col = bl.getCoordinate().col;
        List<BoggleLetter> adjacent = new ArrayList<>();
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                if (!(i == row && j == col) && i >= 0 && i < dim && j >= 0 && j < dim) {
                    adjacent.add(new BoggleLetter(new Coordinate(i, j), matrix[i][j]));
                }
            }
        }
        return adjacent;
    }

    private List<Coordinate> getAdjacent(Coordinate coord) {
        int row = coord.row;
        int col = coord.col;
        List<Coordinate> adjacent = new ArrayList<>();
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                if (!(i == row && j == col) && i >= 0 && i < dim && j >= 0 && j < dim) {
                    adjacent.add(new Coordinate(i, j));
                }
            }
        }
        return adjacent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder((dim * 2 - 1) * dim);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        final char[][] matrix = new char[][]{{'b', 'o', 'r', 'e'}, {'r', 't', 'a', 'n'}, {'j', 'l', 'o', 'p'}, {'n', 'a', 'v', 'y'}};
        Collections.shuffle(Arrays.asList(matrix));
        final Boggle f = new Boggle(4, matrix);
        System.out.println("Solving: \n\n" + f);
        List<String> solution = f.solve();
        solution.sort((fa, s) -> Integer.compare(s.length(), fa.length()));
        solution.forEach(System.out::println);
    }
}
