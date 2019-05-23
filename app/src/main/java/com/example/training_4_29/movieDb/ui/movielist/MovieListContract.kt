package com.example.training_4_29.movieDb.ui.movielist

import com.example.training_4_29.movieDb.ui.base.BasePresenter
import com.example.training_4_29.movieDb.ui.base.BaseView

interface MovieListContract {

    interface View: BaseView{

    }

    interface Presenter: BasePresenter<View>{
        
    }
}