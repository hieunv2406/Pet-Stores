package com.myproject.data.dto;

import com.myproject.common.dto.BaseDTO;
import com.myproject.data.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredTypes()
public class MemberDTO extends BaseDTO {

    private Long userId;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String identityCard;
    private Date dateOfBirth;
    private String address;
    private String roleCode;
    private String status;

    private String statusStr;

    public MemberDTO(Long userId,
                     String username,
                     String password,
                     String fullName,
                     String phoneNumber,
                     String email,
                     String identityCard,
                     Date dateOfBirth,
                     String address,
                     String roleCode,
                     String status) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identityCard = identityCard;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.roleCode = roleCode;
        this.status = status;
    }

    public MemberEntity toEntity() {
        return new MemberEntity(
                userId,
                username,
                password,
                fullName,
                phoneNumber,
                email,
                identityCard,
                dateOfBirth,
                address,
                roleCode,
                status
        );
    }
}
