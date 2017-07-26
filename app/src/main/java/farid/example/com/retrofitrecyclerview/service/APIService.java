package farid.example.com.retrofitrecyclerview.service;

import java.util.List;

import farid.example.com.retrofitrecyclerview.model.ModelData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Farid on 09/05/2017.
 */

public interface APIService {

  //  @GET("mahasiswa")
    @GET("get_member")
    Call<List<ModelData>> getData();


 //   @GET("mahasiswa")
    @GET("detail")
    Call<List<ModelData>> getId(@Query("id_mhs") String param1);

   // @GET("mahasiswa")
    @GET("pencarian")
    Call<List<ModelData>> searchQuery(@Query("nama_mhs") String nama_mhs);


    @DELETE("hapusdata")
    Call<ResponseBody> deleteData(@Query("id_mhs") String id_mhs);



    @PUT("editdata")
    Call<ResponseBody> updateData(@Query("id_mhs") String id,
                                  @Query("nama_mhs") String nama,
                                  @Query("kelas_mhs") String kelas);


    @POST("insertdata")
    Call<ResponseBody> tambahData(@Query("nama_mhs") String nama,
                                  @Query("kelas_mhs") String kelas);


    @POST("register")
    Call<ResponseBody> registerAkun(@Query("username") String username,
                                    @Query("email") String email,
                                    @Query("password") String password);

    @POST("login")
    Call<ResponseBody> loginAkun(@Query("email") String email,
                                 @Query("password") String password);


//    @FormUrlEncoded
//    @PUT("mahasiswa")
//    Call<ResponseBody> updateData(@Field("id_mhs") String id,
//                                  @Field("nama_mhs") String nama,
//                                  @Field("kelas_mhs") String kelas);



   // @FormUrlEncoded
   // @HTTP(method = "DELETE" , path = "mahasiswa", hasBody = true)
  // Call<ResponseBody> deleteData(@Field("id_mhs") String id_mhs);




}
