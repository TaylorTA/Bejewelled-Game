import java.io.*;
import java.sql.Array;

public class Grid {
    private char [][] board;
    public static char[] gems = {'r','g','b','y'};
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public Grid(int height, int width){
        board = new char[height][width];
        fillBoard();
    }

    public Grid(char[][] someGrid){
        board = someGrid;
    }

    public static Grid createGrid(String filename) throws IOException{
        char[][] board = null;
        int height;
        int width;
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String line = bf.readLine();
        if(line == null)
            throw new IOException("Bad dimensions to read");
        String[] tokens = line.split(" ");
        if(tokens.length!=2)
            throw new IOException("Bad dimensions to read");
        // if is not a number
        try {
            height = Integer.parseInt(tokens[0]);
            width = Integer.parseInt(tokens[1]);
        } catch(NumberFormatException nbe){
            throw new IOException("The size values were not numeric!");
        }
        board = new char[height][width];
        for(int i =0; i<height; i++){
            line = bf.readLine();
            if(line == null)
                throw new IOException("There was not enough rows! Saw " + i +" need " + height);
            if(line.trim().length() != width)
                throw new IOException("There was not enough colums. Saw " + line.length() + " need " + width);
            for(int j=0; j<width; j++)
                board[i][j] = line.charAt(j);
        }
        bf.close();
        return new Grid(board);
    }

    public void save(String filename) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            pw.write(board.length + " " + board[0].length + "\n");
            pw.write(this.toString());
            pw.close();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void fillBoard() {
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = getRandomGem();
            }
        }
    }

    public char[] extractRow(int rowNum){
        return board[rowNum];
    }

    public char[] extractColumn(int colNum){
        char[] result = new char[board.length];
        for(int i = 0; i< board.length; i++)
            result[i] = board[i][colNum];
        return result;
    }

    public static char getRandomGem(){
        int choice = (int)(Math.random() * gems.length);
        return gems[choice];
    }

    public static char[] replaceSets(char[] input){
        char curr = input[0];
        int count = 1;
        char[] result = new char[input.length];
        for(int i=0; i<input.length;i++)
            result[i]=input[i];
        System.arraycopy(input,0,result,0,input.length);
        for(int i=1; i<input.length; i++){
            if(input[i] == curr) {
                count++;
                if(count == 3){
                    result[i]='x';
                    result[i-1]='x';
                    result[i-2]='x';
                }
            }else{
                curr = input[i];
                count = 1;
            }
        }
        return result;
    }

    public void replaceAll(){
        char[][] replacedBoard = new char[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            replacedBoard[i] = replaceSets(extractRow(i));
        }
        for(int i=0; i<board[0].length;i++){
            char[] replacedColumn = replaceSets(extractColumn(i));
            for(int j=0; j<replacedColumn.length; j++){
                if(replacedBoard[j][i]!=replacedColumn[j] && replacedColumn[j]=='x')
                    replacedBoard[j][i] = replacedColumn[j];
            }
        }
        board = replacedBoard;
    }

    public boolean drop(){
        boolean result = false;
        for(int i=0; i<board.length-1;i++){
            for(int j=0; j<board[i].length;j++){
                if(board[i+1][j] == 'x'){
                    board[i+1][j] = board[i][j];
                    board[i][j] = getRandomGem();
                    result = true;
                }
            }
        }
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++){
                if(board[i][j] == 'x'){
                    board[i][j] = getRandomGem();
                    result = true;
                }
            }
        }
        return result;
    }

    public void swap(int row, int col, int direction)throws IndexOutOfBoundsException{
        if(direction == UP){
            if(row-1<0)
                throw new IndexOutOfBoundsException("Cannot move up!");
            char temp = board[row][col];
            board[row][col]=board[row-1][col];
            board[row-1][col]=temp;
        }else if(direction == DOWN){
            if(row + 1 > board.length-1)
                throw new IndexOutOfBoundsException("Cannot move down!");
            char temp = board[row][col];
            board[row][col]=board[row+1][col];
            board[row+1][col]=temp;
        }else if(direction == LEFT){
            if(col-1<0)
                throw new IndexOutOfBoundsException("Cannot move left!");
            char temp = board[row][col];
            board[row][col]=board[row][col-1];
            board[row][col-1]=temp;
        }else if(direction == RIGHT){
            if(col+1>board[row].length-1)
                throw new IndexOutOfBoundsException("Cannot move right!");
            char temp = board[row][col];
            board[row][col]=board[row][col+1];
            board[row][col+1]=temp;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++){
                result += board[i][j];
            }
            result += "\n";
        }
        return result;
    }
}
