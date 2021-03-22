package com.example.practice12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class Program {
    MyFile firstFile;
    MyFile secondFile;

    @Autowired
    public Program(){

    }

    @PostConstruct
    public void prepareFirstFile() throws IOException{
        firstFile = new MyFile("C:\\Users\\Danila\\Google Диск\\Institute\\4-rd_semestr\\JavaTemplates\\practice12\\First1.txt");
        secondFile = new MyFile("C:\\Users\\Danila\\Google Диск\\Institute\\4-rd_semestr\\JavaTemplates\\practice12\\Second.txt");
        if(firstFile.fileIfNull())
            secondFile.writeNull();
        else
            secondFile.writeHash(firstFile.hashFile());
            System.out.println(firstFile.hashFile());

    }

    public void hashout() throws IOException {
        System.out.println(firstFile.hashFile());
    }

    @PreDestroy
    public void deleteFirstFile(){
        firstFile.deleteFile();
    }
}
