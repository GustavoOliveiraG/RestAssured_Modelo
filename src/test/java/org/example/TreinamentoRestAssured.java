package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;

import java.util.Iterator;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TreinamentoRestAssured {

//region Manual da API (given())
        /*
        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users/me").
         */

        /*
        Map<String, Object> headerMap = new HashMap<String, Object>();
        headerMap.put("content-type", "application/json");
        headerMap.put("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy");
        given().
                headers(headerMap).
                baseUri("http://localhost:8989").
                basePath("/api/rest/users/me").
         */

        /*
        List<Header> headerlist = new ArrayList<>();
        headerlist.add(new Header("content-type", "application/json"));
        headerlist.add(new Header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy"));
        Headers headers = new Headers(headerlist);
        given().
                headers(headers).
                baseUri("http://localhost:8989").
                basePath("/api/rest/users/me").

         */

//endregion

//region Manual da API (body)

    /*JsonSimples
    JSONObject addUser = new JSONObject();
    JSONObject access_level = new JSONObject();

        addUser.put("username","Joao API_Rest");
        addUser.put("password","123456");
        addUser.put("real_name","Joao da API_Rest");
        addUser.put("email","joao@api.com.bt");

        access_level.put("name","updater");
        addUser.put("access_level",access_level);

        addUser.put("enabled",1);
        addUser.put("protected",0);
     */


//endregion

//region Manual da API (body2)
    //Criando Class para separar os Objetos do Json
    /*
    User user = new User();
    Access_level access_level = new Access_level();

        user.setUsername("Teste API Class");
        user.setPassword("123456");
        user.setReal_name("Teste API real Nome");
        user.setEmail("email@apio.com.br");

        access_level.setId(40);
        user.setAccess(access_level);

        user.setEnabled("1");
        user.setBoxprotected("0");

     */
//endregion

    @Test
    public void AddUser(){

        JSONObject user = new JSONObject();
        JSONObject access_level = new JSONObject();

        user.put("username","Joao API_Rest JsonSimples");
        user.put("password","123456");
        user.put("real_name","Joao da API_Rest JsonSimples");
        user.put("email","joao@api.com.bt");

        access_level.put("id",70);
        user.put("access_level",access_level);

        user.put("enabled",1);
        user.put("protected",0);



        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users").
                body(user).
        when().
               post().

        then().
                statusCode(201).
                body("user.name",equalTo("Joao API_Rest"),
                "user.real_name",equalTo("Joao da API_Rest"));

    }

    @Test
    public void deleteUser(){

        int id;
        id = 97;

        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users/"+ id).

        when().
                delete().

        then();
    }

    @Test
    public void AddUserObjetoeClass(){
//class Access e User
        User user = new User();
        Access_level access_level = new Access_level();

        user.setUsername("Teste API Class");
        user.setPassword("123456");
        user.setReal_name("Teste API real Class");
        user.setEmail("class@class.com.br");

        access_level.setId(40);
        user.setAccess(access_level);

        user.setEnabled("1");
        user.setBoxprotected("0");


        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users").
                body(user).
        when().
                post().

        then().
                statusCode(201).
                body("user.name",equalTo("Teste API Class"),
                     "user.real_name",equalTo("Teste API real Nome"),
                     "user.access_level.id",equalTo(40));

    }

    @Test(dataProvider = "dataAddUserObjectProvider", dataProviderClass = DDTaddUser.class)
    public  void AddUserObjetoClassDDT(User dataUser){

        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users").
                body(dataUser).
        when().
                post().

        then().
                statusCode(201);

    }


    @Test(dataProvider = "dataAddUserCSVProvider", dataProviderClass = ReadingCSV.class)
    public void AddUserCSVDDT(String[] userData){

        String csvName = userData[0];
        String csvSenha = userData[1];
        String csvNameReal = userData[2];
        String csvEmail = userData[3];
        String csvAccess = userData[4];
        String csvEnable = userData[5];
        String csvBloqueado = userData[6];



        JSONObject userDDTcvs = new JSONObject();
        JSONObject access_levelDDTcsv = new JSONObject();

        userDDTcvs.put("username",csvName);
        userDDTcvs.put("password",csvSenha);
        userDDTcvs.put("real_name",csvNameReal);
        userDDTcvs.put("email",csvEmail);

        access_levelDDTcsv.put("id",csvAccess);
        userDDTcvs.put("access_level",access_levelDDTcsv);

        userDDTcvs.put("enabled",csvEnable);
        userDDTcvs.put("protected",csvBloqueado);


        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users").
                body(userDDTcvs).
        when().
                post().

        then().
                statusCode(201);

    }




//Em desenvolvimento
    @Test
    public void AddUserTesteRelatorio(){

        JSONObject userreport = new JSONObject();
        JSONObject access_levelreport = new JSONObject();

        userreport.put("username","Joao API_Report");
        userreport.put("password","123456");
        userreport.put("real_name","Joao da API_Rest reporte");
        userreport.put("email","joao@api.com.bt");

        access_levelreport.put("id",70);
        userreport.put("access_level",access_levelreport);

        userreport.put("enabled",1);
        userreport.put("protected",0);



        given().
                header("content-type", "application/json").
                header("Authorization", "Zuh9A61f0TXrVJc8ovyeSg_6MFVWYToy").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users").
                body(userreport).
                when().
                post().

                then().
                statusCode(201);
    }









}
