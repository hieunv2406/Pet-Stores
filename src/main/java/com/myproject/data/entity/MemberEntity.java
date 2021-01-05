package com.myproject.data.entity;

import com.myproject.data.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "MEMBER")
public class MemberEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constant.SEQUENCE_KEY.EMPLOYEE)
//    @SequenceGenerator(name = Constant.SEQUENCE_KEY.EMPLOYEE, sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IDENTITY_CARD")
    private String identityCard;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "STATUS")
    private String status;

    public MemberDTO toDto() {
        return new MemberDTO(
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
