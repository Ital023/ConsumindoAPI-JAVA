public class Api {
    private String apiKey;

    public Api(String apiKey) {
        this.apiKey = apiKey;
    }
    public String gerandoApiRequest(String filme){
        return "http://www.omdbapi.com/?t="+filme.replace(" ","+")+"&apikey="+apiKey;
    }
}
