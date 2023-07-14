package main.java.exercises.palavracruzada;

import java.util.*;

import static main.java.exercises.palavracruzada.PalavraCruzada.CROSSWORD_SIZE;


public class PalavraCruzada {
    public static void main(String[] args) {
        char[][] board = {{'+','+','+','+','+','+','+','+','+','-'},
                          {'-','+','+','+','+','+','+','+','+','-'},
                          {'-','-','-','-','-','-','-','+','+','-'},
                          {'-','+','+','+','+','+','+','+','+','-'},
                          {'-','+','+','+','+','+','+','+','+','-'},
                          {'-','+','+','+','+','-','-','-','-','-'},
                          {'-','-','-','-','-','-','+','+','+','-'},
                          {'-','+','+','+','+','+','+','+','+','-'},
                          {'+','-','-','-','-','-','-','-','-','-'},
                          {'+','+','+','+','+','+','+','+','+','+'}};


        List words = List.of("chemistry", "physics", "history", "maths", "civics", "geography");
        PalavraCruzadaSolution sol = new PalavraCruzadaSolution();
        sol.cruzaPalavras(board, words);
    }

    static final int CROSSWORD_SIZE = 3;
}

class PalavraCruzadaSolution{

    public boolean cruzaPalavras(char[][] board, List<String> words){

        int rowSize = board.length;
        int colSize = board[0].length;

          printBoard(board);
        Map[] positions = new HashMap[words.size()];

        for(int i = 0; i < words.size(); i++){
            positions[i] = new HashMap<Integer, Character>();
        }

        //populando os maps com cada caractere de cada palavra
        for(int i = 0; i < words.size(); i++){
            for(Character c : words.get(i).toCharArray()){
                positions[i].put(i, c);
            }
        }


        Set<List<Integer>> test = new HashSet<>();
        test.stream().toList();

        var te = new ArrayList<>(List.of(1, 3, 2));
        Collections.sort(te);

        var t = te;



        int countFreeRows = 0;
        int countFreeCols = 0;
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                char curr = board[i][j];
                if(curr == '-'){
                    int countI = i;
                    while(countI + 1 < rowSize){
                        if(board[countI + 1][j] != '+'){
                            if(board[countI + 1][j] == '-'){
                                countFreeRows++;
                                countI++;
                            }else{ //some char in the position i + 1
                                int start = i;
                                for(int k = 0; k < positions.length; k++){
                                    if(positions[k].get(countFreeRows + 1).equals(board[countI + 1][j]) &&
                                            positions[k].size() == countFreeRows + 1){
                                        // deu match. preencher board
                                    }
                                }

                                countI++;
                            }
                        }
                        break;
                    }

                    for(int k = 0; k < positions.length; k++){
                        if(positions[k].size() == countFreeRows){
                            // deu match. preencher board
                            for(int w = 0; w < countFreeRows; w++){
                                board[i + w][j] = (char) positions[k].get(w);
                            }
                        }
                    }

                    printBoard(board);



                    if(j + 1 < colSize){
                        if(board[i][j + 1] != '+'){

                        }
                    }
                }


            }
        }




        return true;
    }

    private void printBoard(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
