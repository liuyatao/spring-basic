package com.github.liuyatao.springbasic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * MockitoTest
 */
@ExtendWith(MockitoExtension.class)
public class MockitoTest {


    @Spy
    private List<String> spyList = new ArrayList<String>();

    @Mock
    private List<String> mockList = new ArrayList<String>();

    @Test
    public void spy_test() {

        spyList.add("one");
        spyList.add("two");

        verify(spyList).add("one");
        verify(spyList).add("two");

        assertThat(spyList.size(),is(2));

        mockList.add("one");
        mockList.add("two");

        verify(mockList).add("one");
        verify(mockList).add("two");

        assertThat(mockList.size(),is(0));

        //No type safety
        Mockito.doReturn(100).when(spyList).size();
        assertThat(spyList.size(),is(100));

        //No type safety
        Mockito.doReturn(100).when(mockList).size();
        assertThat(mockList.size(),is(100));

        Mockito.when(mockList.size()).thenReturn(100);
        assertThat(mockList.size(),is(100));

    }


    public void bdd_test() {
        
    }
}