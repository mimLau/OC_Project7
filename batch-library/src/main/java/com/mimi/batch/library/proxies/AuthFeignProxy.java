package com.mimi.batch.library.proxies;

import com.mimi.batch.library.model.UserBatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "authentication-library", url = "localhost:9090" )
public interface AuthFeignProxy {

    @PostMapping("/login")
    String login(@RequestBody UserBatch userBatch);
}
