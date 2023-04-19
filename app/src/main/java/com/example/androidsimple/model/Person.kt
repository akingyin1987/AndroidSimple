package com.example.androidsimple.model

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/17 11:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/17 11:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class Person {

    var  name:String =""
    var  age : Int = 0
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }


}