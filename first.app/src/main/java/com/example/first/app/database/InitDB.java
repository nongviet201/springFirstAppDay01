package com.example.first.app.database;

import com.example.first.app.model.Book;
import com.example.first.app.ultils.IFileReader;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;

@Configuration // vừa khởi động thì chạy dữ liệu *Bean
public class InitDB implements CommandLineRunner {
    @Qualifier("csvFileReader") // goi doi tuong muon lua chon uu tien
    @Autowired
    public IFileReader iFileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("khởi tạo dữ liệu");
//        BookDB.books = iFileReader.readFile("H:/java23 Techmaster/JavaSpring/SpringBoot/day_02/first.app/src/main/java/com/example/first/app/database/MOCK_DATA.json");
//
//        // In ra danh sách các sách
//        for (Book book : BookDB.books) {
//            System.out.println(book);
//        }
//
//        System.out.println("Số lượng sách: " + BookDB.books.size());

    // CSV

        BookDB.books = iFileReader.readFile("H:/java23 Techmaster/JavaSpring/SpringBoot/day_02/first.app/src/main/java/com/example/first/app/database/MOCK_DATA.csv");
        for (Book book : BookDB.books) {
            System.out.println(book);
        }

        // Exel
//        BookDB.books = iFileReader.readFile("H:/java23 Techmaster/JavaSpring/SpringBoot/day_02/first.app/src/main/java/com/example/first/app/database/MOCK_DATA.xlsx");
//        for (Book book : BookDB.books) {
//            System.out.println(book);
//        }
    }
}
