package utils;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class User {
    Fairy fairy;
    Person person;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String ssn;
    String username;
    String password;

    public User(){
        fairy = Fairy.create();
        person = fairy.person();

        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress().getAddressLine1();
        this.city = person.getAddress().getCity();
        this.state = "United States";
        this.zip = person.getAddress().getPostalCode();
        this.phone = person.getTelephoneNumber();
        this.ssn = person.getNationalIdentityCardNumber();
        this.username = person.getUsername();
        this.password = person.getPassword();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getSsn() {
        return ssn;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
