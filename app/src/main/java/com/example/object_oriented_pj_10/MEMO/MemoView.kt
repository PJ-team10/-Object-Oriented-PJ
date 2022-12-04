package com.example.object_oriented_pj_10.MEMO


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MemoView : ViewModel() {
    private val repository = MyMemoRepository()

    private val _newMemos = MutableLiveData<ArrayList<MemoList>>();
    val newMemos : LiveData<ArrayList<MemoList>> get() = _newMemos;

    fun getPosts() {
        viewModelScope.launch {
            repository.getMemos()?.let { jsonPosts ->
                val pList = ArrayList<MemoList>()
                for (idx in 0 until jsonPosts.size){
                    jsonPosts.get(idx)?.let{obj ->
                        pList += MemoList(obj.title, obj.date, obj.description)
                    }
                }
                _newMemos.value = pList
            }
        }
    }
}


/*
* */