package com.assignment.rishita.ecommerce_api;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest 
@DataJpaTest
@WebMvcTest
public class WatchRepositoryIntegrationTest {
    
    @Autowired
    private WatchRepository watchRepository;
   
    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        List<Watch> watches = (List<Watch>) watchRepository.findAll();
        
        assertThat(watches.size()).isEqualTo(4);
    }    
}