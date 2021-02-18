package com.itmuch.mycontentcenter.service.content;


import com.itmuch.mycontentcenter.dao.content.ShareMapper;
import com.itmuch.mycontentcenter.domain.dto.content.ShareDTO;
import com.itmuch.mycontentcenter.domain.dto.user.UserDTO;
import com.itmuch.mycontentcenter.domain.entity.content.Share;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper;

    private final RestTemplate restTemplate;


    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

        UserDTO userDTO = this.restTemplate.getForEntity("http://localhost:8081/users/{id}", UserDTO.class, 1).getBody();
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

