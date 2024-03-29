package com.example.onionarchitecture.infrastructure.details.controllers;

import com.example.onionarchitecture.application.details.*;
import com.example.onionarchitecture.application.favorites.FavoriteService;
import com.example.onionarchitecture.infrastructure.details.controllers.requests.CreateDetailRequest;
import com.example.onionarchitecture.infrastructure.details.controllers.requests.UpdateDetailRequest;
import com.example.onionarchitecture.infrastructure.details.controllers.responses.DetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/details")
public class DetailController {
    private final CreateDetailService createDetailService;
    private final DetailListService detailListService;
    private final UpdateDetailService updateDetailService;
    private final FavoriteService favoriteService;
    private final DetailInfoService detailInfoService;

    public DetailController(CreateDetailService createDetailService,
                            DetailListService detailListService,
                            UpdateDetailService updateDetailService,
                            FavoriteService favoriteService,
                            DetailInfoService detailInfoService) {
        this.createDetailService = createDetailService;
        this.detailListService = detailListService;
        this.updateDetailService = updateDetailService;
        this.favoriteService = favoriteService;
        this.detailInfoService = detailInfoService;
    }

    @PostMapping("/add")
    public ResponseEntity<DetailResponse> createDetail(
            @RequestBody CreateDetailRequest request) {
        DetailInfo detailInfo = new DetailInfo(
                request.brand,
                request.model,
                request.description,
                request.quantity,
                request.inStock,
                request.outOfStock,
                request.price,
                request.year,
                request.deleted);
        CreateDetailInput dto = new CreateDetailInput(detailInfo);
        DetailResult detailResult = this.createDetailService.createDetail(dto);
        return new ResponseEntity<>(DetailResponse.fromDetailResult(detailResult), HttpStatus.CREATED);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<DetailResponse> updateDetail(
        @RequestBody UpdateDetailRequest request,
        @PathVariable("uuid") UUID uuid
//        @PathVariable("userId") Long userId
    ) {
        DetailInfo detailInfo = new DetailInfo(
                request.brand,
                request.model,
                request.description,
                request.quantity,
                request.inStock,
                request.outOfStock,
                request.price,
                request.year,
                request.deleted);
        UpdateDetailInput dto = new UpdateDetailInput(uuid, detailInfo);
        DetailResult detailResult = this.updateDetailService.updateDetail(dto);
        return new ResponseEntity<>(DetailResponse.fromDetailResult(detailResult), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DetailResponse> getDetailByUuid(@PathVariable("uuid") UUID uuid,
                                                          @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(DetailResponse.fromDetailResult(
                this.detailInfoService.getDetailByUuid(uuid, userId)), HttpStatus.OK);
    }
}
