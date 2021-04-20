package au.com.nab.smartchoice.productpriceservice.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "au.com.nab.smartchoice.productpriceservice.feignclient")
public class OpenFeignConfiguration {
}
