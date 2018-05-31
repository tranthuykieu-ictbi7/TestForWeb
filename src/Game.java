
import java.util.Scanner;

public class Game {

    public char[][] a = new char[4][4];
    public int iPlayer = 3;
    public int jPlayer = 0;
    public int iKey = 1;
    public int jKey = 2;
    public int iExit = 2;
    public int jExit = 3;

    private boolean getKey = false;
    private boolean getExit = true;
    private boolean exit = false;

    public Game() {

        Scanner keyboardScanner = new Scanner(System.in);
        this.showMap(a);

        while (true){
            System.out.println("Your move?  ");
            String inputPlayer = keyboardScanner.nextLine();
            char input = inputPlayer.charAt(0);

            this.movePlayer(input);
            showMap(a);
            if (this.exit == true) return;
        }

    }


    public void showMap(char a[][]){
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){

                if (i == iKey && j == jKey && getKey == false){
                    a[i][j] = 'K';
                } else if (i == iPlayer && j == jPlayer){
                    a[i][j] = 'P';
                } else if (i == iExit && j == jExit){
                    a[i][j] = 'E';
                } else {
                    a[i][j] = '-';
                }

                if (iKey == iPlayer && jKey == jPlayer){
                    a[iPlayer][jPlayer] = 'P';
                }

            }
        }
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public void movePlayer(char inputPlayer){

        if (inputPlayer == 'w' && iPlayer >= 1){
            this.iPlayer -= 1;
            getKey();
            checkToExit();
            if (!this.getExit) {
                this.iPlayer += 1;
            }
        }
        if (inputPlayer == 's' && iPlayer <= 2){
            this.iPlayer +=1;
            getKey();
            checkToExit();
            if (!this.getExit) {
                this.iPlayer -= 1;
            }
        }
        if (inputPlayer == 'a' && jPlayer >= 1){
            this.jPlayer -= 1;
            getKey();
            checkToExit();
            if (!this.getExit){
                this.jPlayer += 1;
            }
        }
        if (inputPlayer == 'd' && jPlayer <= 2){
            this.jPlayer += 1;
            getKey();
            checkToExit();
            if (!this.getExit){
                this.iPlayer -= 1;
            }
        }

    }

    public void getKey(){
        if (iPlayer == iKey && jPlayer == jKey){
            this.getKey = true;
            System.out.println("You’ve just picked up a key!!!");
        }
    }


    public void checkToExit(){
        if (iPlayer == iExit && jPlayer == jExit && this.getKey == false){
            System.out.println("You can't exit, please acquire the key (K) first.");
            this.getExit = false;
        }
        if (iPlayer == iExit && jPlayer == jExit && this.getKey == true){
            System.out.println("Congrats, you’ve just escaped the dungeon !!");
            this.getExit = true;
            this.exit = true;
        }
    }


}
