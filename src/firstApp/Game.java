package firstApp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static Scanner nm = new Scanner(System.in);

    //    map
    public static char[][] map;
    public static int mapWith;
    public static int mapHeight;
    public static int mapSizeMax = 4;
    public static int mapSizeMin = 3;
    public static char empty = '_';
    public static char moved = '#';
    public static int movedCount = 0;

    public static int levelGame = 3;
    public static int startLevelGame = 1;

    //    Player
    public static char player = '@';
    public static String playerName;
    public static int playerHP = 100;
    public static int playerY;
    public static int playerX;
    public static int movesCount;
    public static int movesMade;

    //    controls
    public static final int playerMoveUp = 8;
    public static final int playerMoveDown = 2;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static int nextStep;

    //    Trap
    public static char[][] hideTrap;
    public static boolean trapHidden = false;
    public static char trap = 'T';                  // Ловушка I-го уровня
    public static char trapSecond = 't';            // Ловушка II-го уровня
    public static int trapLevel1Cont = 0;
    public static int trapLevel2Cont = 0;
    public static boolean isTrapSecond = false;
    public static int trapCount;
    public static int trapAttack;
    public static int trapValueMin = 5;
    public static int trapValueMax = 10;
    public static int movedAttack = 10;             // Если ты уже ходил здесь и возвращаешся обратно

    public static void main(String[] args){
        System.out.print("Type your name: ");
        playerName = nm.nextLine();
        System.out.print("\nHide trap? (0 => No | 1 => Yes) ");
        int hidden = sc.nextInt();
        if(hidden == 1){
            trapHidden = true;
        }

        while (true){
            movesMade = 0;
            createMap();
            spawnPlayer();
            spawnTrap();

            while (true){
                infoHeaderGame();
                showMap();
                infoFooterGame();

                if(isFullMap()){
                    System.out.println(playerName + " you passed level: " + startLevelGame);
                    break;
                } else if(isMovedOut()){
                    System.out.println("You have made last move...");
                    break;
                } else if(isPlayerHPOut()){
                    System.out.println("You have no HP...");
                    break;
                }else {
                    playerMove();
                }
            }

            if(isLastLevel() && !isMovedOut() && !isPlayerHPOut() || (isLastLevel() && isMovedOut()) || (isLastLevel() && isPlayerHPOut())) {
                System.out.println("All Levels past!!!");
                gameOver();
                break;
            }

            if((isPlayerHPOut() || isMovedOut()) && !isLastLevel()){
                System.out.println(playerName + " Loser...");
                gameOver();
                break;
            } else {
                System.out.print("Wish to continue?  (0 => No | 1 => Yes) ");
                nextStep = sc.nextInt();
                if(nextStep == 0){
                    System.out.println(playerName + ", you cancel the game");
                    gameOver();
                    break;
                }
                playerHP += 10;
                movesMade = 0;
            }

            startLevelGame += 1;

            mapSizeMax +=1;
            mapSizeMin +=1;
        }
    }

    public static boolean isLastLevel(){
        return (startLevelGame == levelGame);
    }

    public static boolean isPlayerHPOut(){
        return (playerHP <= 0);
    }

    public static boolean isMovedOut(){
        return (movesMade == movesCount);
    }

    public static void playerMove(){
        int currPlayerX = playerX;
        int currPlayerY = playerY;

        int direction;

        do{
            System.out.print("Where you go? Enter a number to move: \n" +
                    "\t\tUP: " + playerMoveUp +
                    "\nLeft: " + playerMoveLeft + "\t\tRight: " + playerMoveRight +
                    "\n\t\tDown: " + playerMoveDown
            );

            direction = sc.nextInt();

            switch (direction) {
                case playerMoveUp -> playerX -= 1;
                case playerMoveLeft -> playerY -= 1;
                case playerMoveDown -> playerX += 1;
                case playerMoveRight -> playerY += 1;
                default -> System.out.println("switch Use only taste 2, 4, 6, 8");
            }
        } while (!checkForMove(currPlayerX, currPlayerY, playerX, playerY));

        playerAction(currPlayerX, currPlayerY, playerX, playerY);
    }

    public static boolean checkForMove(int currPlayerX, int currPlayerY, int nextX, int nextY){
        if(nextX >= 0 && nextY >= 0 && nextY < mapWith && nextX < mapHeight){
            return true;
        } else {
            System.out.println("Can't move out of array");
            playerX = currPlayerX;
            playerY = currPlayerY;
            return false;
        }
    }

    public static void playerAction(int lastX, int lastY, int nextX, int nextY) {
        if(isTrapSecond) {
            map[lastX][lastY] = trapSecond;
            if (trapHidden) hideTrap[lastX][lastY] = trapSecond;
            isTrapSecond = false;
        } else {
            map[lastX][lastY] = moved;
        }
        if(lastX != nextX || lastY != nextY) {
            if ((trapHidden && hideTrap[nextX][nextY] == trap) || (!trapHidden && map[nextX][nextY] == trap)) {
                playerHP = playerHP - trapAttack;
                isTrapSecond = true;
                trapLevel1Cont++;
                System.out.println("Trap Level 1 attack: " + trapAttack);
            } else if ((trapHidden && hideTrap[nextX][nextY] == trapSecond) || (!trapHidden && map[nextX][nextY] == trapSecond)) {
                playerHP = playerHP - trapAttack * 2;
                trapLevel2Cont++;
                System.out.println("Trap Level 2 attack: " + trapAttack * 2);
            } else if (map[nextX][nextY] == moved) {
                playerHP -= movedAttack;
                movedCount++;
                System.out.println("You was here: " + movedAttack);
            }
            movesMade += 1;
        }
        map[nextX][nextY] = player;
    }

    public static void spawnPlayer(){
        playerY = randomVal(0, mapWith - 1);
        playerX = randomVal(0, mapHeight - 1);
        map[playerX][playerY] = player;
    }

    public static void spawnTrap(){
        int trapX, trapY;
        trapAttack = randomVal(trapValueMin,trapValueMax);
        trapCount = (mapHeight * mapWith) / 4;
        if(!trapHidden) movesCount -= trapCount / 2;

        for (int i = 1; i <= trapCount; i++){
            do {
                trapX = random.nextInt(mapHeight);
                trapY = random.nextInt(mapWith);
            } while (!isEmpty(trapX,trapY));

            if(trapHidden){
                hideTrap[trapX][trapY] = trap;
            } else {
                map[trapX][trapY] = trap;
            }
        }
    }

    public static boolean isFullMap(){
        for(int x = 0; x < mapHeight; x++){
            for (int y = 0; y < mapWith; y++)
                if(map[x][y] == empty) return false;
        }
        return true;
    }

    public static void createMap(){
        mapHeight =  randomVal(mapSizeMin, mapSizeMax);
        mapWith =  randomVal(mapSizeMin, mapSizeMax);
        movesCount = mapHeight * mapWith;

        if(trapHidden) hideTrap = new char[mapHeight][mapWith];
        map = new char[mapHeight][mapWith];
        for (int x = 0; x < mapHeight; x++){
            for (int y = 0; y < mapWith; y++) {
                map[x][y] = empty;
                if(trapHidden) hideTrap[x][y] = empty;
            }
        }
    }

    public static void showMap(){
        for (int x = 0; x < mapHeight; x++){
            System.out.print("\t\t");
            for (int y = 0; y < mapWith; y++) {
                if (y == 0) System.out.print("|");
                System.out.print(map[x][y] + "|");
            }
            System.out.println();
        }
    }

    public static void infoHeaderGame(){
        System.out.println("========== Map size " + mapWith + "X" + mapHeight + " ==========");
        System.out.println("Level: " + startLevelGame + " |\tHP: " + playerHP + " |\tTrap: " + trapCount);
    }

    public static void infoFooterGame(){
        System.out.println("Moves left: " + movesMade + " => " + movesCount);
        System.out.println("==================================");
    }

    public static void gameOver(){
        System.out.println("Last level: " + startLevelGame);
        if (!isMovedOut()) System.out.println("Moves made: " + movesMade);
        if (!isPlayerHPOut()) System.out.println("Player HP: " + playerHP);
        System.out.println("Count of trap attack");
        System.out.println("Trap level 1: " + trapLevel1Cont);
        System.out.println("Trap level 2: " + trapLevel2Cont);
    }

    public static int randomVal(int min, int max){
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isEmpty(int x, int y) {
        return map[x][y] == empty;
    }
}