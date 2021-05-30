package com.practice19.models.services;

import com.practice19.aspect.Loggable;
import com.practice19.models.entities.Item;
import com.practice19.models.repositories.ItemFilterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ItemFilterService implements ItemFilterRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    @Loggable
    @Transactional
    public List<Item> findItemsByNameAndCreation_dateAndPriceAndOrder_id(String name, Date creation_date, double price, int order_id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = cb.createQuery(Item.class);
        Root<Item> itemRoot = itemCriteriaQuery.from(Item.class);

        ArrayList<Predicate> predicates = new ArrayList<>();
        if(name != null){
            predicates.add(cb.equal(itemRoot.get("name"), name));
        }
        if(creation_date != null){
            predicates.add(cb.equal(itemRoot.get("creation_date"), creation_date));
        }
        if(price != 0){
            predicates.add(cb.equal(itemRoot.get("price"),  price));
        }
        if(order_id != 0){
            predicates.add(cb.equal(itemRoot.get("order_id"),  order_id));
        }
        itemCriteriaQuery.where(predicates.toArray(new Predicate[0]));


//        itemCriteriaQuery.where(cb.equal(itemRoot.get("name"), name));

        return em.createQuery(itemCriteriaQuery).getResultList();

    }
}
