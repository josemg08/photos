import com.jose.photoalbum.model.AlbumModel
import com.jose.photoalbum.model.PhotoModel

import retrofit2.http.GET
import retrofit2.Call

interface JsonPlaceHolderClient {

    @GET("albums")
    fun getListOfAlbums(): Call<List<AlbumModel>>

    @GET("photos")
    fun getListOfPhotos(): Call<List<PhotoModel>>

}