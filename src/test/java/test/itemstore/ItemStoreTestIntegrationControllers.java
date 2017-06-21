package test.itemstore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.itemstore.configuration.BeanConfigurator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by xnx_ on 21.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ItemStoreTestIntegrationControllers {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testSearchBookRequest() throws Exception {
        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk());

    }
}
