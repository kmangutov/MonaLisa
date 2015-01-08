package com.kmangutov.monalisa.population;

import com.google.common.collect.TreeMultimap;
import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.fitness.FitnessEvaluator;
import com.kmangutov.monalisa.seed.ChromosomeFactory;
import com.kmangutov.monalisa.seed.GeneFactory;

import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by kmangutov on 1/8/15.
 */
public class Population extends Vector<Chromosome>
{
    protected int mSize = 20;
    //protected Vector<Chromosome> mIndividuals;

    public Population() {

    }

    public Population(int size) {

        mSize = size;
    }

    public void setSize(int size) {

        mSize = size;
    }

    public void seed(ChromosomeFactory chromosomeFactory) {

        for(int i = 0; i < mSize; i++)
            add(chromosomeFactory.randomChromosome());
    }

    public TreeMultimap<Float, Chromosome> map(FitnessEvaluator eval) {

        TreeMultimap<Float, Chromosome> mapping = TreeMultimap.create();

        for(Chromosome c : this) {

            float fitness = eval.score(c);
            mapping.put(fitness, c);
        }

        return mapping;
    }
}
