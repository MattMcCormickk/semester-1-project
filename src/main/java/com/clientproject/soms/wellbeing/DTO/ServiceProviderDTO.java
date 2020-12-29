package com.clientproject.soms.wellbeing.DTO;

public class ServiceProviderDTO {
    private String name;
    private String email;
    private String telephone;
    private String address;
    private String postcode;
    private String companiesHouseId;

    public ServiceProviderDTO( String name, String email, String telephone, String address, String postcode, String companiesHouseId){
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.postcode = postcode;
        this.companiesHouseId = companiesHouseId;
    }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public  String getTelephone() { return telephone; }

    public  String getAddress() { return  address; }

    public  String getPostcode() { return  postcode; }

    public  String getCompaniesHouseId() { return  companiesHouseId; }
}
