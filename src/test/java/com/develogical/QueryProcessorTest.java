package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutHopper() throws Exception {
        assertThat(queryProcessor.process("Hopper"), containsString("programmer"));
    }

    @Test
    public void knowsYourName() throws Exception {
        assertThat(queryProcessor.process("what is your name?"), containsString("MarieSidd"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void returnsLargerOfFollowingNumbers() throws Exception {
//        assertThat(queryProcessor.process("largest:30,237,32,28"), containsString("237"));
        assertThat(queryProcessor.process("largest:813,65"), containsString("813"));

    }

    @Test
    public void returnsSumOfTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 17 plus 1"), containsString("18"));
    }

    @Test
    public void returnsProductOfTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 18 multiplied by 15"), containsString("270"));
    }


}
