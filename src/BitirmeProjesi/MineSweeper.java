package BitirmeProjesi;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int[][] minefield;
    boolean[][] revealed;
    int rows;
    int columns;
    int mines;

    public MineSweeper(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.minefield = new int[rows][columns];
        this.revealed = new boolean[rows][columns];
        initializeMinefield();
        placeMines();
    }

    public void initializeMinefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                minefield[i][j] = 0;
                revealed[i][j] = false;
            }
        }
    }

    public void placeMines() {
        Random random = new Random();
        int minesToPlace = mines;

        while (minesToPlace > 0) {
            int randomRow = random.nextInt(rows);
            int randomCol = random.nextInt(columns);

            if (minefield[randomRow][randomCol] != -1) {
                minefield[randomRow][randomCol] = -1;
                updateAdjacentCells(randomRow, randomCol);
                minesToPlace--;
            }
        }
    }

    public void updateAdjacentCells(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns && minefield[i][j] != -1) {
                    minefield[i][j]++;
                }
            }
        }
    }

    public void printMinefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (revealed[i][j]) {
                    System.out.print(minefield[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public boolean isGameWon() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!revealed[i][j] && minefield[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz!");

        while (true) {
            printMinefield();

            System.out.print("Satır Giriniz: ");
            int selectedRow = scanner.nextInt();

            System.out.print("Sütun Giriniz: ");
            int selectedCol = scanner.nextInt();

            if (selectedRow < 0 || selectedRow >= rows || selectedCol < 0 || selectedCol >= columns) {
                System.out.println("Geçersiz bir nokta seçtiniz. Lütfen tekrar deneyin.");
                continue;
            }

            if (minefield[selectedRow][selectedCol] == -1) {
                System.out.println("Game Over!!");
                break;
            } else {
                revealCell(selectedRow, selectedCol);

                if (isGameWon()) {
                    printMinefield();
                    System.out.println("Oyunu Kazandınız!");
                    break;
                }
            }
        }
    }

    public void revealCell(int row, int col) {
        if (!revealed[row][col]) {
            revealed[row][col] = true;

            if (minefield[row][col] == 0) {
                // Eğer seçilen hücrede mayın yoksa, etrafındaki hücreleri de kontrol et.
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (i >= 0 && i < rows && j >= 0 && j < columns) {
                            revealCell(i, j);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MineSweeper game = new MineSweeper(3, 3, 2);
        game.playGame();
    }
}

