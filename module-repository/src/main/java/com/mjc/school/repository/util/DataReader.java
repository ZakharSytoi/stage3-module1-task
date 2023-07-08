package com.mjc.school.repository.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static List<String> read(File path) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null)
                data.add(line);
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception while reading from " + path);
        }
        return data;
    }
}
