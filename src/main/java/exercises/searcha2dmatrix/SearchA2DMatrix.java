package main.java.exercises.searcha2dmatrix;

public class SearchA2DMatrix {
    public static void main(String[] args){
        var sol = new Solution();
        int[][] matrix = {{1,3}};
        var result = sol.searchMatrix(matrix, 3);

        System.out.println(result);
    }
}

class Solution{

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        if(col == 0 && row == 0){
            if(target == matrix[row][col]){
                return true;
            }
        }

        if(row == 0){
            return binarySearch(matrix, 0, col, target);
        }

        int l = 0;
        int r = row;

        while(l < r){
            int midRow = (r - l) / 2;

            if(target < matrix[midRow][0]){
                r = midRow - 1;
                if(target > matrix[r][0] && target < matrix[r][col]){
                    return binarySearch(matrix, r, col, target);
                }
            }else{
                l = midRow + 1;
                if(target > matrix[l][0] && target < matrix[l][col]){
                    return binarySearch(matrix, l, col, target);
                }
            }

            if(target == matrix[midRow][0]){
                return true;
            }
        }



        return false;
    }

    public boolean binarySearch(int[][] matrix, int row, int col, int target){
        int left = 0;
        int right = col;

        int midCol = (left + right) / 2;

        while(left < right){


            if(target > matrix[row][midCol]){
                left = midCol + 1;
            }else{
                right = midCol - 1;
            }

            if(target == matrix[row][midCol]){
                return true;
            }
        }

        if(target == matrix[row][midCol]){
            return true;
        }

        return false;
    }

}