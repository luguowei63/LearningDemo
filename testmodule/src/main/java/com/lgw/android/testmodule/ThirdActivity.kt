package com.lgw.android.testmodule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate


class ThirdActivity : AppCompatActivity() {


    private val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        subscribe()
    }


//    private fun createObservable(): Observable<Long> {

//        return Observable.create {
//            it.onNext(1)
//            it.onNext(2)
//            it.onNext(3)
//            it.onNext(4)
//            it.onNext(5)
//            it.onNext(6)
//            it.onNext(7)
//            it.onNext(8)
//            it.onNext(9)
//            it.onNext(10)
//            it.onNext(11)
//            it.onNext(12)
//            it.onNext(13)
//            it.onNext(14)
//            it.onNext(15)
//            it.onComplete()
//        }
//        return  Observable.error(Throwable(" Exception "))


//        return Observable.intervalRange(3,10,5,1,TimeUnit.SECONDS).map(Function<String, Long> {
//
//         it.toLong()
//        })
//        return Observable.create<Int> { emitter ->
//            emitter.onNext(1)
//            emitter.onNext(2)
//            emitter.onNext(3)
//        }.map { integer -> integer.toLong() }
//
//
//    }

//    private fun createObserver(): Observer<Long> {
//        return object : Observer<Long> {
//
//            override fun onSubscribe(d: Disposable) {
//                Log.e("TAG", "onSubscribe")
//            }
//
//            override fun onNext(t: Long) {
//                Log.e("TAG", "onNext  $t")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e("TAG", "onError " + e.printStackTrace())
//
//            }
//
//            override fun onComplete() {
//                Log.e("TAG", "onComplete")
//            }
//        }
//    }
//    private fun createConsumer():Consumer<Long>  {
//        return Consumer<Long> { Log.e("TAG",it.toString())}
//    }

    private fun subscribe() {

        //采用RxJava基于时间流的链式操作
//        Observable.create(ObservableOnSubscribe<Int> {
//            it.onNext(1)
//            it.onNext(2)
//            it.onNext(3)
//            //采用flatMap()变换操作符
//        }).concatMap( object :Function <Int,ObservableSource<String>>{
//            override fun apply(t: Int): ObservableSource<String> {
//                var observable=Observable.just(t.toString())
//                Log.e("TAG", "onComplete   "+observable.toString())
//                return  observable
//            }
//        }).subscribe(object :Consumer<String>{
//            override fun accept(t: String?) {
//                Log.e("TAG", t)
//            }
//        })

        //被观察者需要发送5个数字
//        Observable.just(1, 2, 3, 4, 5).buffer(3, 1)
//            .subscribe(object : Observer<List<Int>> {
//                override fun onSubscribe(d: Disposable) {
//                }
//
//                override fun onNext(stringList: List<Int>) {
//                    Log.e("TAG", " 缓存区里的事件数量 = " + stringList.size)
//                    for (value in stringList) {
//                        Log.e("TAG", " 事件 = $value")
//                    }
//                }
//
//                override fun onError(e: Throwable) {
//                }
//
//                override fun onComplete() {
//                    Log.e("TAG", "对Complete事件作出响应");
//                }
//
//            })


        // concat():组合多个被观察者（<=4）一起发送数据
        //注:串行执行
//        Observable.concat(
//            Observable.just(1, 2, 3),
//            Observable.just(4, 5, 6),
//            Observable.just(7, 8, 9),
//            Observable.just(10, 11, 12)
//        ).subscribe(object :Observer<Int>{
//            override fun onSubscribe(d: Disposable) {
//            }
//
//            override fun onNext(t: Int) {
//                Log.e("TAG",t.toString())
//            }
//
//            override fun onError(e: Throwable) {
//            }
//
//            override fun onComplete() {
//                Log.e("TAG","onComplete")
//            }
//
//        })


        //merge():组合多个被观察者(<4) 一起发送数据
        //注：合并后按照时间线并行执行
//        Observable.merge(
//            Observable.intervalRange(0, 4, 1, 1, TimeUnit.SECONDS),
//            Observable.intervalRange(3, 3, 1, 1, TimeUnit.SECONDS)
//        ).subscribe(object : Observer<Long> {
//            override fun onSubscribe(d: Disposable) {
//            }
//
//            override fun onNext(value: Long) {
//                Log.e("TAG", "接收到了事件$value");
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e("TAG", "onError");
//            }
//
//            override fun onComplete() {
//                Log.e("TAG", "onComplete");
//            }
//
//        })

//        Observable.concatArrayDelayError(
//            Observable.create(ObservableOnSubscribe<Int> {
//                it.onNext(1)
//                it.onNext(2)
////                it.onComplete()
//
//                it.onNext(3)
//                it.onError(NullPointerException())
//
//
//            }),
//            Observable.just(4, 5, 6)
//        ).subscribe(object : Observer<Int> {
//            override fun onSubscribe(d: Disposable) {
//                Log.e(TAG, "onSubscribe");
//            }
//
//            override fun onNext(t: Int) {
//                Log.e(TAG, "onNext   $t");
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e(TAG, "onError");
//            }
//
//            override fun onComplete() {
//                Log.e(TAG, "onComplete");
//            }
//
//        })
//
//


        //创建第一个被观察者
//        val observable1 = Observable.create(ObservableOnSubscribe<Int> {
//
//            it.onNext(1)
//            Log.e(TAG, "onNext  1")
////            Thread.sleep(1000)
//
//            it.onNext(2)
//            Log.e(TAG, "onNext  2")
////            Thread.sleep(1000)
//            it.onNext(3)
//            Log.e(TAG, "onNext  3")
////            Thread.sleep(1000)
//            it.onNext(4)
//            Log.e(TAG, "onNext  4")
////            Thread.sleep(1000)
//            it.onComplete()
//        })
//
//        //创建第二个被观察者
//        val observable2 = Observable.create(ObservableOnSubscribe<String> {
//            Log.e(TAG, "onNext  A")
//            it.onNext("A")
//
////            Thread.sleep(1000)
//            Log.e(TAG, "onNext  B")
//            it.onNext("B")
//
////            Thread.sleep(1000)
//            Log.e(TAG, "onNext  C")
//            it.onNext("C")
//
////            Thread.sleep(1000)
//            Log.e(TAG, "onNext  D")
//            it.onNext("D")
//
////            Thread.sleep(1000)
//        })
//
//        Observable.zip(observable1, observable2,
//            { t1, t2 -> return@zip t2 + t1.toString() }).subscribe(object : Observer<String> {
//            override fun onSubscribe(d: Disposable) {
//                Log.e(TAG, "onSubscribe")
//            }
//
//            override fun onNext(t: String) {
//                Log.e(TAG, "onNext  $t")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e(TAG, "onError")
//            }
//
//            override fun onComplete() {
//                Log.e(TAG, "onComplete ")
//            }
//        })

//
//        Observable.create(ObservableOnSubscribe<Int> {
//            it.onNext(1)
//            it.onNext(2)
//            it.onNext(3)
//            it.onNext(4)
//            it.onComplete()
////            it.onError(Throwable("发生错误了"))
//        })
//            //1、当Observable每发送一次数据事件就会调用一次
//            .doOnEach(Consumer<Notification<Int>> {
//                Log.e(TAG, "doOnEach    ${it.value}")
//            })
//            //2、执行Next 事件前调用
//            .doOnNext(Consumer<Int> {
//                Log.e(TAG, "doOnNext    $it")
//            })
//            //3、执行Next事件后调用
//            .doAfterNext(Consumer<Int> {
//                Log.e(TAG, "doAfterNext    $it")
//            })
//            //4、Observable正常发送事件完毕后调用
//            .doOnComplete(Action {
//                Log.e(TAG, "doOnComplete  ")
//
//            })
//            //5、Observable发送错误事件调用
//            .doOnError(Consumer<Throwable> {
//                Log.e(TAG, "doOnError  " + it.message)
//            })
//            //6、观察者订阅时调用
//            .doOnSubscribe(Consumer<Disposable> {
//                Log.e(TAG, "doOnSubscribe  ${it.toString()}")
//            })
//            //7、最后执行
//            .doFinally(Action {
//                Log.e(TAG, "doFinally ")
//
//            })
//            //8、Observable 发送事件完毕后调用，无论正常发送完毕/异常终止
//            .doAfterTerminate(Action {
//                Log.e(TAG, "doAfterTerminate ")
//            })
//            .subscribe(object : Observer < Int >{
//                override fun onSubscribe(d: Disposable) {
//                    Log.e(TAG, "Observer  onSubscribe ")
//
//                }
//
//                override fun onNext(t: Int) {
//                    Log.e(TAG, "Observer  onNext      $t ")
//
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.e(TAG, "Observer  onError ")
//
//                }
//
//                override fun onComplete() {
//                    Log.e(TAG, "Observer  onComplete ")
//
//                }
//
//            })


        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onError(Throwable("发生了错误"))
        })
            .retry(3, Predicate <Throwable>{
                Log.e(TAG,it.message!!)
                true
            })

//            .onErrorReturn (Function<Throwable,Int> {
//            Log.e(TAG,it.message!!)
//            return@Function 666
//        })

            .subscribe(object :Observer<Int>{
            override fun onSubscribe(d: Disposable) {
                Log.e(TAG,"onSubscribe ")

            }

            override fun onNext(t: Int) {
                Log.e(TAG,"onNext $t")

            }

            override fun onError(e: Throwable) {
                Log.e(TAG,"onError")

            }

            override fun onComplete() {
                Log.e(TAG,"onComplete")

            }
        })


































    }

}