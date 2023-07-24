package com.example.onionarchitecture.domain.favorites;

import com.example.onionarchitecture.domain.details.Detail;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "detail_id")
    private Detail detail;
    private Long userId;

    public Favorite() {}

    public Favorite(Detail detail, Long userId) {
        this.detail = detail;
        this.userId = userId;
    }
}

