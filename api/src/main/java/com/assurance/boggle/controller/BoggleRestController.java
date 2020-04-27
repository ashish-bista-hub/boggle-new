package com.assurance.boggle.controller;

import com.assurance.boggle.entity.BoggleDto;
import com.assurance.boggle.service.BoggleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(value = "/api/v1", produces = "application/json", consumes = "application/json")
public class BoggleRestController {

    @Autowired
    private BoggleService boggleService;

    @ApiOperation(value = "Get 4 x 4 matrix for boggle game", response = ResponseEntity.class)
    @GetMapping("/boggle")
    public ResponseEntity<BoggleDto> getBoggleMatrix() {
        return new ResponseEntity<>(boggleService.getBoggle(), HttpStatus.OK);
    }
}
