package com.company;

import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.company.Main.connectionDB;
import static com.company.Main.nameInfoTable;

public class SQLQueries {



    static public void createNewUser(JSONObject jsonObject) throws SQLException {


        String query ="insert into \"UserSignDataTable\" "+" (" +
                "\"FCsGenDirector\"," +
                "\"INN\"," +
                "\"KPP\"," +
                "\"OGRN\"," +
                "\"dateOfRegistration\"," +
                "\"email\"," +
                "\"isCustomer\"," +
                "\"isSeller\"," +
                "\"legalAddress\"," +
                "\"nameCompany\"," +
                "\"phoneNumber\")"+
                " values (?,?,?,?,?,?,?,?,?,?,?)";


        PreparedStatement preparedStatement=connectionDB.prepareStatement(query);


        //preparedStatement.setInt(1,identifier);
        preparedStatement.setString(1,jsonObject.getString("FCsGenDirector"));
        preparedStatement.setString(2,jsonObject.getString("INN"));
        preparedStatement.setString(3,jsonObject.getString("KPP"));
        preparedStatement.setString(4,jsonObject.getString("OGRN"));
        preparedStatement.setString(5,jsonObject.getString("dateOfRegistration"));
        preparedStatement.setString(6,jsonObject.getString("email"));
        preparedStatement.setBoolean(7,jsonObject.getBoolean("isCustomer"));
        preparedStatement.setBoolean(8,jsonObject.getBoolean("isSeller"));
        preparedStatement.setString(9,jsonObject.getString("legalAddress"));
        preparedStatement.setString(10,jsonObject.getString("nameCompany"));
        preparedStatement.setString(11,jsonObject.getString("phoneNumber"));

        int row = preparedStatement.executeUpdate();
        System.out.println(row);
    }

    public void deleteUser(){}



    public void changeUserStatus(){}


    public void updateData(){}







}
