package com.kmangutov.monalisa.selection;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.fitness.FitnessEvaluator;
import com.kmangutov.monalisa.population.Population;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by kmangutov on 1/8/15.
 */
public class RankSelectionImpl extends SelectionStrategy {

    protected Random mRandom = new Random();

    public RankSelectionImpl(FitnessEvaluator eval) {

        super(eval);
    }

    public Pair<Chromosome, Chromosome> select(Population population) {

        TreeMap<Float, Chromosome> mapping = population.map(mEvaluator);
        Chromosome first = null;
        Chromosome second = null;
        int counter = 0;

        for(Map.Entry<Float, Chromosome> entry : mapping.entrySet()) {

            if(mRandom.nextFloat() < selectionChance(counter, population.size()) || counter++ >= mapping.size() -2) {

                if(first == null)
                    first = entry.getValue();
                else {
                    second = entry.getValue();
                    return new Pair<Chromosome, Chromosome>(first, second);
                }
            }
        }

        return new Pair<Chromosome, Chromosome>(first, second);
    }

    public float selectionChance(int i, int total) {

        return 0.3f;
    }
}
