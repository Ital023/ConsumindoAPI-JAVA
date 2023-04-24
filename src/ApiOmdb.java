public class ApiOmdb extends Api{


    public ApiOmdb(String apiKey) {
        super(apiKey);
    }
    public String gerandoApiRequest(String filme){
        return "http://www.omdbapi.com/?t="+filme.replace(" ","+")+"&apikey="+getApiKey();
    }
}
