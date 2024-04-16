package com.example.first.app.ultils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.first.app.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
@Qualifier("jsonFileReader") // dat ten
@Component
//@Primary // ưu tiên
public class JSONFileReader implements IFileReader {


    @Override
    public List<Book> readFile(String path) {
        System.out.println("Đọc file JSON");
        ObjectMapper mapper = new ObjectMapper();
        try {

            // Đọc file JSON và chuyển đổi nó thành danh sách các đối tượng Book
            return mapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Book>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();  // Trả về danh sách trống nếu có lỗi
    }
}

