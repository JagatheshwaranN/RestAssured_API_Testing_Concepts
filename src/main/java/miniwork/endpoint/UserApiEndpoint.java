package miniwork.endpoint;

public class UserApiEndpoint {

    public static final String BASE_URI = "https://petstore.swagger.io/v2/";
    public static final String RESOURCE = "user";
    public static final String PATH_PARAM = "/{user_name}";

    public static final String CREATE_USER = BASE_URI+RESOURCE;
    public static final String RETRIEVE_USER = BASE_URI+RESOURCE+PATH_PARAM;
    public static final String UPDATE_USER = BASE_URI+RESOURCE+PATH_PARAM;
    public static final String DELETE_USER = BASE_URI+RESOURCE+PATH_PARAM;
}
