package com.sgaikar1.xmlandjsonparsingexample;

/**
 * Created by Santosh Gaikar on 18/12/17.
 */

public class DataObject {

    private  int id;
    private  int companyid;
    private  String company = "";
    private  String date = "";
    private  String address="";
    private  String city="";
    private  String state="";
    private  String zipcode="";
    private  String country="";
    private  String telephone="";
    private  String forms="";

    /************* Define Setter Methods *********/

    public void setid(int id)
    {
        this.id = id;
    }
    public void setcompanyid(int companyid)
    {
        this.companyid = companyid;
    }
    public void setcompany(String company)
    {
        this.company = company;
    }
    public void setaddress(String address)
    {
        this.address = address;
    }
    public void setcity(String city)
    {
        this.city = city;
    }
    public void setstate(String state)
    {
        this.state = state;
    }
    public void setzipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }
    public void setcountry(String country)
    {
        this.country = country;
    }
    public void settelephone(String telephone)
    {
        this.telephone = telephone;
    }
    public void setdate(String date)
    {
        this.date = date;
    }



    /************* Define Getter Methods *********/

    public int getid()
    {
        return id;
    }

    public String getdate()
    {
        return date;
    }
    public int getcompanyid()
    {
        return companyid;
    }
    public String getcompany()
    {
        return company;
    }
    public String getaddress()
    {
        return this.address;
    }
    public String getcity()
    {
        return this.city;
    }

    public String getstate()
    {
        return this.state;
    }

    public String getzipcode()
    {
        return this.zipcode;
    }

    public String getcountry()
    {
        return this.country;
    }

    public String gettelephone()
    {
        return this.telephone;
    }
    public void setforms(String forms)
    {
        this.forms = forms;
    }
    public String getforms()
    {
        return this.forms;
    }
}