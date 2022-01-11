package org.example;

import org.testng.annotations.DataProvider;

public class DDTaddUser {

    @DataProvider(name = "dataAddUserObjectProvider")
    public Object[]dataAddUserProvider(){

        //User001
        User datauser001 = new User();
        Access_level dataaccess_level001 = new Access_level();

        datauser001.setUsername("Teste DDT001");
        datauser001.setPassword("123456");
        datauser001.setReal_name("Teste DDT001 Class");
        datauser001.setEmail("ddt001@gmail.com.br");

        dataaccess_level001.setId(40);
        datauser001.setAccess(dataaccess_level001);

        datauser001.setEnabled("1");
        datauser001.setBoxprotected("0");

        //User002
        User datauser002 = new User();
        Access_level dataaccess_level002 = new Access_level();

        datauser002.setUsername("Teste DDT002");
        datauser002.setPassword("123456");
        datauser002.setReal_name("Teste DDT002 Class");
        datauser002.setEmail("ddt002@gmail.com.br");

        dataaccess_level002.setId(40);
        datauser002.setAccess(dataaccess_level002);

        datauser002.setEnabled("1");
        datauser002.setBoxprotected("0");

        return new User[]{datauser001,datauser002};

    }




}
