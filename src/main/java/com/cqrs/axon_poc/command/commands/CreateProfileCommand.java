package com.cqrs.axon_poc.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * this class {@link CreateProfileCommand} commands and event will be having the state(payload) of what we are going to do
 */
@Data
@Builder
public class CreateProfileCommand {

    @TargetAggregateIdentifier
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
