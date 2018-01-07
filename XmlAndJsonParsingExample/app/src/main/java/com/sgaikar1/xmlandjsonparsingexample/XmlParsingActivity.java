package com.sgaikar1.xmlandjsonparsingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Santosh Gaikar on 18/12/17.
 */

public class XmlParsingActivity extends AppCompatActivity{
    List<DataObject> myData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_xml);

        final TextView output = (TextView) findViewById(R.id.output);
        final Button bparsexml      = (Button) findViewById(R.id.bparsexml);

        //Static XML data which we will parse
        final String XMLData = "<login>"
                +"<status>OK</status>"
                +"<jobs>"
                +"<job>"
                +"<id>4</id>"
                +"<companyid>4</companyid>"
                +"<company>Android Example</company>"
                +"<address>Parse XML Android</address>"
                +"<city>Mumbai</city>"
                +"<state>Xml Parsing Tutorial</state>"
                +"<zipcode>400037</zipcode>"
                +"<country>India</country>"
                +"<telephone>9821507043</telephone>"
                +"<date>2017-12-18 12:00:00</date>"
                +"</job>"
                +"<job>"
                +"<id>5</id>"
                +"<companyid>6</companyid>"
                +"<company>Xml Parsing In Java</company>"
                +"<address>Chembur</address>"
                +"<city>Mumbai</city>"
                +"<state>XML Parsing Basics</state>"
                +"<zipcode>400071</zipcode>"
                +"<country>India</country>"
                +"<telephone>0000001234</telephone>"
                +"<date>2017-12-18 13:00:00</date>"
                +"</job>"
                +"</jobs>"
                +"</login>";

        String dataToBeParsed = "Click on button to parse XML.\n\n XML DATA : \n\n"+XMLData;
        output.setText(dataToBeParsed);

        /****  Button Click Listener ********/
        bparsexml.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try{

                    /************** Read XML *************/

                    BufferedReader br=new BufferedReader(new StringReader(XMLData));
                    InputSource is=new InputSource(br);

                    /************  Parse XML **************/

                    XMLParser parser=new XMLParser();
                    SAXParserFactory factory=SAXParserFactory.newInstance();
                    SAXParser sp=factory.newSAXParser();
                    XMLReader reader=sp.getXMLReader();
                    reader.setContentHandler(parser);
                    reader.parse(is);

                    /************* Get Parse data in a ArrayList **********/
                    myData=parser.list;

                    if(myData!=null){

                        String OutputData = "";

                        /*************** Get Data From ArrayList *********/

                        for (DataObject xmlRowData : myData) {
                            if(xmlRowData!=null)
                            {


                                int     id        = xmlRowData.getid();
                                int     companyid = xmlRowData.getcompanyid();
                                String  company   = xmlRowData.getcompany();
                                String  address   = xmlRowData.getaddress();
                                String  city      = xmlRowData.getcity();
                                String  state     = xmlRowData.getstate();
                                String  zipcode   = xmlRowData.getzipcode();
                                String  country   = xmlRowData.getcountry();
                                String  telephone = xmlRowData.gettelephone();
                                String  date      = xmlRowData.getdate();


                                OutputData += "Job Node : \n\n "+ company +" | "
                                        + address    +" | "
                                        + city       +" | "
                                        + state      +" | "
                                        + zipcode    +" | "
                                        + country    +" | "
                                        + telephone  +" | "
                                        + date       +" \n\n "

                                ;

                            }
                            else
                                Log.e("Jobs", "Jobs value null");
                        }

                        /******** Show Data *************/
                        output.setText(OutputData);
                    }
                }
                catch(Exception e){Log.e("Jobs", "Exception parse xml :"+e);}
            }
        });
    }
}
