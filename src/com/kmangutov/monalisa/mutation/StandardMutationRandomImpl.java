package com.kmangutov.monalisa.mutation;

import com.kmangutov.monalisa.chromosome.Gene;
import com.kmangutov.monalisa.seed.GeneFactory;

/**
 * Created by kmangutov on 1/8/15.
 */
public class StandardMutationRandomImpl extends StandardMutationImpl {

    protected GeneFactory mGeneFactory;

    public StandardMutationRandomImpl(GeneFactory geneFactory) {

        mGeneFactory = geneFactory;
    }

    public Gene mutate(Gene gene) {

        return mGeneFactory.randomGene();
    }
}