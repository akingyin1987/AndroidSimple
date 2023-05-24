package com.example.androidsimple.utils

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/19 12:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/19 12:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
object RandomUtil {

    private val rangeForRandom = (0..100000)
    fun randomSampleImageUrl(
        seed: Int = rangeForRandom.random(),
        width: Int = 300,
        height: Int = width
    ): String {
        return "https://picsum.photos/seed/$seed/$width/$height"
    }
}