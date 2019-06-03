package com.example.training_4_29.calculator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class CalculationTextJava {

    @Mock
    Addition addition;

    Calculation calculation;

    public CalculationTextJava(){
        MockitoAnnotations.initMocks(this);
        calculation = new Calculation(addition);
    }


    @BeforeClass
    public static void setupClass(){

    }

    @Before
    public void setup(){

    }

    @Test
    public void add(){
        when(addition.add(4, 6)).thenReturn(5);
        assertEquals(15, calculation.addTen(4, 6));

    }


}
