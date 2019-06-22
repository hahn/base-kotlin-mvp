package id.example.mvp.core.ext.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

class ComputationMainScheduler<T> protected constructor() : BaseScheduler<T>(Schedulers.computation(), AndroidSchedulers.mainThread())