package badcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {
    private  RegisterBusiness bussiness;

    @BeforeEach
    public void init(){
        bussiness = new RegisterBusiness();
    }

    @Test
    @DisplayName("test case First name is required.")
    public void case01(){
        String expected = "First name is required.";
        Exception exception =  assertThrows(ArgumentNullException.class, () -> bussiness.register(null, new Speaker()));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case Last name is required.")
    public void case02(){
        String expected = "Last name is required.";
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        Exception exception =  assertThrows(ArgumentNullException.class, () -> bussiness.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case Email is required.")
    public void case03(){
        String expected = "Email is required.";
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        Exception exception =  assertThrows(ArgumentNullException.class, () -> bussiness.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case getEmailDomain")
    public void case04(){
        String email = "sarunmatipano@gmail.com";
        String expected = "gmail.com";
        String actual = bussiness.getEmailDomain(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test case DomainEmailInvalidException")
    public void case05(){
        String email = "sarunmatipano@";
        assertThrows(DomainEmailInvalidException.class, () -> bussiness.getEmailDomain(email));
    }

    @Test
    @DisplayName("test case SpeakerDoesntMeetRequirementsException")
    public void case06(){
        String expected = "Speaker doesn't meet our standard rules.";
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@mm.com");
        Exception exception =  assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> bussiness.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case getFee fee <= 1")
    public void case07(){
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@gmail.com");
        int expected = 500;
        int actual = bussiness.getFee(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test case getFee fee <= 3")
    public void case08(){
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@gmail.com");
        int expected = 250;
        int actual = bussiness.getFee(3);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test case getFee fee <= 5")
    public void case09(){
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@gmail.com");
        int expected = 100;
        int actual = bussiness.getFee(5);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test case getFee fee <= 9")
    public void case10(){
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@gmail.com");
        int expected = 50;
        int actual = bussiness.getFee(9);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test case SaveSpeakerException")
    public void case11(){
        Speaker speaker = new Speaker();
        String expected = "Can't save a speaker.";
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@gmail.com");
        speaker.setExp(1);

        Exception exception =  assertThrows(SaveSpeakerException.class, () -> bussiness.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

}