package com.kmangutov.monalisa.test;

import com.kmangutov.monalisa.chromosome.Gene;

/**
 * Created by kmangutov on 1/8/15.
 */
public class SimpleGene implements Gene {

    public int mNumber;

    public SimpleGene(int number) {

        this.mNumber = number;
    }

    public int express() {

        return mNumber;
    }

    public String toString() {

        return express() + "";
    }
}
