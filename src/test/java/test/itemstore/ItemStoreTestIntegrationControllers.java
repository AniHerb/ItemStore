package test.itemstore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.itemstore.configuration.BeanConfigurator;
import ua.itemstore.controllers.Some;
import ua.itemstore.controllers.SomeImpl;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @Autowired
    private Some some;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/getBookByID?id=10000000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":10000000,\"name\":\"init_name\",\"date\":1493672400000,\"autuhors\":\"init_authors\",\"iosn\":\"{}\"}")));
    }

    @Test
    public void createBookFromJOSON() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/createBook/{\"id\":999999999}").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void someTest(){
        Some mock = mock(Some.class);
       _testSome(some);
    }

    private void _testSome(Some some){
        when(some.text()).thenReturn("Hello").thenReturn("World");
        Assert.assertEquals("Hello",some.text());
    }


}
