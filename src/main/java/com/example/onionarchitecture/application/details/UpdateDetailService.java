package com.example.onionarchitecture.application.details;

import com.example.onionarchitecture.domain.details.Detail;
import com.example.onionarchitecture.domain.details.Details;

public class UpdateDetailService {
    private final Details details;

    public UpdateDetailService(Details details) {
        this.details = details;
    }

    public DetailResult updateDetail(UpdateDetailInput input) {
        DetailInfo info = new DetailInfo(
                input.info().brand(),
                input.info().model(),
                input.info().description(),
                input.info().quantity(),
                input.info().isInStock(),
                input.info().isOutOfStock(),
                input.info().price(),
                input.info().year(),
                input.info().isDeleted()
        );
        Detail detail = new Detail(info);
        detail.updateInfo(info);
        this.details.update(detail);

        return DetailResult.from(detail);
    }
}
