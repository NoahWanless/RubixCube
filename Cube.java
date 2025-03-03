import java.text.ListFormat.Style;
import java.util.Scanner;




public class Cube {
    static int[][][] cube;

    public Cube(){
        cube = new int[6][3][3];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    cube[i][j][k] = i+1;
                }   
            }
        }
    } 
    public static int[] get_row_or_get_col(int side, boolean is_r, int index){ //if not row a col is needed
        if(is_r){
            int[] temp = new int[3];
            for(int i = 0; i < 3; i++){
                temp[i] = cube[side-1][index-1][i];
            }
            return temp;
        } else{
            int[] temp = new int[3];
            for(int i = 0; i < 3; i++){
                temp[i] = cube[side-1][i][index-1];
            }
            return temp;
        }
        
    }
    public static void set_row_or_get_col(int side, boolean is_r, int index, int[]arr ){ //if not row a col is needed
        if(is_r){
            for(int i = 0; i < 3; i++){
                cube[side-1][index-1][i] = arr[i];
            }
        } else{
            for(int i = 0; i < 3; i++){
                cube[side-1][i][index-1] = arr[i];
            }
        }
    }
    public void rotate_side(int side,boolean clockwise){
        if(clockwise){
            side = side -1;
            int temp1 =cube[side][0][0];
            int temp2 =cube[side][0][1]; 
            int temp3 =cube[side][0][2]; 
            int temp4 =cube[side][1][2]; 
            int temp5 =cube[side][2][2]; 
            int temp6 =cube[side][2][1]; 
            int temp7 =cube[side][2][0]; 
            int temp8 =cube[side][1][0]; 
            
            cube[side][0][1] = temp1;
            cube[side][0][2] = temp2;
            cube[side][1][2] = temp3;
            cube[side][2][2] = temp4;
            cube[side][2][1] = temp5;
            cube[side][2][0] = temp6;
            cube[side][1][0] = temp7;
            cube[side][0][0] = temp8;

            temp1 =cube[side][0][0];
            temp2 =cube[side][0][1]; 
            temp3 =cube[side][0][2]; 
            temp4 =cube[side][1][2]; 
            temp5 =cube[side][2][2]; 
            temp6 =cube[side][2][1]; 
            temp7 =cube[side][2][0]; 
            temp8 =cube[side][1][0]; 
            
            cube[side][0][1] = temp1;
            cube[side][0][2] = temp2;
            cube[side][1][2] = temp3;
            cube[side][2][2] = temp4;
            cube[side][2][1] = temp5;
            cube[side][2][0] = temp6;
            cube[side][1][0] = temp7;
            cube[side][0][0] = temp8;
            
        } else{ //counterclockwise 
            rotate_side(side, true );
            rotate_side(side, true );
            rotate_side(side, true );
        }
    }
    public static char fromNumtoLetter(int i){
        if(i == 1){
            return 'W';//1
        } else if(i == 2){
            return 'R';//2
        } else if(i == 3){
            return 'B';//3
        } else if(i == 4){
            return 'O';//4
        } else if(i == 5){
            return 'G';//5
        } else if(i == 6){
            return 'Y';//6
        } else{
            return '0';
        }

    }
    public void printcube(){
        for(int j = 0; j < 3; j++){
            System.out.print("    ");
            for(int k = 0; k < 3; k++){
                //System.out.print(fromNumtoLetter(cube[i][j][k]));
                
                System.out.print(fromNumtoLetter(cube[5][j][k]));
            }
            System.out.println();
        }
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 3; k++){
                //System.out.print(fromNumtoLetter(cube[i][j][k]));
                System.out.print(fromNumtoLetter(cube[3][j][k]));
            }
            System.out.print(" ");
            for(int k = 0; k < 3; k++){
                //System.out.print(fromNumtoLetter(cube[i][j][k]));
                System.out.print(fromNumtoLetter(cube[2][j][k]));
            }
            System.out.print(" ");
            for(int k = 0; k < 3; k++){
                //System.out.print(fromNumtoLetter(cube[i][j][k]));
                System.out.print(fromNumtoLetter(cube[1][j][k]));
            }
            System.out.println();
        }
        for(int j = 0; j < 3; j++){
            System.out.print("    ");
            for(int k = 0; k < 3; k++){
                //System.out.print(fromNumtoLetter(cube[i][j][k]));
                
                System.out.print(fromNumtoLetter(cube[0][j][k]));
            }
            System.out.println();
        }
        for(int j = 0; j < 3; j++){
            System.out.print("    ");
            for(int k = 0; k < 3; k++){
                //System.out.print(fromNumtoLetter(cube[i][j][k]));
                
                System.out.print(fromNumtoLetter(cube[4][j][k]));
            }
            System.out.println();
        }
    }
    public void move(String c){
        System.out.println(c.getClass().getSimpleName());
        
        //c = c.substring(0,1);
        String c2 = c.substring(0,1);
        System.out.println(c2);
        //c = c.replaceAll("[^a-zA-Z]", "");
        if(c2 == "R"){
            int[] bluetemp = get_row_or_get_col(3, false, 3); //taking thrid column of Y B W G
            
            int[] yellowtemp = get_row_or_get_col(6, false, 3);
            
            int[] greentemp = get_row_or_get_col(5, false, 3);
            
            int[] whitetemp = get_row_or_get_col(1, false, 3);
            
            
            set_row_or_get_col(3, false, 3, whitetemp);
            set_row_or_get_col(1, false, 3, greentemp);   
            set_row_or_get_col(5, false, 3, yellowtemp);
            set_row_or_get_col(6, false, 3, bluetemp);
            rotate_side(2, true);
        } else if(c == "R'"){
            move("R");
            move("R");
            move("R");
        } else if (c == "L'"){
            int[] bluetemp = get_row_or_get_col(3, false, 1);
            
            int[] yellowtemp = get_row_or_get_col(6, false, 1);
            
            int[] greentemp = get_row_or_get_col(5, false, 1);
            
            int[] whitetemp = get_row_or_get_col(1, false, 1);
            
            rotate_side(4, false ); //!THIS MAY NEED TO BE FLIPPED
            set_row_or_get_col(3, false, 1, whitetemp);
            set_row_or_get_col(1, false, 1, greentemp);   
            set_row_or_get_col(5, false, 1, yellowtemp);
            set_row_or_get_col(6, false, 1, bluetemp);
        } else if(c == "L"){
            move("L'");
            move("L'");
            move("L'");
        } else if(c == "U"){
            int[] bluetemp = get_row_or_get_col(3, true, 1);
            
            int[] redtemp = get_row_or_get_col(2, true, 1);
            
            int[] greentemp = get_row_or_get_col(5, true, 3);
            
            int[] orangetemp = get_row_or_get_col(4, true, 1);
            
            rotate_side(6, true ); //!THIS MAY NEED TO BE FLIPPED
            set_row_or_get_col(3, true, 1, redtemp);
            set_row_or_get_col(2, true, 1, greentemp);   
            set_row_or_get_col(5, true, 3, orangetemp);
            set_row_or_get_col(4, true, 1, bluetemp);
        } else if(c == "U'"){
            move("U");
            move("U");
            move("U");
        } else if(c == "D'"){
            int[] bluetemp = get_row_or_get_col(3, true, 3);
            int[] redtemp = get_row_or_get_col(2, true, 3);
            int[] greentemp = get_row_or_get_col(5, true, 1);
            int[] orangetemp = get_row_or_get_col(4, true, 3);
            
            rotate_side(1, false );
            set_row_or_get_col(3, true, 3, redtemp);
            set_row_or_get_col(2, true, 3, greentemp);   
            set_row_or_get_col(5, true, 1, orangetemp);
            set_row_or_get_col(4, true, 3, bluetemp);
        } else if(c == "D"){
            move("D'");
            move("D'");
            move("D'");
        } else if(c == "F"){
            int[] redtemp = get_row_or_get_col(2, false, 1);
            
            int[] yellowtemp = get_row_or_get_col(6, true, 3);
            
            int[] orangetemp = get_row_or_get_col(4, false, 3);
            
            int[] whitetemp = get_row_or_get_col(1, true, 1);
            
            rotate_side(3, true);
            set_row_or_get_col(2, false, 1, yellowtemp);
            set_row_or_get_col(6, true, 3, orangetemp);   
            set_row_or_get_col(4, false, 3, whitetemp);
            set_row_or_get_col(1, true, 1, redtemp);
        } else if(c == "F'"){
            move("F");
            move("F");
            move("F");
        } else if(c == "B"){
            int[] redtemp = get_row_or_get_col(2, false, 3);
            
            int[] yellowtemp = get_row_or_get_col(6, true, 1);
            
            int[] orangetemp = get_row_or_get_col(4, false, 1);
            
            int[] whitetemp = get_row_or_get_col(1, true, 3);
            
            rotate_side(5, false);
            set_row_or_get_col(2, false, 3, yellowtemp);
            set_row_or_get_col(6, true, 1, orangetemp);   
            set_row_or_get_col(4, false, 1, whitetemp);
            set_row_or_get_col(1, true, 3, redtemp);
        } else if(c == "B'"){
            move("B");
            move("B");
            move("B");
        } else {
            System.out.println("Was unable to interprut the input");
        }
    }

    public static void main(String[] args) {
        Cube c = new Cube();
        Scanner scan = new Scanner(System.in);
        String test2 = scan.next();
        c.printcube();
        c.move(test2);
        
        String test1 = "R";
        c.printcube();
        System.out.println();
        c.move(test1);
        c.printcube();
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();

        System.out.println();
        for(int i = 0; i < args.length; i++){
            c.move(args[i]);
            c.printcube();
            System.out.println();

        }
        
        c.printcube();
        
        
        
        
        
    
        
        
    }



}