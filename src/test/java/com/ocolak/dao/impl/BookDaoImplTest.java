package com.ocolak.dao.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ocolak.entity.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


public class BookDaoImplTest {

    private static BookDaoImpl dao;

    @BeforeAll
    public static void before() {
        dao = new BookDaoImpl();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-test");
        dao.em = emf.createEntityManager();
    }

    @Test
    public void findAll() {
        List<Book> lst = dao.findAll();
        assertThat(lst.size(), equalTo(1));
    }

    @Test
    public void getByField() {
        Book obj = dao.getByField("author", "Orson S. Card");
        assertThat(obj.getId(), equalTo(1));
    }

    @Test
    public void getById() {
        Book obj = dao.getById(1);
        assertThat(obj.getAuthor(), equalTo("Orson S. Card"));
    }
}