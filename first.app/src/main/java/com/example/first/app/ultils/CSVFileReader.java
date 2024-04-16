package com.example.first.app.ultils;

import com.example.first.app.model.Book;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;
@Component
@Qualifier("csvFileReader") // dat ten

public class CSVFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String path) {
        System.out.println("Doc file CSV");

        try {
            // Tạo đối tượng CSVReader từ FileReader
            CSVReader reader = new CSVReader(new FileReader(Paths.get(path).toFile()));

            // Đọc các hàng từ tệp CSV
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine chứa các giá trị của một hàng
                for (String cell : nextLine) {
                    System.out.print(cell + ", "); // In giá trị của mỗi ô
                }
                System.out.println(); // Xuống dòng cho hàng mới
            }

            // Đóng đối tượng CSVReader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return List.of();
    }
}
