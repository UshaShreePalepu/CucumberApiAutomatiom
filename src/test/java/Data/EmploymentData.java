package Data;

public class EmploymentData {
    public static String requestBody(String name) {
        String empBody = "{\"name\":" +name+ ",\"salary\":\"123\",\"age\":\"23\"}";
        return empBody;
    }
}
