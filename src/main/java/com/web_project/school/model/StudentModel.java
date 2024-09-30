package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID Id;
    @Size(min = 3, message = "name size error")
    private String Name;
    @Size(min = 3, message = "firstname size error")
    private String FirstName;
    @Nullable
    private String LastName;
    @Nullable
    @Email(message = "not email")
    private String CorpEmail;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "pasport_id")
    private PasportModel pasport;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityModel university;

    @ManyToMany
    @JoinTable(name = "student_holiday",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "holiday_id"))
    private List<HolidayModel> holidays;



    public StudentModel(){

    }


    public StudentModel(UUID id, String name, String firstName, @Nullable String lastName, @Nullable String corpEmail, PasportModel pasport, UniversityModel university, List<HolidayModel> holidays) {
        Id = id;
        Name = name;
        FirstName = firstName;
        LastName = lastName;
        CorpEmail = corpEmail;
        this.pasport = pasport;
        this.university = university;
        this.holidays = holidays;
    }


    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public @Size(min = 3, message = "name size error") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "name size error") String name) {
        Name = name;
    }

    public @Size(min = 3, message = "firstname size error") String getFirstName() {
        return FirstName;
    }

    public void setFirstName(@Size(min = 3, message = "firstname size error") String firstName) {
        FirstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(@Nullable String lastName) {
        LastName = lastName;
    }

    @Nullable
    public @Email(message = "not email") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable @Email(message = "not email") String corpEmail) {
        CorpEmail = corpEmail;
    }

    public PasportModel getPasport() {
        return pasport;
    }

    public void setPasport(PasportModel pasport) {
        this.pasport = pasport;
    }

    public UniversityModel getUniversity() {
        return university;
    }

    public void setUniversity(UniversityModel university) {
        this.university = university;
    }

    public List<HolidayModel> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<HolidayModel> holidays) {
        this.holidays = holidays;
    }
}
