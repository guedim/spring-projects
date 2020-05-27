package com.guedim.wiremock.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guedim.wiremock.clients.ConfigurationFeignClient;
import com.guedim.wiremock.model.MerchantConfigResponse;
import com.guedim.wiremock.utils.ProcessUtils;

public class ConfigurationFeignClientTestIT extends AbstractClientConfigurationIT {

	
    @Autowired
    private ConfigurationFeignClient client;
    

    @Test
    public void createSome() {
    	List<MerchantConfigResponse>  configs = client.getConfigs(2);
 		assertThat(configs).isNotNull();
 		assertThat(configs).isNotEmpty();
 		assertThat(configs.size()).isEqualTo(3);
 		assertThat(ProcessUtils.getFraudConfiguration(configs)).isTrue();
 		assertThat(ProcessUtils.getWebHookConfiguration(configs)).isTrue();
 		assertThat(ProcessUtils.getUrlNotification(configs)).isNotBlank();
    }
}