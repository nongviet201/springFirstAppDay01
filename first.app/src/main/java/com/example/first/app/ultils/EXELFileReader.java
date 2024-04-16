package com.example.first.app.ultils;

import com.example.first.app.model.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;
@Component
@Qualifier("exelFileReader") // dat ten

public class EXELFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String path) {
        System.out.println("Doc file Exel");
        try {
            // Tạo FileInputStream để đọc tệp Excel
            FileInputStream file = new FileInputStream(path);

            // Tạo đối tượng Workbook từ FileInputStream
            Workbook workbook = new XSSFWorkbook(file);

            // Lấy Sheet đầu tiên từ Workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Lặp qua các hàng trong Sheet và lấy các ô trong mỗi hàng
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // In nội dung của mỗi ô
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println(); // Xuống dòng cho hàng mới
            }

            // Đóng FileInputStream và Workbook
            file.close();
            workbook.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return List.of();
    }
}
