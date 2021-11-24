package a

class TestClass {
    fun testAction(fruitName: String): String {
        return when (fruitName) {
            "apple" -> "음 좋아"
            "banana" -> "음 싫어"
            else -> "음 모르겠어"
        }
    }
}