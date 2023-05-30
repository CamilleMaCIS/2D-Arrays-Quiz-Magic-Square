public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        //first row is [0]
        for (int c : array2d[0]){
            sum += c;
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int allRowsAreEqual = 0;


        for (int r = 1; r < array2d.length; r++){
            int rowSum = 0;

            for (int c : array2d[r]){
                rowSum += c;
            }

            if (rowSum == checkSum){
                allRowsAreEqual++;
            }
        }


        //array2d.length - 1 is how many rows there are in total
        //remember, minus 1 because didn't count the first row
        if (allRowsAreEqual == array2d.length - 1){
            return true;
        }
        return false;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        int allColumnsAreEqual = 0;


        for (int c = 0; c < array2d[0].length; c++){
            int colSum = 0;

            for (int r = 0; r < array2d.length; r++){
                colSum += array2d[r][c];
            }

            if (colSum == checkSum){
                allColumnsAreEqual++;
            }
        }


        //array2d[0].length is how many columns there are in total
        if (allColumnsAreEqual == array2d[0].length){
            return true;
        }
        return false;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {


        //first diagonal, top left to bottom right
        //note that for diagonals, row index = column index
        int diaSum1 = 0;
        for (int r = 0; r < array2d.length; r++){
            diaSum1 += array2d[r][r];
        }
        //second diagonal, top right to bottom left
        int diaSum2 = 0;
        for (int r = 0; r < array2d.length; r++){
            diaSum2 += array2d[r][array2d.length - 1 - r];
        }


        //if BOTH equal checkSum, it's true
        if (diaSum1 == checkSum && diaSum2 == checkSum){
            return true;
        }
        return false;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int checkSums = calculateCheckSum(array2d);

        /**
         * remember, magicRows(array2d, checkSums) ALREADY IS A BOOLEAN VALUE, so you
         * DO NOT NEED to use == true or == false
         * just directly use magicRows(array2d, checkSums) or !magicRows(array2d, checkSums)*/

        if (magicRows(array2d, checkSums) && magicColumns(array2d, checkSums) && magicDiagonals(array2d, checkSums)){
            return true;
        }
        return false;
    }

}
