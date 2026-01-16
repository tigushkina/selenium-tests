import backend.PetStoreApi;
import backend.dto.Category;
import backend.dto.PetModel;
import backend.dto.Tag;
import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.Data;
import org.junit.Test;


public class PetStoreTestSuite {

    @Test
    public void testAddNewPetApi() {
        final PetModel requestBody = new PetModel();

        final Tag[] tags = {new Tag(1,"tag1"), new Tag(2,"tag2")};

        requestBody.setId(55);
        requestBody.setCategory(new Category(122, "Fish"));
        requestBody.setName("Nemo");
        requestBody.setPhotoUrls(new String[]{"https://static.wikia.nocookie.net/pixar/images/a/aa/Nemo-FN.png/revision/latest/scale-to-width-down/1000?cb=20160710221104",
                "https://static.wikia.nocookie.net/pixar/images/e/e4/PDVD_899.jpg/revision/latest?cb=20120920062043"});
        requestBody.setTags(tags);
        requestBody.setStatus("available");

        final Gson gson = new Gson();
        final String requestBodyJson = gson.toJson(requestBody);


       final PetStoreApi petStoreApi = new PetStoreApi();
       final Response response = petStoreApi.addNewPet(requestBodyJson);



    }

}
