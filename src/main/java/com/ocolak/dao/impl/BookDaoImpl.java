package com.ocolak.dao.impl;

import com.ocolak.entity.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BookDaoImpl extends GenericDaoImpl<Integer, Book> {
    @PersistenceContext(unitName = "persistence-unit")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}