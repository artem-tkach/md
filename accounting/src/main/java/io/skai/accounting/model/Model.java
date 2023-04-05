package io.skai.accounting.model;

import lombok.Builder;

@Builder
public record Model(Long id, String name, Brand brand) {
}
