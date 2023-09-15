package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String[] lines = sb.toString().split("\n");
            for (int i = 0; i < lines.length; i++) {
                line = lines[i];
                lines[i] = line.substring(line.indexOf(':') + 1).trim();
            }
            String name = lines[0];
            int age = Integer.parseInt(lines[1]);
            String email = lines[2];
            Long phone = Long.parseLong(lines[3]);

            profile = new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new MyIOException();
        }
        return profile;
    }
}
