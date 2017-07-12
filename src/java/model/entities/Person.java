package model.entities;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 * @author james chalmers Open University F6418079
 */
public class Person {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "MobileNo")
    private String mobileNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "HomePhoneNumber")
    private String homePhoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOfBirth")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;

    public Person() {
    }

    public Person(String title, String firstName, String surname, String mobileNo, String homePhoneNumber, String emailAddress, Date dateOfBirth) {
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.mobileNo = mobileNo;
        this.homePhoneNumber = homePhoneNumber;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getSurname() {
        return surname;
    }

    public String getTitle() {
        return title;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
