package com.example.labcomdemo.Models;

public class ContactsModel {

   String phoneNumber,emailAddress,contactName;
   int gender;


    public ContactsModel(String phoneNumber, String emailAddress, String contactName, int gender) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.contactName = contactName;
        this.gender = gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
