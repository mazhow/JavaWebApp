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
        assertThat(queryProcessor.process("b04e7820: largest:30,237,32,28"), containsString("237"));
        assertThat(queryProcessor.process("b04e7820: largest: 89, 382"), containsString("382"));
        assertThat(queryProcessor.process("b04e7820: largest: 187, 237, 26, 55"), containsString("237"));
    }

    @Test
    public void returnsSumOfTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("b04e7820: what is 17 plus 1"), containsString("18"));
    }

    @Test
    public void returnsProductOfTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("b04e7820: what is 18 multiplied by 12"), containsString("216"));
    }

    @Test
    public void returnsColourOfBanana() throws Exception {
        assertThat(queryProcessor.process("b04e7820: what colour is a banana"), containsString("yellow"));
    }

    @Test
    public void returnsJamesBondActor() throws Exception {
        assertThat(queryProcessor.process("b04e7820: james Bond in the film Dr No"), containsString("sean connery"));
    }

    @Test
    public void returnsPrimeNumbers() throws Exception {
        assertThat(queryProcessor.process("b04e7820: primes: 107, 349, 399, 400"), containsString("107, 349"));
    }

    @Test
    public void returnsCityParis() throws Exception {
        assertThat(queryProcessor.process("b04e7820: Eiffel Tower"), containsString("Paris"));
    }

}
