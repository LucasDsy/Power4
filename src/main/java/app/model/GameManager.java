package model;

public class GameManager {
    private static GameManager INSTANCE = null;
    public int matrice[][];

    private GameManager() {
        for (int i = 0; i < 6; i++) { // 6 rows
            for (int j = 0; i < 7; j++) { // 7 columns
                matrice[i][j] = 0;
            }
        }
    }

    public GameManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameManager();
        }

        return INSTANCE;
    }

    void controlWin() {
        for (int elem : matrice) {
            System.out.println(elem);
        }
    }
}