package com.usermanagment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "User_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "User_Email")
    private String userEmail;

    @Column(name = "Created_Date", updatable = false)
    @CreationTimestamp
    private LocalDate createData;// we Can Take @CreationTimeStamp Also For This

    @Column(name = "Update_Date", insertable = false)
    @UpdateTimestamp
    private LocalDate updateDate;

    @Column(name = "Is_Active_Switch")
    private Character isActive;


}
