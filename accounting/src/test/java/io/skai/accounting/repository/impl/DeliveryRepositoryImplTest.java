package io.skai.accounting.repository.impl;

import io.skai.accounting.BaseApplicationContext;
import io.skai.accounting.dto.delivery.DeliveryRequestDto;
import io.skai.accounting.enums.UserRole;
import io.skai.accounting.jooq.tables.pojos.Delivery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static io.skai.accounting.jooq.Tables.DELIVERY;
import static io.skai.accounting.jooq.Tables.USER;
import static org.assertj.core.api.Assertions.assertThat;

class DeliveryRepositoryImplTest extends BaseApplicationContext {

    private final static DeliveryRequestDto INPUT_DATA = getInputData();
    private final static Delivery EXPECTED = new Delivery(1L, LocalDateTime.now(), INPUT_DATA.orderId(), INPUT_DATA.managerId(), INPUT_DATA.sum(), INPUT_DATA.guid());

    @Test
    void shouldCreateNewDelivery() {
        Delivery result = deliveryRepository.findOrCreate(INPUT_DATA);
        assertThat(result.getId()).isEqualTo(EXPECTED.getId());
        assertThat(result.getManagerId()).isEqualTo(EXPECTED.getManagerId());
        assertThat(result.getOrderId()).isEqualTo(EXPECTED.getOrderId());
        assertThat(result.getGuid()).isEqualTo(EXPECTED.getGuid());
    }

    @Test
    void shouldReadDeliveryFromDB(){
        deliveryRepository.findOrCreate(INPUT_DATA);
        List<Delivery> result = deliveryRepository.getAll();
        assertThat(result).hasSize(1);
    }

    private static DeliveryRequestDto getInputData() {
        return new DeliveryRequestDto(1L, 1L, 450d, "some guid");
    }

    @BeforeEach
    void insertNecessaryData(){
        dslContext.insertInto(USER)
                .set(USER.ID, 1L)
                .set(USER.NAME, "Manager")
                .set(USER.ROLE, UserRole.MANAGER.getValue())
                .set(USER.EMAIL, "manager@organizatation.com")
                .execute();
    }

    @AfterEach
    void clearTables(){
        dslContext.truncate(DELIVERY).execute();
        dslContext.delete(USER).execute();
    }
}