package com.itmuch.mycontentcenter.feignclient;

import com.itmuch.mycontentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name = "my-user-center", configuration = UserCenterFeignConfiguration.class)
@FeignClient(name = "my-user-center" //,
// fallback fallbackFactory只能有一个
//        fallback = UserCenterFeignClientFallback.class,
//        fallbackFactory = UserCenterFeignClientFallbackFactory.class
        )
public interface UserCenterFeignClient {

    /**
     * http://my-user-center/users/{id}
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id, @RequestHeader("X-Token")String token);
}



