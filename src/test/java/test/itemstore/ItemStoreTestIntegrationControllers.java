package test.itemstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.itemstore.configuration.BeanConfigurator;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by xnx_ on 21.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeanConfigurator.class)
@AutoConfigureMockMvc
public class ItemStoreTestIntegrationControllers {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void createBookFromJOSON() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/createBook/{\"id\":999999999}").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
