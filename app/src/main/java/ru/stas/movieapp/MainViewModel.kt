package ru.stas.movieapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.stas.movieapp.data.models.Movies
import ru.stas.movieapp.data.network.ApiRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiRepository: ApiRepository): ViewModel(){

    private val _allMovies = MutableLiveData<List<Movies>>()
    val allMovies: LiveData<List<Movies>>
    get() = _allMovies

    fun getAllMovies(){
        viewModelScope.launch {
            apiRepository.getAllMovie().let {
                if(it.isSuccessful){
                    _allMovies.postValue(it.body())
                }else{
                    Log.d("checkData","Failed to load movies: ${it.errorBody()}")
                }
            }
        }
    }
}