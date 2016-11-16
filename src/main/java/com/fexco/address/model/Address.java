package com.fexco.address.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Denize on 15/11/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    private String addressline1;
    private String addressline2;
    private String addressline3;
    private String addressline4;
    private String summaryline;
    private String organisation;
    private String buildingname;
    private String number;
    private String premise;
    private String dependentstreet;
    private String street;
    private String doubledependentlocality;
    private String dependentlocality;
    private String posttown;
    private String county;
    private String postcode;
    private String latitude;
    private String longitude;
    private String pobox;
    private String subbuildingname;
    private String recodes;
    private Boolean morevalues;
    private Integer nextpage;
    private Integer totalresults;

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAddressline3() {
        return addressline3;
    }

    public void setAddressline3(String addressline3) {
        this.addressline3 = addressline3;
    }

    public String getAddressline4() {
        return addressline4;
    }

    public void setAddressline4(String addressline4) {
        this.addressline4 = addressline4;
    }

    public String getSummaryline() {
        return summaryline;
    }

    public void setSummaryline(String summaryline) {
        this.summaryline = summaryline;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getDependentstreet() {
        return dependentstreet;
    }

    public void setDependentstreet(String dependentstreet) {
        this.dependentstreet = dependentstreet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoubledependentlocality() {
        return doubledependentlocality;
    }

    public void setDoubledependentlocality(String doubledependentlocality) {
        this.doubledependentlocality = doubledependentlocality;
    }

    public String getDependentlocality() {
        return dependentlocality;
    }

    public void setDependentlocality(String dependentlocality) {
        this.dependentlocality = dependentlocality;
    }

    public String getPosttown() {
        return posttown;
    }

    public void setPosttown(String posttown) {
        this.posttown = posttown;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }

    public String getSubbuildingname() {
        return subbuildingname;
    }

    public void setSubbuildingname(String subbuildingname) {
        this.subbuildingname = subbuildingname;
    }

    public String getRecodes() {
        return recodes;
    }

    public void setRecodes(String recodes) {
        this.recodes = recodes;
    }

    public Boolean getMorevalues() {
        return morevalues;
    }

    public void setMorevalues(Boolean morevalues) {
        this.morevalues = morevalues;
    }

    public Integer getNextpage() {
        return nextpage;
    }

    public void setNextpage(Integer nextpage) {
        this.nextpage = nextpage;
    }

    public Integer getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(Integer totalresults) {
        this.totalresults = totalresults;
    }
}
