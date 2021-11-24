import a.TestClass
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestTest {
    private val testClass = TestClass()

    @Test
    fun testActionTest() {
        val fruitName = "apple"

        val evaluationMessage = testClass.testAction(fruitName)

        assertEquals("음 좋아", evaluationMessage)
    }
}