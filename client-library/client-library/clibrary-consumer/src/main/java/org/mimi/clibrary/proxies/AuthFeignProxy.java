package org.mimi.clibrary.proxies;

import org.mimi.clibrary.Beans.account.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "authentication-library", url = "localhost:9090" )
public interface AuthFeignProxy {

    @PostMapping("/login")
    String login( @RequestBody UserBean user );
}
