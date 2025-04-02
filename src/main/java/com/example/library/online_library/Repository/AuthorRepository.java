package com.example.library.online_library.Repository;

import com.example.library.online_library.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
