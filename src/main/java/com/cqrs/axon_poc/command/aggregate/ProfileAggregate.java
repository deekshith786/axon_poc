package com.cqrs.axon_poc.command.aggregate;

import com.cqrs.axon_poc.command.commands.AddAddressCommand;
import com.cqrs.axon_poc.command.commands.CreateProfileCommand;
import com.cqrs.axon_poc.command.events.AddAddressEvent;
import com.cqrs.axon_poc.command.events.ProfileCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Slf4j
@Aggregate
public class ProfileAggregate {

    @AggregateIdentifier
    private String Employee_Number;

    private String employeeCode;
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

    private String houseOrFlatNumber;
    private String street;
    private String area;
    private String locality;
    private String city;
    private String zipcode;
    private String state;
    private String country;
    private String mobileNumber;
    private String landlineNumber;


    public ProfileAggregate() {
    }

    @CommandHandler
    public ProfileAggregate(CreateProfileCommand createProfileCommand) {

        log.info("CreateProfileCommand received");
        ProfileCreatedEvent profileCreatedEvent = new ProfileCreatedEvent();
        BeanUtils.copyProperties(createProfileCommand, profileCreatedEvent);
        AggregateLifecycle.apply(profileCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProfileCreatedEvent profileCreatedEvent) {
        this.Employee_Number = profileCreatedEvent.getEmployee_Number();
        this.employeeCode = profileCreatedEvent.getEmployee_Code();
        this.First_Name = profileCreatedEvent.getFirst_Name();
        this.Middle_Name = profileCreatedEvent.getMiddle_Name();
        this.Last_Name = profileCreatedEvent.getLast_Name();
        this.Date_Of_Joining = profileCreatedEvent.getDate_Of_Joining();
        this.Email = profileCreatedEvent.getEmail();
        this.Date_Of_Birth = profileCreatedEvent.getDate_Of_Birth();
        this.Gender = profileCreatedEvent.getGender();
        this.Role = profileCreatedEvent.getRole();
        this.Job_Title = profileCreatedEvent.getJob_Title();
        this.Job_Role = profileCreatedEvent.getJob_Role();
        this.Client_Company = profileCreatedEvent.getClient_Company();
        this.Client_Company_Team = profileCreatedEvent.getClient_Company_Team();
        this.Client_Reporting_Manager = profileCreatedEvent.getClient_Reporting_Manager();
        this.Qualification = profileCreatedEvent.getQualification();
        this.Skill_Matrix = profileCreatedEvent.getSkill_Matrix();
        this.Status = profileCreatedEvent.getStatus();

    }
    @CommandHandler
    public ProfileAggregate(AddAddressCommand addAddressCommand) {

        log.info("AddAddressCommand received");
        log.info(addAddressCommand.toString());
        AddAddressEvent addAddressEvent = new AddAddressEvent();
        BeanUtils.copyProperties(addAddressCommand, addAddressEvent);
        AggregateLifecycle.apply(addAddressEvent);
    }

    @EventSourcingHandler
    public void addAddress(AddAddressEvent addAddressEvent) {
        this.Employee_Number = addAddressEvent.getEmployee_Number();
        this.employeeCode = addAddressEvent.getEmployeeCode();
        this.houseOrFlatNumber = addAddressEvent.getHouseOrFlatNumber();
        this.street = addAddressEvent.getStreet();
        this.area = addAddressEvent.getArea();
        this.locality = addAddressEvent.getLocality();
        this.city = addAddressEvent.getCity();
        this.zipcode = addAddressEvent.getZipcode();
        this.state = addAddressEvent.getState();
        this.country = addAddressEvent.getCountry();
        this.mobileNumber = addAddressEvent.getMobileNumber();
        this.landlineNumber = addAddressEvent.getLandlineNumber();
    }
//
//    @CommandHandler
//    public void deleteProfileCommand(DeleteProfileCommand deleteProfileCommand) {
//        log.info("ProfileDeleteEvent received");
//        ProfileDeleteEvent profileDeleteEvent = ProfileDeleteEvent.builder().id(deleteProfileCommand.getId()).build();
//        log.info("ProfileDeleteEvent = " + profileDeleteEvent);
//        AggregateLifecycle.apply(profileDeleteEvent);
//    }
//
//    @EventSourcingHandler
//    public void deleteProfile(ProfileDeleteEvent profileDeleteEvent) {
//        this.id = profileDeleteEvent.getId();
//    }
}
