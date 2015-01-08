package com.kmangutov.monalisa.fitness;

import com.kmangutov.monalisa.chromosome.Chromosome;

/**
 * Created by kmangutov on 1/8/15.
 */
public interface FitnessEvaluator {

    public float score(Chromosome c);
}
