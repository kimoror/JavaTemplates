package com.practice19.models.entities;

public enum Permission {
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");

    private final String permission;

    /**
     * Constructor for Permission enum
     * @param permission - permission of role
     */
    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
