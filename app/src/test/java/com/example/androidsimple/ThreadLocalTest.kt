package com.example.androidsimple

import com.example.androidsimple.model.Person
import org.junit.Test
import kotlin.concurrent.thread


/**
 *ThreadLocal叫做线程变量，意思是ThreadLocal中填充的变量属于当前线程，
 * 该变量对其他线程而言是隔离的，也就是说该变量是当前线程独有的变量。ThreadLocal为变量在每个线程中都创建了一个副本，
 * 那么每个线程可以访问自己内部的副本变量。
 * ThreadLocal 变量，线程局部变量，同一个 ThreadLocal 所包含的对象，在不同的 Thread 中有不同的副本。这里有几点需要注意
 * 因为每个 Thread 内有自己的实例副本，且该副本只能由当前 Thread 使用。这是也是 ThreadLocal 命名的由来。
 * 既然每个 Thread 有自己的实例副本，且其它 Thread 不可访问，那就不存在多线程间共享的问题。
 * ThreadLocal 提供了线程本地的实例。它与普通变量的区别在于，每个使用该变量的线程都会初始化一个完全独立的实例副本。
 * ThreadLocal 变量通常被private static修饰。当一个线程结束时，它所使用的所有 ThreadLocal 相对的实例副本都可被回收
 *
 *  总的来说，ThreadLocal 适用于每个线程需要自己独立的实例且该实例需要在多个方法中被使用，也即变量在线程间隔离而在方法或类间共享的场景
 */
class ThreadLocalTest {

    /** 声明一个ThreadLocal 成员变量 */
    private  val t1 : ThreadLocal<Person> = ThreadLocal()

    /** 声明一个list 作为参照对象 */
    private val list= ArrayList<Person>()


    /**
     * 测试隔离性
     */
    @Test
    fun  testIsolation(){
        val person = Person().apply {
            age = 2
            name ="test2"
        }

        //创建线程1；再启动1s后分别 添加person 对象到t1,list 对象中
        thread(name = "Thread-1", start = true) {
            Thread.sleep(1000)
            t1.set(person)
            list.add(person)
            println(Thread.currentThread().name + " [thread] get():" + t1.get())
            println(Thread.currentThread().name + " [list] get():" + list[0])
            Thread.sleep(2000)
            println(Thread.currentThread().name + "2 [thread] get():" + t1.get())
            println(Thread.currentThread().name + "2 [list] get():" + list[0])
        }
        //创建线程2；再启动1s后分别 t1,list 取person对象
        thread(name = "Thread-2", start = true) {
            Thread.sleep(2000)
            println(Thread.currentThread().name + " [thread] get():" + t1.get())
            println(Thread.currentThread().name + " [list] get():" + list[0])

            Thread.sleep(1000)
            println(Thread.currentThread().name + "2 [thread] get():" + t1.get())
            println(Thread.currentThread().name + "2 [list] get():" + list[0])
        }
        Thread.sleep(5000)

    }

}