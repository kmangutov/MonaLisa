package com.kmangutov.monalisa.test;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.chromosome.Gene;
import com.kmangutov.monalisa.crossover.SingleLocusCrossoverImpl;
import com.sun.tools.javac.jvm.Gen;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by kmangutov on 1/8/15.
 */
public class SingleLocusCrossoverImplTest{

    private static final int NUM_TEST_GENES = 10;

    private SingleLocusCrossoverImpl impl;

    @Before
    public void init() {

        impl = new SingleLocusCrossoverImpl();
    }

    @Test
    public void testSingleLocusCrossoverImpl() {

        Chromosome a = new Chromosome();
        Chromosome b = new Chromosome();

        for(int i = 0; i < NUM_TEST_GENES; i++) {

            Gene gene = new SimpleGene(i);
            if(i < NUM_TEST_GENES / 2)
                a.add(gene);
            else
                b.add(gene);
        }

        Map<Gene, Integer> before = add(count(a), count(b));
        Pair<Chromosome, Chromosome> newCs = impl.crossover(a, b);
        Map<Gene, Integer> after = add(count(newCs.getKey()), count(newCs.getValue()));

        assertTrue(equal(before, after));
    }

    public Map<Gene, Integer> add(Map<Gene, Integer> a, Map<Gene, Integer> b) {

        Map<Gene, Integer> result = new HashMap<Gene, Integer>(a);
        for(Gene g : b.keySet()) {

            if(result.containsKey(g))
                result.put(g, result.get(g) + 1);
            else
                result.put(g, 1);
        }
        return result;
    }

    public Map<Gene, Integer> count(Chromosome c) {

        Map<Gene, Integer> result = new HashMap<Gene, Integer>();
        for(Gene g : c) {

            if(result.containsKey(g))
                result.put(g, result.get(g) + 1);
            else
                result.put(g, 1);
        }

        System.out.println("----------");
        for(Map.Entry<Gene, Integer> entry : result.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

        return result;
    }

    public boolean equal(Map<Gene, Integer> a, Map<Gene, Integer> b) {

        Set<Gene> seen = new HashSet<Gene>();

        System.out.println("----------");
        for(Map.Entry<Gene, Integer> entry : a.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue() + " = " + b.get(entry.getKey()) + "?");
            seen.add(entry.getKey());
            if(entry.getValue() != b.get(entry.getKey()))
                return false;
        }

        System.out.println(seen.size() + " = " + b.size() + "?");
        return seen.size() == b.size();
    }
}
