package com.example.onionarchitecture.application.details;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.details.Details;
import com.example.onionarchitecture.domain.favorites.Favorites;

public class CreateDetailService {
    private final Details details;

    public CreateDetailService(Details details) {
        this.details = details;
    }

    public DetailResult createDetail(CreateDetailInput input) {
        DetailInfo info = new DetailInfo(input.info().brand(),
                input.info().model(),
                input.info().description(),
                input.info().quantity(),
                input.info().isInStock(),
                input.info().isOutOfStock(),
                input.info().price(),
                input.info().year(),
                input.info().isDeleted());

        Detail detail = new Detail(info);
        this.details.add(detail);

        return DetailResult.from(detail);
    }
}
