package com.example.module12methodbasedsecurity.security;

public class RolesHierarchyBuilder {

    private StringBuilder sb = new StringBuilder();

    public RolesHierarchyBuilder append(String upLineRole, String downLineRole) {
        sb.append(String.format("ROLE_%s > ROLE_%s \n", upLineRole, downLineRole));
        return this;
    }

    public String build() {
        return sb.toString();
    }
}
