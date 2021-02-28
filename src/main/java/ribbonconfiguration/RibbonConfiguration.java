package ribbonconfiguration;


import com.itmuch.mycontentcenter.configuration.NacosSameClusterWeightedRule;
import com.itmuch.mycontentcenter.configuration.NacosWeightedRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cgy
 */
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRole(){
        return new NacosSameClusterWeightedRule();
    }

//    @Bean
//    public IPing ping(){
//        return new PingUrl();
//    }
}
