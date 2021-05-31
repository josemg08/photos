import com.jose.photoalbum.model.AlbumModel
import com.jose.photoalbum.model.PhotoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.subjects.BehaviorSubject

class JsonPlaceHolderService {

    var subjectListOfAlbums = BehaviorSubject.create<List<AlbumModel>>()
    var subjectListOfPhotos = BehaviorSubject.create<List<PhotoModel>>()

    fun getListOfAlbums(): BehaviorSubject<List<AlbumModel>?> {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JsonPlaceHolderClient::class.java)
        val jsonCall = service.getListOfAlbums()
        jsonCall.enqueue(object : Callback<List<AlbumModel>> {
            override fun onResponse(call: Call<List<AlbumModel>>, response: Response<List<AlbumModel>>) {
                subjectListOfAlbums.onNext(response.body()!!)
            }

            override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                //TODO
            }
        })

        return subjectListOfAlbums
    }

    fun getListOfPhotos(): BehaviorSubject<List<PhotoModel>?> {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JsonPlaceHolderClient::class.java)
        val jsonCall = service.getListOfPhotos()
        jsonCall.enqueue(object : Callback<List<PhotoModel>> {
            override fun onResponse(call: Call<List<PhotoModel>>, response: Response<List<PhotoModel>>) {
                subjectListOfPhotos.onNext(response.body()!!)
            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                //TODO
            }
        })

        return subjectListOfPhotos
    }

    companion object {
        const val SERVICE_URL = "https://jsonplaceholder.typicode.com/"
    }

}