package com.cqrs.axon_poc.command.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The class {@link Profile} servers as a JPA entity to refer to the latest state of an arregate
 * and will be stored in the queue store
 */
@Entity
@Data
public class Profile {

    @Id
    private String Employee_Number;
    private String Employee_Code;
    private String First_Name;
    private String Middle_Name;
    private String Last_Name;
    private String Date_Of_Joining;
    private String Email;
    private String Date_Of_Birth;
    private String Gender;
    private String Role;
    private String Job_Title;
    private String Job_Role;
    private String Client_Company;
    private String Client_Company_Team;
    private String Client_Reporting_Manager;
    private String Qualification;
    private String Skill_Matrix;
    private String Status;
}
