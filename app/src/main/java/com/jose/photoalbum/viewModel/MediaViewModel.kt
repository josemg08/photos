package com.jose.photoalbum.viewModel

import com.jose.photoalbum.model.AlbumModel
import com.jose.photoalbum.model.PhotoModel
import io.reactivex.subjects.BehaviorSubject
import MediaRepository

class MediaViewModel {

    var subjectListOfAlbums = BehaviorSubject.create<List<AlbumModel>>()
    var subjectListOfPhotos = BehaviorSubject.create<List<PhotoModel>>()

    fun onLoadPhotos(): BehaviorSubject<List<PhotoModel>?> {
        MediaRepository().getListOfPhotosObservable().subscribe {
            subjectListOfPhotos.onNext(it!!)
        }
        return subjectListOfPhotos
    }

    fun onLoadAlbums(): BehaviorSubject<List<AlbumModel>?> {
        MediaRepository().getListOfAlbumsObservable().subscribe {
            subjectListOfAlbums.onNext(it!!)
        }
        return subjectListOfAlbums
    }

}