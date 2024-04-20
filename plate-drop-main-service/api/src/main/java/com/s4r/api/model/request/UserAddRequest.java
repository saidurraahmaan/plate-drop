package com.s4r.api.model.request;

import com.s4r.domain.enums.Role;
import com.s4r.domain.user.UserDTO;
import jakarta.validation.constraints.NotNull;

public class UserAddRequest {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
    private String address;
    @NotNull
    private Role role;


    public static UserDTO toDto(UserAddRequest request) {

        return new UserDTO(request.getId(), request.getName(),
                request.getEmail(), request.getPhoneNumber(),
                request.getAddress(), request.getPassword(),
                request.getRole());
    }

    public UserAddRequest() {
    }

    public UserAddRequest(Long id, String name, String email, String phoneNumber, String password, String address, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
