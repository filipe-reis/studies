package main.java.exercises.eightpuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EightPuzzle {

//    This problem was asked by Airbnb.
//
//    An 8-puzzle is a game played on a 3 x 3 board of tiles, with the ninth tile missing.
//    The remaining tiles are labeled 1 through 8 but shuffled randomly.
//    Tiles may slide horizontally or vertically into an empty space, but may not be removed from the board.
//    Design a class to represent the board, and find a series of steps to bring the board to the state
//    [[1, 2, 3], [4, 5, 6], [7, 8, None]].
    /**
     * 3 2 4
     * 8 1 -
     * 6 7 5
     */


    /**
     * 1 2 3
     * 8 4 7 tentar ordernar o 4 -> 7 -> 6 porque está desordenado. A ideia é manter o L invertido ordenado.
     * 5 6 -
     */

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 -
     */

    /**
     * 1 2 3
     * 4 8 -
     * 7 6 5
     */
    public static void main(String[] args) {
        int[][] puzzle = {{3,2,4},{8,1,9},{6,7,5}};
        var solution = new EightPuzzleSolution();
        var initialTime = System.currentTimeMillis();
        var response = solution.eightPuzzle(puzzle);
        var finalTime = System.currentTimeMillis();


        String te = "teste";
        var time = finalTime - initialTime;
        System.out.println("Tempo de Processamento: " + time + "ms");
        System.out.println(response.toString());
    }
}

class EightPuzzleSolution {
    public List<Integer> eightPuzzle(int[][] puzzle){

        List<Integer> numberSwap = new ArrayList<>();
        Map<Integer, List<Integer>> position = new HashMap<>();

        //inicializa um mapa que contem a posicao certa de cada numero
        int number = 1;
        for(int i = 0; i < puzzle.length; i++){
            for(int j = 0; j < puzzle[0].length; j++){
                List<Integer> rowCol = new ArrayList<>();
                rowCol.add(i);
                rowCol.add(j);
                position.put(number, rowCol);
                number++;
            }
        }
        var retry = true;

        var count = 0;
        do{
            count++;
            // Faz swap dos numeros que estão na posição errada
            for(int i = 0; i < puzzle.length; i++){
                for(int j = 0; j < puzzle[0].length; j++){
                    int num = puzzle[i][j];
                    var numPosition = position.get(num);
                    var row = numPosition.get(0);
                    var col = numPosition.get(1);
                    if(i != row || j != col){
                        var aux = puzzle[row][col];
                        puzzle[row][col] = num;
                        puzzle[i][j] = aux;
                        numberSwap.add(num);
                    }
                }
            }

            // flag para definir se repete ou termina
            retry = false;

            // verifico se a matrix ja está ordenada
            for(int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j < puzzle[0].length; j++) {
                    int num = puzzle[i][j];
                    var numPosition = position.get(num);
                    var row = numPosition.get(0);
                    var col = numPosition.get(1);
                    if(i != row || j != col){
                        retry = true;
                        break;
                    }
                }
            }
        }while(retry);

        System.out.println("Repeticoes: " + count);

        return numberSwap;
    }
}