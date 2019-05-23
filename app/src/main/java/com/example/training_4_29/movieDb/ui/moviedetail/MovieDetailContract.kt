package com.example.training_4_29.movieDb.ui.moviedetail

import com.example.training_4_29.movieDb.ui.base.BasePresenter
import com.example.training_4_29.movieDb.ui.base.BaseView

interface MovieDetailContract {

    interface View: BaseView{

    }

    interface Presenter: BasePresenter<View>{

    }
}