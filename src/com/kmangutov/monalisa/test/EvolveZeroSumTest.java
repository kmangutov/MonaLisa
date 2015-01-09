package com.kmangutov.monalisa.test;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.chromosome.Gene;
import com.kmangutov.monalisa.crossover.CrossoverStrategy;
import com.kmangutov.monalisa.crossover.SingleLocusCrossoverImpl;
import com.kmangutov.monalisa.engine.Engine;
import com.kmangutov.monalisa.fitness.FitnessEvaluator;
import com.kmangutov.monalisa.mutation.MutationStrategy;
import com.kmangutov.monalisa.mutation.StandardMutationRandomImpl;
import com.kmangutov.monalisa.seed.ChromosomeFactory;
import com.kmangutov.monalisa.seed.GeneFactory;
import com.kmangutov.monalisa.seed.StaticChromosomeFactoryImpl;
import com.kmangutov.monalisa.selection.RankSelectionImpl;
import com.kmangutov.monalisa.selection.SelectionStrategy;
import org.junit.Test;

import java.util.Random;

/**
 * Created by kmangutov on 1/8/15.
 */
public class EvolveZeroSumTest {

    private static final int mChromosomeSize = 5;
    private static final int mPopulationSize = 6;
    private static final int mGeneRange = 60;

    @Test
    public void EvolveZeroSumTest() {

        NumberGeneFactory geneFactory = new NumberGeneFactory();
        ChromosomeFactory chromosomeFactory = new StaticChromosomeFactoryImpl(new NumberGeneFactory(), mChromosomeSize);

        MutationStrategy mutationStrategy = new StandardMutationRandomImpl(geneFactory);
        SelectionStrategy selectionStrategy = new RankSelectionImpl();
        CrossoverStrategy crossoverStrategy = new SingleLocusCrossoverImpl();

        FitnessEvaluator fitnessEvaluator = new ZeroSumFitnessEvaluator();

        Engine engine = new Engine();
        engine.setFitnessEvaluator(fitnessEvaluator);
        engine.setMutationStrategy(mutationStrategy);
        engine.setSelectionStrategy(selectionStrategy);
        engine.setCrossoverStrategy(crossoverStrategy);
        engine.setChromosomeFactory(chromosomeFactory);

        engine.initPopulation(mPopulationSize);

        for(int i = 0; i < 1000; i++) {

            System.out.println(engine.getBest());
            engine.iterate();
        }
    }

    class ZeroSumFitnessEvaluator implements FitnessEvaluator {

        private final int mDesiredProduct = 56;

        public float score(Chromosome chromosome) {

            int sum = 0;
            for(Gene g : chromosome)
                sum += ((SimpleGene) g).express();

            int product = 1;
            for(Gene g : chromosome)
                product *= ((SimpleGene) g).express();

            return Math.abs(sum) + Math.abs(mDesiredProduct - product);
        }
    }

    class NumberGeneFactory implements GeneFactory {

        protected Random mRandom;

        public NumberGeneFactory() {

            mRandom = new Random();
        }

        public Gene randomGene() {

            SimpleGene gene = new SimpleGene(mRandom.nextInt(mGeneRange) - mGeneRange/2);
            return gene;
        }
    }
}
