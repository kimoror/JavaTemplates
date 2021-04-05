package com.example.practice12;

import org.springframework.context.annotation.Bean;

import java.io.*;

public class MyFile {
    private File file;
    StringBuffer valueOfFile;
    FileReader reader;
    FileWriter writer;

    public MyFile(String filePath) {
        file = new File(filePath);
        valueOfFile = new StringBuffer();
    }

    public boolean fileIfNull() {

        return file.exists() && file.isFile();
    }

    public int hashFile() throws IOException {
        reader = new FileReader(file);
        int c;
        while ((c = reader.read()) != -1) {
            valueOfFile.append((char) c);
        }
        reader.close();
        return valueOfFile.substring(0).hashCode();
    }

    public void writeHash(int hash) throws IOException {
        writer = new FileWriter(file);
        valueOfFile.append(hash);
        writer.write(valueOfFile.substring(0));
        writer.close();
    }

    public void writeNull() throws IOException {
        writer = new FileWriter(file);
        valueOfFile.append("null");
        writer.write(valueOfFile.substring(0));
        writer.close();
    }

    public void deleteFile() {
        file.deleteOnExit();
    }
}
