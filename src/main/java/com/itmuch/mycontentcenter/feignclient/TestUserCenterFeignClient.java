package com.itmuch.mycontentcenter.feignclient;


import com.itmuch.mycontentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "my-user-center")
public interface TestUserCenterFeignClient {
    @GetMapping("/q")
    UserDTO query(@SpringQueryMap UserDTO userDTO);
}
