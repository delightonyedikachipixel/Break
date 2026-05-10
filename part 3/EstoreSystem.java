
enum ProductCategory {
    ELECTRONICS,
    GROCERIES,
    UTENSILS,
    CLOTHING
}

enum CardType {
    MASTER_CARD,
    VISA_CARD,
    VERVE,
    AMERICA_EXPRESS
}


class Address {
    private String city;
    private String country;
    private String houseNumber;
    private String street;
    private String state;

    public Address(String city, String country, String houseNumber, String street, String state) {
        this.city = city;
        this.country = country;
        this.houseNumber = houseNumber;
        this.street = street;
        this.state = state;
    }

    public String getCity() { return city; }
    public String getCountry() { return country; }
    public String getHouseNumber() { return houseNumber; }
    public String getStreet() { return street; }
    public String getState() { return state; }
}
class User {
    private int age;
    private String email;
    private Address homeAddress;
    private String name;
    private String password;
    private String phone;

    public User(int age, String email, Address homeAddress, String name, String password, String phone) {
        this.age = age;
        this.email = email;
        this.homeAddress = homeAddress;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public int getAge() { return age; }
    public String getEmail() { return email; }
    public Address getHomeAddress() { return homeAddress; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }
}
