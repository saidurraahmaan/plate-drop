package com.s4r.api.model.response;

import com.s4r.domain.enums.Role;
import com.s4r.domain.user.UserDTO;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Role role;

    public static UserResponse ofDTO(UserDTO dto) {
        var result =  new UserResponse();
        result.setId(dto.getId());
        result.setEmail(dto.getEmail());
        result.setName(dto.getName());
        result.setPhoneNumber(dto.getPhoneNumber());
        result.setAddress(dto.getAddress());
        result.setRole(dto.getRole());

        return result;
    }


    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email, String phoneNumber,
                        String address, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
