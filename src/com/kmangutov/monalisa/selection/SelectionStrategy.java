package com.kmangutov.monalisa.selection;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.fitness.FitnessEvaluator;
import com.kmangutov.monalisa.population.Population;
import javafx.util.Pair;

import java.util.TreeMap;

/**
 * Created by kmangutov on 1/8/15.
 */
public abstract class SelectionStrategy {

    protected FitnessEvaluator mEvaluator;

    public SelectionStrategy(FitnessEvaluator eval) {

        mEvaluator = eval;
    }

    public abstract Pair<Chromosome, Chromosome> select(Population population);
}
