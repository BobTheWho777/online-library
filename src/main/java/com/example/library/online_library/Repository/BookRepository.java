package com.example.library.online_library.Repository;

import com.example.library.online_library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
