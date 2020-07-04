package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {
    private final static String FILEPATH = "./scores.txt";
    public static FileManager INSTANCE = null;
    private HashMap<String, Integer> scoreHashMap;
    private File file;

    private FileManager() {
        this.scoreHashMap = new HashMap<>();
        
        try {
            this.file = new File(FILEPATH);
            this.file.createNewFile();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.readInHashMap();
    }

    public static FileManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileManager();
        }
        
        return INSTANCE;
    }

    public void addScore(String username, int score) {
        this.scoreHashMap.put(username, score);
        this.writeFromHashMap();
    }

    private void writeFromHashMap() {
        try { 
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (String key : this.scoreHashMap.keySet()) {
                Integer value = this.scoreHashMap.get(key);
                bufferedWriter.write(key + " " + String.valueOf(value));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void readInHashMap() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] components = line.split(" ");
                this.scoreHashMap.put(components[0], Integer.valueOf(components[1]));
            }

            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}