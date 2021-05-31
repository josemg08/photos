import com.jose.photoalbum.model.AlbumModel
import com.jose.photoalbum.model.PhotoModel
import io.reactivex.subjects.BehaviorSubject

class MediaRepository {

    fun getListOfAlbumsObservable(): BehaviorSubject<List<AlbumModel>?> {
        return JsonPlaceHolderService().getListOfAlbums()
    }

    fun getListOfPhotosObservable(): BehaviorSubject<List<PhotoModel>?> {
        return JsonPlaceHolderService().getListOfPhotos()
    }

}