package com.cqrs.axon_poc.command.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileInput {

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
