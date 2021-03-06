package com.denis.springproject.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN(Set.of(Permission.READ, Permission.WRITE)),
    USER(Set.of(Permission.READ)),
    PATIENT(Set.of(Permission.READ)),
    NURSE(Set.of(Permission.READ)),
    DOCTOR(Set.of(Permission.READ));

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthority(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
