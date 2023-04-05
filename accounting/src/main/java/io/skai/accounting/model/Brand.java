package io.skai.accounting.model;

import lombok.Builder;

@Builder
public record Brand(Long id, String name) {
}
