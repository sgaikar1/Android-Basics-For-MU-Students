package com.sgaikar1.xmlandjsonparsingexample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santosh Gaikar on 18/12/17.
 */
// SAX parser to parse job

public class XMLParser extends DefaultHandler
{


    List<DataObject> list=null;

    // string builder acts as a buffer
    StringBuilder builder;

    DataObject jobsValues=null;


    // Initialize the arraylist
    // @throws SAXException

    @Override
    public void startDocument() throws SAXException {

        /******* Create ArrayList To Store XmlValuesModel object ******/
        list = new ArrayList<DataObject>();
    }


    // Initialize the temp XmlValuesModel object which will hold the parsed info
    // and the string builder that will store the read characters
    // @param uri
    // @param localName ( Parsed Node name will come in localName  )
    // @param qName
    // @param attributes
    // @throws SAXException

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        /****  When New XML Node initiating to parse this function called *****/

        // Create StringBuilder object to store xml node value
        builder=new StringBuilder();

        if(localName.equals("login")){

            //Log.i("parse","====login=====");
        }
        else if(localName.equals("status")){

            // Log.i("parse","====status=====");
        }
        else if(localName.equals("jobs")){

        }
        else if(localName.equals("job")){

            // Log.i("parse","----Job start----");
            /********** Create Model Object  *********/
            jobsValues = new DataObject();
        }
    }



    // Finished reading the login tag, add it to arraylist
    // @param uri
    // @param localName
    // @param qName
    // @throws SAXException

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {


        if(localName.equals("job")){

            /** finished reading a job xml node, add it to the arraylist **/
            list.add( jobsValues );

        }
        else  if(localName.equalsIgnoreCase("status")){


        }
        else  if(localName.equalsIgnoreCase("id")){

            jobsValues.setid(Integer.parseInt(builder.toString()));
        }
        else if(localName.equalsIgnoreCase("companyid")){

            jobsValues.setcompanyid(Integer.parseInt(builder.toString()));
        }
        else if(localName.equalsIgnoreCase("company")){
            jobsValues.setcompany(builder.toString());
        }
        else if(localName.equalsIgnoreCase("address")){
            jobsValues.setaddress(builder.toString());
        }
        else if(localName.equalsIgnoreCase("city")){
            jobsValues.setcity(builder.toString());
        }
        else if(localName.equalsIgnoreCase("state")){
            jobsValues.setstate(builder.toString());
        }
        else if(localName.equalsIgnoreCase("zipcode")){
            jobsValues.setzipcode(builder.toString());
        }
        else if(localName.equalsIgnoreCase("country")){
            jobsValues.setcountry(builder.toString());
        }
        else if(localName.equalsIgnoreCase("telephone")){
            jobsValues.settelephone(builder.toString());
        }
        else if(localName.equalsIgnoreCase("date")){
            jobsValues.setdate(builder.toString());
        }

        // Log.i("parse",localName.toString()+"========="+builder.toString());
    }


    // Read the value of each xml NODE
    // @param ch
    // @param start
    // @param length
    // @throws SAXException

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        /******  Read the characters and append them to the buffer  ******/
        String tempString=new String(ch, start, length);
        builder.append(tempString);
    }
}