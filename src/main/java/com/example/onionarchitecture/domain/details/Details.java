package com.example.onionarchitecture.domain.details;

import java.util.List;
import java.util.UUID;

public interface Details {

    List<Detail> getAllDetails();

    void add(Detail detail);
    void update(Detail detail);
    Detail getByUuid(UUID uuid);

    void removeDetail(UUID uuid);


}
