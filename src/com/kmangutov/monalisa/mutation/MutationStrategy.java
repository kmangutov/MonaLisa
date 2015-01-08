package com.kmangutov.monalisa.mutation;

import com.kmangutov.monalisa.chromosome.Chromosome;

/**
 * Created by kmangutov on 1/8/15.
 */
public interface MutationStrategy {

    public abstract Chromosome mutate(Chromosome c);
}
