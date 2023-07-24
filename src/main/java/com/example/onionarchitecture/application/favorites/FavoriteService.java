package com.example.onionarchitecture.application.favorites;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.details.Details;
import com.example.onionarchitecture.domain.favorites.Favorite;
import com.example.onionarchitecture.domain.favorites.Favorites;

import java.util.UUID;

public class FavoriteService {
    private final Details details;
    private final Favorites favorites;

    public FavoriteService(Details details, Favorites favorites) {
        this.details = details;
        this.favorites = favorites;
    }

    public void addToFavorites(UUID uuid, Long userId) {
        Detail detail = this.details.getByUuid(uuid);
        if (this.favorites.countByDetailAndUserId(detail, userId) > 0) {
            Favorite favorite = this.favorites.getByDetailAndUserId(detail, userId);
            this.favorites.remove(favorite);
        }
        this.favorites.add(new Favorite(detail, userId));
    }
}
