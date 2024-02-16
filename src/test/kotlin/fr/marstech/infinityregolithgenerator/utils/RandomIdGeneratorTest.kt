package fr.marstech.infinityregolithgenerator.utils

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe

private val logger: KLogger = KotlinLogging.logger {}

class RandomIdGeneratorTest : StringSpec() {

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
        "Ensure random ids generated as expected" {
            with(RandomIdGenerator.generate()) {
                logger.info { "Random id : $this" }
                this.length shouldBe RandomIdGenerator.DEFAULT_SIZE
                this.all { it.toString() in RandomIdGenerator.CHARSET } shouldBe true
            }

            val length = 16
            with(RandomIdGenerator.generate(length)) {
                logger.info { "Random id : $this" }
                this.length shouldBe length
                this.all { it.toString() in RandomIdGenerator.CHARSET } shouldBe true
            }
        }
        "Ensure random ids with prefix are generated as expected" {
            val prefix = "MT-"
            with(RandomIdGenerator.generate(prefix)) {
                logger.info { "Random id : $this" }
                this.length shouldBe RandomIdGenerator.DEFAULT_SIZE
            }
            val length = 16
            with(RandomIdGenerator.generate(prefix, length)) {
                logger.info { "Random id : $this" }
                this.length shouldBe length
            }
        }
    }
}