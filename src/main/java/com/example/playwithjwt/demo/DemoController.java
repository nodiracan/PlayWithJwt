package com.example.playwithjwt.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Helloo from secury endpoint");
    }

}
