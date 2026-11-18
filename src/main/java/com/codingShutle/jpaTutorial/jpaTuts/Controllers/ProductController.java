package com.codingShutle.jpaTutorial.jpaTuts.Controllers;

import com.codingShutle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingShutle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final int PAGE_SIZE = 5;
    @Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "") String title,
                                              @RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber)
    {

        return productRepository.findByTitleContainingIgnoreCase(title,PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(Sort.Order.desc(sortBy))));
        //return productRepository.findByTitleOrderByPrice("Mazza");
        //return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price")); // sort in desc first by sortBy attribute if 2 of same then sort by price
//        return productRepository.findBy(Sort.by(
//                                        Sort.Order.desc(sortBy),
//                                        Sort.Order.asc("title")
//        ));

//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Order.desc(sortBy)));
//        return productRepository.findAll(pageable).getContent();
    }


 }
