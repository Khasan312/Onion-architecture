package com.example.onionarchitecture.application.details;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.details.Details;
import com.example.onionarchitecture.domain.favorites.Favorites;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class DetailListService {
    private final Details details;
    private final Favorites favorites;

    public DetailListService(Details details, Favorites favorites) {
        this.details = details;
        this.favorites = favorites;
    }

    public List<DetailResult> getAllDetails(DetailListInput input) {
        return this.details
                .getAllDetails()
                .stream()
                .map(detail -> DetailResult.from(detail))
                .collect(toList());
    }
}
