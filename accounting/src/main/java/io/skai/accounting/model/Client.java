package io.skai.accounting.model;

import lombok.Builder;

@Builder
public record Client(Long id, String name, String email) {
}
