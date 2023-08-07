package com.example.onionarchitecture.infrastructure.details.repositories;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.details.Details;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class DetailRepository implements Details {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Detail> getAllDetails() {
       return this.entityManager
               .createQuery("SELECT d FROM Detail d", Detail.class)
               .getResultList();
    }

    @Override
    public void add(Detail detail) {
        this.entityManager.persist(detail);
        this.entityManager.flush();
    }

    @Override
    public void update(Detail detail) {
        this.entityManager.merge(detail);
        this.entityManager.flush();
    }

    @Override
    public Detail getByUuid(UUID uuid) {
        return this.entityManager
                .createQuery("SELECT d from Detail d where d.uuid = :uuid", Detail.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    @Override
    public void removeDetail(UUID uuid) {
        this.entityManager.createQuery(
                "DELETE FROM Detail d where d.uuid = :uuid"
        ).setParameter("uuid", uuid).executeUpdate();
    }
}
