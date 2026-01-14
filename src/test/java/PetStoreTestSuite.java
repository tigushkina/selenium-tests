import backend.PetStoreApi;
import org.junit.Test;

public class PetStoreTestSuite {
    @Test
    public void verifyNewPetAddition() {
       final String AddNewPetRequestBody = "{\n" +
               "  \"id\": 75232,\n" +
               "  \"category\": {\n" +
               "    \"id\": 0,\n" +
               "    \"name\": \"string\"\n" +
               "  },\n" +
               "  \"name\": \"Buddy\",\n" +
               "  \"photoUrls\": [\n" +
               "    \"string\"\n" +
               "  ],\n" +
               "  \"tags\": [\n" +
               "    {\n" +
               "      \"id\": 0,\n" +
               "      \"name\": \"string\"\n" +
               "    }\n" +
               "  ],\n" +
               "  \"status\": \"available\"\n" +
               "}";

       final PetStoreApi petStoreApi = new PetStoreApi();
       final String response = petStoreApi.addNewPet(AddNewPetRequestBody);

    }

}
