package com.dev.catalogapi.services;

import com.dev.catalogapi.dto.CategoryDTO;
import com.dev.catalogapi.entities.Category;
import com.dev.catalogapi.repositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = categoryRespository.findAll();

        return  result.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
