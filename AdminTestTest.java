import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTestTest {

    @Test
    void getUserName() {
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals("Hfakih",c.getUserName());
    }

    @Test
    void getSchoolYear(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals("Junior",c.getSchoolYear());
    }
    @Test
    void getName(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals("Hussein Fakih",c.getName());
    }
    @Test
    void EditName(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals("Hussein Fakih",c.getName());
    }
    @Test
    void getAge(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals(22,c.getAge());
    }
    @Test
    void getBirthday(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals("01/21/1999",c.getBirthYear());
    }
    @Test
    void getID(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals(2758,c.getID());
    }
    @Test
    void getCity(){
        AdminTest c = new AdminTest("Hfakih","Hussein Fakih", "Junior",2758,"Dearborn Heights","01/21/1999",22);
        assertEquals("Dearborn Heights",c.getCity());
    }

}