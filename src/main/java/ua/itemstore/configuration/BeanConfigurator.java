package ua.itemstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.itemstore.controllers.BookController;
import ua.itemstore.controllers.BookControllerImpl;
import ua.itemstore.dao.ItemStoreDAO;
import ua.itemstore.dao.ItemStoreDAOImpl;
import ua.itemstore.services.ItemStoreService;
import ua.itemstore.services.ItemStoreServiceImpl;

/**
 * Created by xnx_ on 01.06.2017.
 */
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Import(value = ArchitectureConfiguaration.class)
public class BeanConfigurator {
    @Bean
    public BookController newBookController(){
        return new BookControllerImpl();
    }

    @Bean
    public ItemStoreService newItemStoreService(){
        return new ItemStoreServiceImpl();
    }

    @Bean
    public ItemStoreDAO newItemStoreDAO(){
        return new ItemStoreDAOImpl();
    }
}
