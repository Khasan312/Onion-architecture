package com.example.onionarchitecture.domain.favorites;

import com.example.onionarchitecture.domain.details.Detail;

import java.util.UUID;

public interface Favorites {
    void add(Favorite favorite);
    void update(Favorite favorite);

    void remove(Favorite favorite);
    Long countByDetailAndUserId(Detail detail, Long userId);
    Favorite getByDetailAndUserId(Detail detail, Long userId);
}
