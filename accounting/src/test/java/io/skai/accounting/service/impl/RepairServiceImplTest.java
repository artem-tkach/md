package io.skai.accounting.service.impl;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.skai.accounting.dto.repair.RepairRequestDto;
import io.skai.accounting.enums.RepairResult;
import io.skai.accounting.feign.WarehouseClient;
import io.skai.accounting.repository.RepairRepository;
import io.skai.accounting.service.RepairService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@WireMockTest(httpPort = 8082)
@ActiveProfiles("test")
class RepairServiceImplTest {

    @Autowired
    private RepairService repairService;

    @Autowired
    private WarehouseClient warehouseClient;

    @SpyBean
    private RepairRepository repairRepository;

    @Test
    void shouldCreateNewRepair() {
        RepairRequestDto inputData = getInputData();
        stubWarehouseComponentPutCall(Boolean.TRUE);
        Boolean result = warehouseClient.writeComponents(inputData.components());
        assertThat(result).isTrue();
        repairService.findOrCreate(inputData);
        verify(repairRepository).findOrCreate(inputData);
    }

    @Test
    void shouldNotCreateNewRepair() {
        RepairRequestDto inputData = getInputData();
        stubWarehouseComponentPutCall(Boolean.FALSE);

        repairService.findOrCreate(inputData);
        verify(repairRepository,times(0)).findOrCreate(inputData);
    }

    private RepairRequestDto getInputData(){
        return new RepairRequestDto(1L,1L, RepairResult.REPAIRED,300d,Map.of(1L, 1),
                "some comment", "some guid");
    }

    private void stubWarehouseComponentPutCall(Boolean response){
        stubFor(WireMock
                .put("/component")
                .withHost(equalTo("localhost"))
                .willReturn(aResponse()
                        .withHeader("Content-Type","application/json;charset=UTF-8")
                        .withBody(response.toString())
                        .withStatus(200)));
    }
}