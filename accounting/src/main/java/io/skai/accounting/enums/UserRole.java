package io.skai.accounting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {
    ADMIN(1),
    MANAGER(2),
    MASTER(3);

    private final int value;
}



