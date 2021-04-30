package com.example.tmdbapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbapp.data.api.models.TmdbResponseDTO
import com.example.tmdbapp.repos.TmdbRepo
import com.google.gson.annotations.SerializedName
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    var filmTitle: String = ""
    var filmOverview: String = ""
    var filmReleaseDate: String = ""
    var filmPopularity: String = ""
    var filmPosterPath: String = ""
    var filmVoteAverage: String = ""
    var filmVoteCount: String = ""
    private val disposable = CompositeDisposable()
    private val tmdbRepo: TmdbRepo by lazy {
        TmdbRepo()
    }

    private var _tmdbInfo = MutableLiveData<TmdbResponseDTO>()
    val tmdbInfo get() = _tmdbInfo

    init{getTmdbPopData()}

//    private fun getTmdbPopData() =
//        disposable.add(
//            tmdbRepo.getPopularTmdb().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::onGetTmdbSuccess, this::onGetTmdbError)
//
//        )

    fun getTmdbPopData(){
        viewModelScope.launch {
            try {
                val getPop = async{tmdbRepo.getPopularTmdb()}
                tmdbInfo.value = getPop.await().body()
            }catch (e: Exception){
                onGetTmdbError(e)
            }
        }
    }


    private fun onGetTmdbSuccess(tmdbInfo: TmdbResponseDTO) {
        _tmdbInfo.value = tmdbInfo
    }

    private fun onGetTmdbError(e: Throwable) {
        e.message.let { Log.d(TAG, it.toString()) }
    }

    companion object {
        private val TAG = MainViewModel::class.java.name
    }

}