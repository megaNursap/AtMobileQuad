package utils.api.twilio;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.IncomingPhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.Config;
import utils.factory.DriverUtils;

@Setter
@Getter
@Builder
@ToString
public class TwilioAPI {
    private static final String ACCOUNT_SID = "ACCOUNT_SID";
    private static final String AUTH_TOKEN = "AUTH_TOKEN";

    public static void main(String[] args) {
        // Initialize Twilio
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Fetch phone numbers
        ResourceSet<IncomingPhoneNumber> phoneNumbers = IncomingPhoneNumber.reader().read();

        // Print information about each phone number
        for (IncomingPhoneNumber phoneNumber : phoneNumbers) {
            System.out.println("Phone Number SID: " + phoneNumber.getSid());
            System.out.println("Phone Number: " + phoneNumber.getPhoneNumber());
            // Add more details as needed
        }
    }

    public String getSMSOTP(String phoneNumber) {

        String OTP = "";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message latestMessage = Message.reader()
                .setTo(new PhoneNumber(phoneNumber)) // Replace with the recipient's phone number
                .setFrom(new PhoneNumber(Config.ENV.TWILIO_PHONE_NUMBER()))
                .limit(1) // Limit to one message (latest)
                .read()
                .iterator()
                .next();

        System.out.println("Latest OTP message: " + latestMessage.getBody());

        OTP = DriverUtils.extractDigitFromStrings(latestMessage.getBody());

        return OTP;
    }
}
