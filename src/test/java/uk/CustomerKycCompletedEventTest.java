package uk;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.raisin.customer.kyc.uk.CustomerKycCompleted;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerKycCompletedEventTest {

    @Test
    public void importCustomerPersons() throws InvalidProtocolBufferException {
        String json = "{\n" +
                "  \"specVersion\": \"1\",\n" +
                "  \"type\": \"CustomerKycCompleted\",\n" +
                "  \"source\": \"123\",\n" +
                "  \"id\": \"213\",\n" +
                "  \"time\": \"2021-06-18T16:38:17.693741Z\",\n" +
                "  \"traceId\": \"123\",\n" +
                "  \"spanId\": \"123\",\n" +
                "  \"data\": {\n" +
                "    \"status\": \"ACCEPTED\"\n" +
                "  }\n" +
                "}";
        CustomerKycCompleted.CustomerKycCompletedEvent.Builder builder =
                CustomerKycCompleted.CustomerKycCompletedEvent.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(json, builder);
        CustomerKycCompleted.CustomerKycCompletedEvent customerKycCompletedEvent = builder.build();

        assertEquals("213", customerKycCompletedEvent.getId());
        assertEquals("CustomerKycCompleted", customerKycCompletedEvent.getType());
        assertEquals(CustomerKycCompleted.Status.ACCEPTED, customerKycCompletedEvent.getData().getStatus());

    }
}
