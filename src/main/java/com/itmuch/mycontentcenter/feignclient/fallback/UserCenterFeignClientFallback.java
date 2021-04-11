package com.itmuch.mycontentcenter.feignclient.fallback;

import com.itmuch.mycontentcenter.domain.dto.user.UserDTO;
import com.itmuch.mycontentcenter.feignclient.UserCenterFeignClient;
import org.springframework.stereotype.Component;

//@Component
//public class UserCenterFeignClientFallback implements UserCenterFeignClient {
//    @Override
//    public UserDTO findById(Integer id) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setWxNickname("一个默认用户");
//        return userDTO;
//    }
//}
