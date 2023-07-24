package com.example.onionarchitecture.application.details;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.details.Details;
import com.example.onionarchitecture.domain.favorites.Favorites;

import java.util.UUID;

public class InfoDetailService {
    private final Details details;
    private final Favorites favorites;

    public InfoDetailService(Details details, Favorites favorites) {
        this.details = details;
        this.favorites = favorites;
    }

    public DetailResult getDetail(UUID uuid, Long userId) {
        Detail detail = details.getByUuid(uuid);
        DetailResult detailResult = DetailResult.from(detail);

        if (this.favorites.countByDetailAndUserId(detail, userId) > 0) {
            detailResult.makeItFavorite();
        }

        return detailResult;
    }


}
