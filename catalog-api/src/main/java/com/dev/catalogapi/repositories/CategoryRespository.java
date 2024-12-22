package com.dev.catalogapi.repositories;

import com.dev.catalogapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
