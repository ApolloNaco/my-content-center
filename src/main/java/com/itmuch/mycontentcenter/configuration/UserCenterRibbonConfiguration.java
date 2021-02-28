package com.itmuch.mycontentcenter.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;

@Configuration
@RibbonClient(name = "my-user-center",configuration = RibbonConfiguration.class)
public class UserCenterRibbonConfiguration {
}
