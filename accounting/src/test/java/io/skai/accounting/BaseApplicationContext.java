package io.skai.accounting;

import io.skai.accounting.repository.BrandRepository;
import io.skai.accounting.repository.ClientRepository;
import io.skai.accounting.repository.ModelRepository;
import io.skai.accounting.service.RepairService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BaseApplicationContext {
    @Autowired
    protected DSLContext dslContext;
    @Autowired
    protected BrandRepository brandRepository;
    @Autowired
    protected ClientRepository clientRepository;
    @Autowired
    protected ModelRepository modelRepository;
    @Autowired
    protected RepairService repairService;

}
