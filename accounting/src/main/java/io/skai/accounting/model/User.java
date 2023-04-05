package io.skai.accounting.model;

import io.skai.accounting.enums.UserRole;
import lombok.Builder;

@Builder
public record User(Long id, String name, String email, String phone, String password, UserRole role) {
}
