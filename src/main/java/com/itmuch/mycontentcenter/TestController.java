package com.itmuch.mycontentcenter;

import com.itmuch.mycontentcenter.dao.content.ShareMapper;
import com.itmuch.mycontentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private ShareMapper shareMapper;

    @GetMapping("/test")
    public List<Share> testInsert(){
        // 1.做插入
        Share share = new Share();
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("xxx");
        share.setCover("xxx");
        share.setAuthor("根源");
        share.setBuyCount(1);

        shareMapper.insertSelective(share);
        // 2.做查询:查询当前数据库所有的share
        List<Share> shares = shareMapper.selectAll();
        return shares;
    }
}
