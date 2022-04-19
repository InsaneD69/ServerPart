package com.company;


import org.json.JSONObject;

import java.sql.SQLException;


public class UserRegistration {


    JSONObject jsonObject;


        public UserRegistration(JSONObject jsonObject) throws SQLException {

            this.jsonObject=jsonObject;
            getUserRegistration();

        }

       public void getUserRegistration() throws SQLException {


        CheckUserData checkUserData = new CheckUserData(jsonObject);

        if(checkUserData.logs!=null){//отправlяем в клиент ошибкт, если они есть

            checkUserData.logs.forEach(System.out::println);


            return;

        }











        //отправка на сервер информации, если нету ошибок


      }










    }




