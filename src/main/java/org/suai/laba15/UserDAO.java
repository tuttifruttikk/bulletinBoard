package org.suai.laba15;

import java.io.*;
import java.util.HashMap;

public class UserDAO {
    private File file;

    public UserDAO(String path) {
        file = new File(path);
    }

    public synchronized HashMap<String, String> loadFile() {
        HashMap<String, String> users = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String login = reader.readLine();
            String password = reader.readLine();

            while (login != null) {
                users.put(login, password);
                login = reader.readLine();
                password = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public synchronized void saveToFile(HashMap<String, String> users) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (HashMap.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + "\n");
                writer.write(entry.getValue() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
