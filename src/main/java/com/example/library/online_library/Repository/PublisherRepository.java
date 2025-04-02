package com.example.library.online_library.Repository;

import com.example.library.online_library.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
