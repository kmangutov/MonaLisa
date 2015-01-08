package com.kmangutov.monalisa.seed;

import com.kmangutov.monalisa.chromosome.Chromosome;

/**
 * Created by kmangutov on 1/8/15.
 */
public class StaticChromosomeFactoryImpl implements ChromosomeFactory {

    protected GeneFactory mGeneFactory;
    protected int mChromosomeSize;

    public StaticChromosomeFactoryImpl(GeneFactory geneFactory, int chromosomeSize) {

        mGeneFactory = geneFactory;
        mChromosomeSize = chromosomeSize;
    }

    public Chromosome randomChromosome() {

        Chromosome chromosome = new Chromosome();

        for(int i = 0; i < mChromosomeSize; i++) {
            chromosome.add(mGeneFactory.randomGene());
        }

        return chromosome;
    }
}
