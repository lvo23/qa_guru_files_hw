package com.lvo23.pojo;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vlad Litvinov
 */
public class TeamPojo {

    private String name;

    private String country;

    private String principal;

    private List<DriverPojo> drivers;

    public TeamPojo() {

    }

    public TeamPojo(String name, String country, String principal, List<DriverPojo> drivers) {

        this.name = name;
        this.country = country;
        this.principal = principal;
        this.drivers = drivers;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getPrincipal() {

        return principal;
    }

    public void setPrincipal(String principal) {

        this.principal = principal;
    }

    public List<DriverPojo> getDrivers() {

        return drivers;
    }

    public void setDrivers(List<DriverPojo> drivers) {

        this.drivers = drivers;
    }

    @Override
    public String toString() {

        return "TeamPojo{" + "name='" + name + '\'' + ", country='" + country + '\''
                + ", principal='" + principal + '\'' + ", drivers=" + drivers + '}';
    }
}
