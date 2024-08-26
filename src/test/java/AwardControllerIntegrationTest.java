import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.golden.raspberry.awards.goldenraspberryawards.GoldenraspberryawardsApplication;

@SpringBootTest(classes = GoldenraspberryawardsApplication.class)
@AutoConfigureMockMvc
public class AwardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetIntervals() throws Exception {
        mockMvc.perform(get("/api/awards/intervals"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.min").isArray())   
               .andExpect(jsonPath("$.max").isArray())  
               .andExpect(jsonPath("$.min[0].producer").exists())  
               .andExpect(jsonPath("$.max[0].producer").exists()); 
    }
}
