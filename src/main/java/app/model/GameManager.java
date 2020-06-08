package model;

public class GameManager {
    private static GameManager INSTANCE = null;
    public char matrice[][];

    private GameManager() {
        for (int i = 0; i < 6; i++) { // 6 lignes
            for (int j = 0; i < 7; j++) { // 7 colonnes
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
}