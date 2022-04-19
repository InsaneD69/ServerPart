package com.company;

import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;




public class Main {

    static public String hostName="ec2-52-54-212-232.compute-1.amazonaws.com";
    static public String DBName="d3juig38qlpane";
    static public String port="5432";
    static public String user = "ispfozezsllypp";
    static public String url ="jdbc:postgresql://ec2-52-54-212-232.compute-1.amazonaws.com:5432/d3juig38qlpane";
    static private String password ="d726cabb37d69cafb3156b57eb2ea3ac90c6c1057506f7317a1d0c7959215a45";
    static public String nameInfoTable="public.\"UserSignDataTable\"";


    static ServerSocket connection;

    static  Connection connectionDB;

    public static void main(String[] args) throws IOException, SQLException {



        openConnectionDB();

       // openConnectionClient();

       // waitingForRequests();
        //тест для нахождения ошибки пустого поля (пока только этой ошибки
        JSONObject jsonobject =new JSONObject()  {};

        jsonobject.put(LocaleFields.nameCompany.name(),"Cringe");
        jsonobject.put(LocaleFields.isCustomer.name(),0);
        jsonobject.put(LocaleFields.isSeller.name(), 1);
        jsonobject.put(LocaleFields.INN.name(), "21321314");
        jsonobject.put(LocaleFields.OGRN.name(), "s");
        jsonobject.put(LocaleFields.FCsGenDirector.name(), "21321314");
        jsonobject.put(LocaleFields.email.name(), "qwerty@cringe.pzdc");
        jsonobject.put(LocaleFields.legalAddress.name(), "qw er t io");
        jsonobject.put(LocaleFields.KPP.name(), "iop");
        jsonobject.put(LocaleFields.phoneNumber.name(), 0);

                                                                  //отсутствует заполнение поля с датой  регистрации
        UserRegistration userRegistration = new UserRegistration(jsonobject);
        //


        //небольшой тест доступа к таблице со взятием значений из поля "Id" "NameCompany"
        Statement statement = connectionDB.createStatement();


        ResultSet resultSet=statement.executeQuery("select * from "+nameInfoTable);

        while (resultSet.next()){
            System.out.println(resultSet.getString("Id")+" "+resultSet.getString("nameCompany"));
        }

        //


        closeConnectionDB();

    }





    public static void waitingForRequests() throws IOException {

        Socket input = connection.accept();
        BufferedReader from_client = new BufferedReader(new InputStreamReader(input.getInputStream()));
        BufferedWriter send_to = new BufferedWriter(new OutputStreamWriter(input.getOutputStream()));
        System.out.println("Get message");
        String incomeMessage = from_client.readLine();
        System.out.println(" message: "+ incomeMessage+"\n");

        send_to.write("all ok, dont worry"+"\n");
        send_to.flush();

        send_to.close();
        from_client.close();



    }



    public static void openConnectionDB()  {


        try{
            Class.forName("org.postgresql.Driver");
            connectionDB= DriverManager
                    .getConnection("jdbc:postgresql://"+hostName+":"+port+"/"+DBName+"?user="+user+"&password="+password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
          catch (SQLException e) {
            e.printStackTrace();
        }



    }






    public static void openConnectionClient() throws IOException {


        connection=new ServerSocket(27015);

    }

    public static void closeConnectionDB() throws SQLException {


        connectionDB.close();



    }


    public static void closeConnectionClient() throws  IOException {

        connection.close();

    }





}
