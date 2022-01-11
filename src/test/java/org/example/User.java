package org.example;

public class User {

    private String username;
    private String password;
    private String real_name;
    private String email;

    private Access_level access_level;


    private String enabled;
    private String boxprotected;


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getReal_name() { return real_name; }
    public void setReal_name(String real_name) { this.real_name = real_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Access_level getAccess() { return access_level; }
    public void setAccess(Access_level value) { this.access_level = value; }


    public String getEnabled() { return enabled; }
    public void setEnabled(String enabled) { this.enabled = enabled; }

    public String getBoxprotected() { return boxprotected; }
    public void setBoxprotected(String boxprotected) { this.boxprotected = boxprotected; }





}
