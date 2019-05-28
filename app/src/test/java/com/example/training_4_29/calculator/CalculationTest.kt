package com.example.training_4_29.calculator

import junit.framework.Assert.assertEquals
import org.junit.*
import org.mockito.Mock



import org.mockito.MockitoAnnotations

class CalculationTest {

    var calculation: Calculation? = null

    @Mock
    lateinit var addition: Addition
    companion object {
        @BeforeClass
        @JvmStatic
        fun setupClass() {
            println("CalculationTest.setupClass")
            MockitoAnnotations.initMocks(this)

        }

        @AfterClass
        @JvmStatic
        fun tearDownClass() {
            println("CalculationTest.tearDownClass")

        }
    }

    @Before
    fun setUp() {
        println("CalculationTest.setUp")
        calculation = Calculation(addition)
    }

    @After
    fun tearDown() {
        println("CalculationTest.tearDown")
        calculation = null
    }


    @Test
    fun add() {
        println("CalculationTest.add")
        //when(addition.add(4,1)).thenReturn(5)
        assertEquals(15, calculation?.addTen(4, 1))

    }

    @Test
    fun subtract() {
        println("CalculationTest.subtract")
    }
}