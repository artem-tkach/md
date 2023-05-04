package io.skai.accounting.service.impl;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.skai.accounting.AccountingApplication;
import io.skai.accounting.BaseApplicationContext;
import io.skai.accounting.feign.WarehouseClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WireMockTest(httpPort = 8082)
class RepairServiceImplTest {

    @Autowired
    private WarehouseClient warehouseClient;

    //private WireMockServer wireMockServer = new WireMockServer();

    @Test
    void shouldCreateNewRepair(WireMockRuntimeInfo wmRuntimeInfo) {
        //wireMockServer.start();

        //configureFor("localhost", 8082);
        Map<Long, Integer> components = Map.of(1L, 1, 2L, 1);
        stubFor(WireMock
                .put("/component")
                //.withRequestBody(equalTo(components.toString()))
                .withHost(equalTo("localhost"))
                .willReturn(aResponse()
                        .withBody("TRUE")
                        .withStatus(200)));

        var result = warehouseClient.writeComponents(components);

        assertThat(result).isTrue();
        //wireMockServer.stop();
    }
}