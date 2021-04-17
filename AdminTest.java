public class AdminTest {

    public  String userName;
    public  String Name;
    public  String SchoolYear;
    public String Birthday;
    public int ID;
    public String City;
    public int age;

    //constructor
    AdminTest(){
        userName="";
        Name="";
        SchoolYear="";
        City="";
        ID=-1;
        Birthday="01/21/1999";
        age=-1;

    }

    //constructor
    AdminTest(String user, String name, String year,int ID,String City,String Birthday,int age){
        this.userName=user;
        this.Name=name;
        this.SchoolYear=year;
        this.City=City;
        this.Birthday=Birthday;
        this.ID=ID;
        this.age=age;
    }
    //get UserName
    String getUserName(){
        return userName;

    }

    public void setUserName(String UserName){
        this.userName=UserName;
    }

    String getName(){

        return Name;
    }

    public void SetName(String Name){

        this.Name=Name;
    }
    public String getSchoolYear(){

        return SchoolYear;
    }
    public String getBirthYear(){
        return Birthday;
    }
    public void setBirthDay(String Birthday){
        this.Birthday=Birthday;
    }
    public String getCity(){
        return City;
    }
    public void setCity(String City){
        this.City=City;
    }
    public int getID(){
        return ID;
    }
    public void SetId(int ID){
        this.ID=ID;
    }
    public void setSchoolYear(String SchoolYear){

        this.SchoolYear=SchoolYear;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int Age){
        this.age=Age;
    }

    public String EditUserName(String NewUserName){
        this.userName=NewUserName;
        return this.userName;
    }
    public String EditName(String NewName){
        this.Name=NewName;
        return this.Name;
    }

    public String EditYear(String NewYear){
        NewYear="Hfakih";
        this.SchoolYear=NewYear;
        return this.SchoolYear;

    }
}