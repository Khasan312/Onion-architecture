package com.example.onionarchitecture.infrastructure.details.repositories;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.favorites.Favorite;
import com.example.onionarchitecture.domain.favorites.Favorites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class FavoriteRepository implements Favorites {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(Favorite favorite) {
        this.entityManager.persist(favorite);
        this.entityManager.flush();
    }

    @Override
    public void update(Favorite favorite) {
        this.entityManager.persist(favorite);
        this.entityManager.flush();
    }

    @Override
    public void remove(Favorite favorite) {
        this.entityManager.remove(favorite);
    }

    @Override
    public Long countByDetailAndUserId(Detail detail, Long userId) {
        return this.entityManager
                .createQuery(
                        "SELECT COUNT(f) FROM Favorite f " +
                                "WHERE f.detail = :detail AND f.userId = :userId",
                Long.class)
                .setParameter("detail", detail)
                .getSingleResult();
    }

    @Override
    public Favorite getByDetailAndUserId(Detail detail, Long userId) {
        return this.entityManager.createQuery(
                "SELECT f FROM Favorite f " +
                        "WHERE f.detail = :detail AND f.userId = :userId",
                Favorite.class)
                .setParameter("detail", detail)
                .setParameter("userId", userId)
                .getSingleResult();

    }
}
