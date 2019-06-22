package id.web.hn.basekotlinmvp.core.ext.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

class TrampolineMainScheduler<T> protected constructor() : BaseScheduler<T>(Schedulers.trampoline(), AndroidSchedulers.mainThread())