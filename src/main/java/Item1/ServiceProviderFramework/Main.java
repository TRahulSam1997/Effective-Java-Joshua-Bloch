package Item1.ServiceProviderFramework;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        /* JDBC is a service provider framework. */
        try {
            /*
            * DriverManager.registerDriver is the provider registration.
            * Driver is the service provider interface.
            */
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            /*
            * Connection is the service interface.
            * DriverManager.getConnection is the service access API.
            */
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname\",\"username\",\"userpassword");
        } catch (Exception e) {}
    }
}

interface MyService {
    void doSomething();
}

class MyServiceFactory {
    public static MyService getService() {
        try {
            MyService myService = (MyService) Class.forName("com.mysql.jdbc.Driver").newInstance();
            myService.doSomething();
        }
        catch (Throwable t) {
            throw new Error(t);
        }
        return null;
    }
}
