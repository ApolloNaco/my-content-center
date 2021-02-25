package com.itmuch.mycontentcenter.service.content;


import com.itmuch.mycontentcenter.dao.content.ShareMapper;
import com.itmuch.mycontentcenter.domain.dto.content.ShareDTO;
import com.itmuch.mycontentcenter.domain.dto.user.UserDTO;
import com.itmuch.mycontentcenter.domain.entity.content.Share;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper;

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;


    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

        // 用户中心所有实例的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("my-user-center");
        String targetURL = instances.stream()
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("当前没有实例!"));

        log.info("请求的目标地址:{}", targetURL);
        UserDTO userDTO = this.restTemplate.getForEntity(targetURL, UserDTO.class, 1).getBody();
        // 消息的装配
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        // 用HTTP GET方法去请求，并返回一个对象
        ResponseEntity<UserDTO> forEntity = restTemplate.getForEntity("http://localhost:8081/users/{id}", UserDTO.class, 1);
        System.out.println(forEntity.getBody());
        // 200 OK
        System.out.println(forEntity.getStatusCode());
    }


}

