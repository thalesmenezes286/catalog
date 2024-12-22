package com.dev.catalogapi.services;

import com.dev.catalogapi.dto.ProductDTO;
import com.dev.catalogapi.entities.Product;
import com.dev.catalogapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new Exception("Recurso não encontrado"));

        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String name, Pageable pageable) {
        Page<Product> result = productRepository.searchByName(name, pageable);

        return result.map(x -> new ProductDTO(x));
    }
}
