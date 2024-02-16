package fr.marstech.infinityregolithgenerator

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest

private val logger: KLogger = KotlinLogging.logger {}

@SpringBootTest
class InfinityRegolithGeneratorApplicationTests() : StringSpec() {

    /**
     * Run once before the first test method for all tests in class
     */
    override suspend fun beforeSpec(spec: Spec) {}

    /**
     * Run before each test method
     */
    override suspend fun beforeTest(testCase: TestCase) {}

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {}

    override suspend fun afterSpec(spec: Spec) {}

    init {
        "Ensure test are loading" {
            this shouldNotBe null
            logger.info { "Tests are loaded" }
        }
    }
}
