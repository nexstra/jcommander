package com.beust.jcommander.command

import com.beust.jcommander.IStringConverter
import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter
import com.beust.jcommander.command.CommandWithLazyNonNull.IntContainer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CommandWithLazyNonNull {

    data class IntContainer(val int:Int)

    @Parameter(names = ["--int","-i"], converter = IntContainerConverter::class)
    lateinit var container: IntContainer

    @Parameter(names = ["--parsed"])
    var parsed: Boolean = false

}


class IntContainerConverter() : IStringConverter<IntContainer> {
    override fun convert(value: String?): IntContainer = value?.let { IntContainer(it.toInt()) } ?: IntContainer(0)
}

class CommandWithLazyNonNullTest {

    @Test
    fun testParseWithLazy() {
        val expectedInt = 10
        val c = CommandWithLazyNonNull()
        val jc = JCommander.newBuilder().addObject(c).args(arrayOf("--parsed","-i","$expectedInt")).build()
        assertTrue(c.parsed)
        assertEquals(expectedInt, c.container.int)
    }

}