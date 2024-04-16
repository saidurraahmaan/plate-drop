package com.s4r.domain.user;

import com.s4r.domain.enums.Role;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private Role role;

    public static UserDTO ofEntity(User user) {
        return new UserDTO(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getPassword(),
                user.getRole());
    }

    public static User toEntity(UserDTO dto) {
        var user = new User();
        if (user.getId() != null) {
            user.setId(dto.getId());
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(dto.getRole());

        if (user.getAddress() != null) {
            user.setAddress(dto.getAddress());
        }

        return user;
    }

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String phoneNumber,
                   String address, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

