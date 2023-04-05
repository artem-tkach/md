package io.skai.accounting.model;

import lombok.Builder;

@Builder
public record Order(Long id,
                    Model model,
                    Client client,
                    User manager,
                    String serialNumber,
                    String defect) {
}
