package com.practice19.services;

import com.practice19.models.entities.Item;
import com.practice19.models.repositories.ItemsRepository;
import com.practice19.models.services.EmailService;
import com.practice19.models.services.ItemsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItemsServiceTest {
    @Mock
    private ItemsRepository itemsRepository;

    @Mock
    private EmailService emailService;

    @Captor
    private ArgumentCaptor<Item> argumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> idCaptor;

    @Test
    void getAllItems(){
        Item item = new Item();
        item.setCreation_date(Date.valueOf("2020-05-04"));
        item.setPrice(4442);
        item.setName("TestItem");
        item.setOrder_id(1);

        Item item2 = new Item();
        item2.setCreation_date(Date.valueOf("2020-03-07"));
        item2.setPrice(5553);
        item2.setName("TestItemTwo");
        item2.setOrder_id(1);

        Mockito.when(itemsRepository.findAll()).thenReturn(List.of(item, item2));
        ItemsService itemsService = new ItemsService(itemsRepository, emailService);
        assertEquals(2, itemsService.getAll().size());
        assertEquals("TestItemTwo", itemsService.getAll().get(1).getName());
    }

    @Test
    void save(){
        ItemsService itemsService = new ItemsService(itemsRepository, emailService);
        itemsService.save(new Item("TestItem", Date.valueOf("2020-05-04"), 4442));
        Mockito.verify(itemsRepository).save(argumentCaptor.capture());
        Item captured = argumentCaptor.getValue();
        assertEquals("TestItem", captured.getName());
        assertEquals("2020-05-04", captured.getCreation_date().toString());
    }

    @Test
    void delete(){
        ItemsService itemsService = new ItemsService(itemsRepository, emailService);
        Item item = new Item();
        item.setId(2);
        item.setCreation_date(Date.valueOf("2020-05-04"));
        item.setPrice(4442);
        item.setName("TestItem");
        itemsService.save(item);
        itemsService.delete(2);
        Mockito.verify(itemsRepository).deleteById(idCaptor.capture());
        int captured = idCaptor.getValue();
        assertEquals(2, captured);
    }
}
