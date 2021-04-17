import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class MessagesTest
{
    private static final int DEFAULT_TIMEOUT = 4;

    @BeforeAll
    static void setUpBeforeClass() throws Exception
    {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception
    {
    }

    @BeforeEach
    void setUp() throws Exception
    {
        Messages.objCreate = 0;
    }

    @AfterEach
    void tearDown() throws Exception
    {
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_dontHaveSameMessageID_uponCreation_1()
    {
        Messages mess1 = new Messages("Hey how are you");
        Messages mess2 = new Messages("Good how are you?");
        assertNotEquals(mess1.getMessageID(),mess2.getMessageID(),"Message ID values (all should be unique unless cloned or null message)");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_dontHaveSameMessageID_uponCreation_2()
    {
        Messages mess1 = new Messages("Hey how are you");
        Messages mess2 = new Messages("Good how are you?");
        assertEquals(1,mess1.getMessageID(),"Unique message ID (they increment starting at 1)");
        assertEquals(2,mess2.getMessageID(),"Unique message ID (they increment starting at 1)");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_haveSameNullVals_uponBlankCreation_1()
    {
        Messages mess1 = new Messages();
        Messages mess2 = new Messages();
        assertEquals(mess1.getMessageID(),mess2.getMessageID(),"Null messageID values (All should be the same)");
        assertEquals(mess1.getMessage(),mess2.getMessage(),"Null message values (All should be the same)");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_haveSameNullVals_uponBlankCreation_2()
    {
        Messages mess1 = new Messages();
        Messages mess2 = new Messages();
        assertEquals(-1,mess1.getMessageID(),"Null messageID value (All should be -1)");
        assertEquals("",mess1.getMessage(),"Null message value (All should be blank)");
        assertEquals(-1,mess2.getMessageID(),"Null messageID value (All should be -1)");
        assertEquals("",mess2.getMessage(),"Null message value (All should be blank)");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_containCorrectString_1()
    {
        Messages mess1 = new Messages("Have a lovely day");
        assertEquals("Have a lovely day", mess1.getMessage(),"Contents of Message object mess1");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_containCorrectString_2()
    {
        Messages mess1 = new Messages("Have a lovely day");
        mess1.editMessage("Thank you, I hope you do too");
        assertNotEquals("Have a lovely day", mess1.getMessage(),"Contents of Message object mess1");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_editMessageFunction_onlyEditsMessage()
    {
        Messages mess1 = new Messages("Hey how are you");
        assertEquals("Hey how are you",mess1.getMessage(),"mess1 value after object creation");
        assertEquals(1,mess1.getMessageID(), "mess1 messageID after object creation");
        mess1.editMessage("Good and you?");
        assertEquals("Good and you?",mess1.getMessage(),"mess1 value after editing message");
        assertEquals(1,mess1.getMessageID(), "mess1 messageID after editing message");
        mess1.editMessage("Very good thanks for asking");
        assertEquals("Very good thanks for asking",mess1.getMessage(),"mess1 value after editing message");
        assertEquals(1,mess1.getMessageID(), "mess1 messageID after editing message");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_AllCapsFunc()
    {
        Messages mess1 = new Messages("hi how are you");
        Messages mess2 = new Messages("Hi how are youU");
        Messages mess3 = new Messages("HIHOWAREYOU");
        Messages mess4 = new Messages("HI HOW ARE YOU");
        Messages mess5 = new Messages("!@#$(*!$!4)!$");
        assertFalse(mess1.isAllCaps(),"mess1 value after calling allcaps function");
        assertFalse(mess2.isAllCaps(),"mess2 value after calling allcaps function");
        assertTrue(mess3.isAllCaps(),"mess3 value after calling allcaps function");
        assertTrue(mess4.isAllCaps(),"mess4 value after calling allcaps function");
        assertFalse(mess5.isAllCaps(),"mess5 value after calling allcaps function");
        mess3.editMessage("        ");
        assertFalse(mess3.isAllCaps(),"mess3 value after calling allcaps function");
        mess4.editMessage("    A    ");
        assertTrue(mess4.isAllCaps(),"mess4 value after calling allcaps function");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_CloneFunc()
    {
        Messages mess1 = new Messages ("Hi my name is Bob");
        Messages mess2 = new Messages ("Hi my name is Jeff");
        mess2.clone(mess1);
        assertEquals(1,mess2.getMessageID(),"object mess2 messageID after cloning");
        assertEquals("Hi my name is Bob",mess2.getMessage(),"object mess2 message after cloning");
        Messages mess3 = new Messages("My name is William");
        mess2.clone(mess3);
        assertEquals(3,mess2.getMessageID(),"object mess2 messageID after cloning");
        assertEquals("My name is William",mess2.getMessage(),"object mess2 message after cloning");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_isOverLimitFunc()
    {
        Messages mess1 = new Messages("Computer science is very cool");
        Messages mess2 = new Messages("Computer science is the study of algorithmic processes, computational machines and computation itself.[1] As a discipline, computer science spans a range of topics from theoretical studies of algorithms, computation and information to the practical issues of implementing computational systems in hardware and software.[2][3]");
        assertFalse(mess1.isOverLimit(),"object mess1 checking if it's over char limit");
        assertTrue(mess2.isOverLimit(),"object mess2 checking if it's over char limit");
        mess2.editMessage("Computer science is the study of algorithmic processes");
        assertFalse(mess2.isOverLimit(),"object mess2 checking if it's over char limit");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_noSpacingFunc()
    {
        Messages mess1 = new Messages("   a");
        Messages mess2 = new Messages("!@#!$");
        Messages mess3 = new Messages("a    ");
        Messages mess4 = new Messages("   a   ");
        Messages mess5 = new Messages("asdfgh");
        assertFalse(mess1.noSpacing(),"object mess1 checking if there's no spacing in message");
        assertTrue(mess2.noSpacing(), "object mess2 checking if there's no spacing in message");
        assertFalse(mess3.noSpacing(), "object mess3 checking if there's no spacing in message");
        assertFalse(mess4.noSpacing(), "object mess4 checking if there's no spacing in message");
        assertTrue(mess5.noSpacing(),"object mess5 checking if there's no spacing in message");
        mess1.editMessage("");
        mess2.editMessage("  ");
        assertTrue(mess1.noSpacing(),"object mess1 checking if there's no spacing in message");
        assertFalse(mess2.noSpacing(), "object mess2 checking if there's no spacing in message");
    }

    @Test
    @Timeout( DEFAULT_TIMEOUT)
    void test_messageObjects_hasHashtagFunc()
    {
        Messages mess1 = new Messages("   a");
        Messages mess2 = new Messages("!@#!$");
        Messages mess3 = new Messages("#a asdas");
        Messages mess4 = new Messages("whats up #lol");
        Messages mess5 = new Messages("asdf#as asdas");
        assertFalse(mess1.hasHashtag(),"object mess1 checking if there is a proper hashtag in the string (the way used in social media)");
        assertFalse(mess2.hasHashtag(),"object mess2 checking if there is a proper hashtag in the string (the way used in social media)");
        assertTrue(mess3.hasHashtag(),"object mess3 checking if there is a proper hashtag in the string (the way used in social media)");
        assertTrue(mess4.hasHashtag(),"object mess4 checking if there is a proper hashtag in the string (the way used in social media)");
        assertFalse(mess5.hasHashtag(),"object mess5 checking if there is a proper hashtag in the string (the way used in social media)");
        mess1.editMessage("#Hey");
        mess3.editMessage("Hey wha#ts up");
        assertTrue(mess1.hasHashtag(),"object mess1 checking if there is a proper hashtag in the string (the way used in social media)");
        assertFalse(mess3.hasHashtag(),"object mess3 checking if there is a proper hashtag in the string (the way used in social media)");
    }
}
