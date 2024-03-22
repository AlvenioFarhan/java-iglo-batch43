package com.indocyber;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class OuterHelper {
    /*
    * Nested class pada java bermacam-macam, yaitu:
    *   Static Nested Class : Nested class yang di deklarasi sebagai static di dalam outer class.
    *   Non-Static Nested Class / Inner Class: Nested class yang di deklarasi sebagai non-static di dalam outer class.
    *   Local Class: adalah class yang di deklarasi di dalam scope method, yang gunanya hanya untuk dipakai satu kali di dalam method saja.
    *   Anonymous Class: Anonymous class akan dijelaskan pada chapter lain.
    * */

    //Baik field indonesia maupun databaseName bisa dipakai oleh semua nested class.
    private static final Locale indonesia = new Locale("id", "ID");
    private static final String databaseName = "Basilisk";

    /*
        Static Nested Class
        -) Static nested class di declare static di dalam outer class, dan digunakan seperti halnya static member lain di dalam outer class.
            Sehingga static nested class adalah member dari outer class bukan member dari object outer class.
        -) Seluruh member di dalam static nested class bisa memiliki access modifier apa saja.
        -) Layaknya static member biasa, static class hanya bisa akses static member dari outer class.
        -) Static nested class sendiri bisa memiliki member yang static dan non-static
    */
    public static class DateTimeHelper{
        private LocalDate today = LocalDate.now();
        public static DateTimeFormatter longFormatter = DateTimeFormatter.ofPattern("eeee, dd MMMM yyyy", indonesia);

        public long calculateAge(LocalDate birthDate){
            return ChronoUnit.YEARS.between(birthDate, this.today);
        }

        public static String getLongFormat(LocalDate date){
            return longFormatter.format(date);
        }
    }

    /*
        Non-static nested classes (Inner Class)
        -) Inner class hanya bisa diakses oleh instance / object dari outer class, sifatnya sama seperti non-static member biasa.
        -) Inner class mengakses static dan non-static member dari outer class, termasuk static nested class atau inner class lainnya.
    */
    public class DataBaseHelper{
        private String port;
        private String serverName;
        private String username;
        private String password;

        public DataBaseHelper(String port, String serverName, String username, String password) {
            this.port = port;
            this.serverName = serverName;
            this.username = username;
            this.password = password;
        }

        public String getPort() {
            return port;
        }
        public void setPort(String port) {
            this.port = port;
        }
        public String getServerName() {
            return serverName;
        }
        public void setServerName(String serverName) {
            this.serverName = serverName;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        public void connectingToDB(LocalDate connectTime){
            String formatted = DateTimeHelper.getLongFormat(connectTime);
            System.out.printf("""
                    Connecting...
                    Data Base: %s, 
                    Server Name: %s, 
                    Port: %s,
                    Time: %s\n""", databaseName, serverName, port, formatted);
        }

        public static void disconnectAllConnection(){
            System.out.println("Disconnecting all connection");
        }
    }

    /*
        Local classes
        -) Access modifiers di dalam local class mubazir, karena tidak akan ada efeknya.
        -) Local class tidak bisa di define sebatai static
        -) bisa mengakses variable atau object di dalam fungsi
    */
    public void sendNotification(String phoneNumberParameter, String emailAddressParameter){
        String countryCode = "+6221";
        class ContactDetails{
            private String phoneNumber; //tidak ada efeknya ditulis private
            String emailAddress;

            ContactDetails(String phoneNumber, String emailAddress) {
                this.phoneNumber = phoneNumber;
                this.emailAddress = emailAddress;
            }
            void printDetails(){
                System.out.printf("Phone Number: %s, Email Address: %s, Country Code: %s\n", this.phoneNumber, this.emailAddress, countryCode);
            }
        }
        ContactDetails contactDetails = new ContactDetails("085568345", "test@gmail.com");
        System.out.println(contactDetails.phoneNumber);
        contactDetails.printDetails();
    }
}
