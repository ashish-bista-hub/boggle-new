package com.assurance.boggle.entity;

import java.util.List;

public class BoggleDto {

    private char[][] matrix;

    private List<String> solutions;

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public List<String> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<String> solutions) {
        this.solutions = solutions;
    }
}
