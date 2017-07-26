package farid.example.com.retrofitrecyclerview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Farid on 30/05/2017.
 */

public class ModelResult {

    @SerializedName("result")
    @Expose
    private Integer result;

    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getResult() {
        return result;
    }


    public Data getData() {
        return data;
    }





    public class Data {

        @SerializedName("id_user")
        @Expose
        private String idUser;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("email")
        @Expose
        private String email;

        public String getIdUser() {
            return idUser;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

    }


}
