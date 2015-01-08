package com.kmangutov.monalisa.chromosome;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;

/**
 * Created by kmangutov on 1/8/15.
 */
public class Chromosome extends Vector<Gene> implements Comparable
{
    public Chromosome() {

    }

    public Chromosome(List<Gene> geneList) {

        this.addAll(geneList);
    }

    public Chromosome sublist(int indexA, int indexB) {

        return new Chromosome(super.subList(indexA, indexB));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
