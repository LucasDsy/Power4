package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import app.Observable;
import app.Observer;

public class FileManager implements Observable {
    private final static String FILEPATH = "./scores.txt";
    private static FileManager INSTANCE = null;
    private List<Score> scoreList;
    private File file;
    private List<Observer> observers;

    private FileManager() {
        this.scoreList = new ArrayList<>();
        this.observers = new ArrayList<>();

        try {
            this.file = new File(FILEPATH);
            this.file.createNewFile();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.readInList();
    }

    public static FileManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileManager();
        }

        return INSTANCE;
    }

    /**
     * Ajoute ou remplace le score d'un utilisateur à la liste et update le fichier de persistence
     * @param username une String
     * @param score un integer
     */
    public void addScore(String username, int score) {
        int i = researchUsername(username);

        if (i > -1) {
            Score currentScore = scoreList.get(i);
            
            if (score > currentScore.getScore()) {
                currentScore.setScore(score);
            }

        } else {
            scoreList.add(new Score(username, score));
        }

        sortScoreList();
        writeFromList();
        notifyObservers();
    }

    /**
     * Recherche l'indice d'un username dans la liste
     * @param username une String
     * @return -1 si la recherche n'a pas abouti sinon l'index de l'objet
     */
    private int researchUsername(String username) {
        int i = 0;

        while (i < scoreList.size() && !scoreList.get(i).getUsername().equals(username)) {
            i++;
        }

        if (i >= scoreList.size()) {
            i = -1;
        }

        return i;
    }

    public List<Score> getScoreList() {
        sortScoreList();
        return this.scoreList;
    }

    private void writeFromList() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Score score : scoreList) {
                bufferedWriter.write(score.getUsername() + " " + String.valueOf(score.getScore()));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void readInList() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] components = line.split(" ");
                this.scoreList.add(new Score(components[0], components[1]));
            }

            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Trie la liste de scores en fonction du score par décroissance
     */
    private void sortScoreList() {
        this.scoreList.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.compareTo(o1);
            }
        });
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : this.observers) {
            o.update();
        }
    }
}