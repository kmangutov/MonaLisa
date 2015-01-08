package com.kmangutov.monalisa.engine;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.crossover.CrossoverStrategy;
import com.kmangutov.monalisa.mutation.MutationStrategy;
import com.kmangutov.monalisa.population.Population;
import com.kmangutov.monalisa.seed.ChromosomeFactory;
import com.kmangutov.monalisa.seed.GeneFactory;
import com.kmangutov.monalisa.selection.SelectionStrategy;

import java.util.TreeMap;

/**
 * Created by kmangutov on 1/8/15.
 */
public class Engine {

    protected ChromosomeFactory mChromosomeFactory;
    protected Population mPopulation;

    protected SelectionStrategy mSelectionStrategy;
    protected MutationStrategy mMutationStrategy;
    protected CrossoverStrategy mCrossoverStrategy;

    public Engine() {

    }

    public Engine initPopulation(int size) {

        if(mPopulation == null)
            mPopulation = new Population(size);
        else
            mPopulation.setSize(size);

        mPopulation.seed(mChromosomeFactory);

        return this;
    }

    public Engine setChromosomeFactory(ChromosomeFactory chromosomeFactory) {

        mChromosomeFactory = chromosomeFactory;
        return this;
    }

    public TreeMap<Float, Chromosome> iterate() {

        return null;
    }
}
