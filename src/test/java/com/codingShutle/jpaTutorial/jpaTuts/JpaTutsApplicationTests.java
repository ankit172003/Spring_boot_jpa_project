package com.codingShutle.jpaTutorial.jpaTuts;

import com.codingShutle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingShutle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaTutsApplicationTests {

    @Autowired
    private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){

        ProductEntity productEntitycreated = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(123.45))
                .quantity(12)
                .build();
        ProductEntity savedProductEntity = productRepository.save(productEntitycreated);
        System.out.println(savedProductEntity);
    }

    @Test
    void getRepository(){
        List<ProductEntity> list = productRepository.findAll();
        for (ProductEntity itr: list){
            System.out.println(itr);
        }
    }

    @Test
    void getByTitle()
    {
        List<ProductEntity> list1 = productRepository.findByTitleOrderByPrice("Pepsi");
        System.out.println(list1);
    }

    @Test
    void AfterDate()
    {
        List<ProductEntity> list1 = productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0,0));
        System.out.println(list1);
    }

    @Test
    void testLike(){
        System.out.println(productRepository.findByTitleContainingIgnoreCase("coca", null));
    }

    @Test
    void testQuery(){
        System.out.println(productRepository.findByTitleAndPrice("Coca cola", BigDecimal.valueOf(34.40)));
    }
}
