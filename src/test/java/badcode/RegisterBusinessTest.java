package badcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {
    private  RegisterBusiness business;

    @BeforeEach
    public void init(){
        business = new RegisterBusiness();
    }

    @Test
    @DisplayName("test case First name is required.")
    public void case01(){
        String expected = "First name is required.";
        Exception exception =  assertThrows(ArgumentNullException.class, () -> business.register(null, new Speaker()));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case Last name is required.")
    public void case02(){
        String expected = "Last name is required.";
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        Exception exception =  assertThrows(ArgumentNullException.class, () -> business.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case Email is required.")
    public void case03(){
        String expected = "Email is required.";
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        Exception exception =  assertThrows(ArgumentNullException.class, () -> business.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case getEmailDomain")
    public void case04(){
        String email = "sarunmatipano@gmail.com";
        String expected = "gmail.com";
        String actual = business.getEmailDomain(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test case DomainEmailInvalidException")
    public void case05(){
        String email = "sarunmatipano@";
        assertThrows(DomainEmailInvalidException.class, () -> business.getEmailDomain(email));
    }

    @Test
    @DisplayName("test case SpeakerDoesntMeetRequirementsException")
    public void case06(){
        String expected = "Speaker doesn't meet our standard rules.";
        Speaker speaker = new Speaker();
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@mm.com");
        Exception exception =  assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> business.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("test case SaveSpeakerException")
    public void case07(){
        Speaker speaker = new Speaker();
        String expected = "Can't save a speaker.";
        speaker.setFirstName("Sarun");
        speaker.setLastName("Matipano");
        speaker.setEmail("sarunmatipano@gmail.com");
//        speaker.setExp(1);

        Exception exception =  assertThrows(SaveSpeakerException.class, () -> business.register(null, speaker));
        assertEquals(expected, exception.getMessage());
    }

}