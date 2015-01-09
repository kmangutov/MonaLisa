# MonaLisa

<img src="http://i.imgur.com/Jbvt5GL.png"
 alt="MonaLisa" title="MonaLisa" align="right" width="278" height="400"/>

MonaLisa is a Java Genetic Algorithm implementation with a focus on ease of use and extensibility.

## Usage

To use MonaLisa to solve a problem, take the following steps

1. Define **Genes** that make up the solution to the problem
2. Define a **GeneFactory** that produces random Genes
3. Define a **ChromosomeFactory** that describes how to create **Chromosomes** from Genes
4. Define a **FitnessEvaluator** to judge viability of Chromosomes
5. Select a **SelectionStrategy** that describes how to select candidates for reproduction
6. Select a **CrossoverStrategy** that breeds two Chromosomes to produce offspring
7. Select a **MutationStategy** that describes how to perform mutation on Chromosomes

Now, you can easily iterate through generations with one function call.

## Example

In this example we will be using MonaLisa to evolve an array of numbers that sum to 0 but have a product of 56. Our **Gene** will represent a single integer of this array.

```Java
public class SimpleGene implements Gene {

    public int mNumber;

    public SimpleGene(int number) {

        this.mNumber = number;
    }

    public int express() {

        return mNumber;
    }

    public String toString() {

        return express() + "";
    }
}

```

We need to define a **GeneFactory** to produce **Genes**.

```Java
public class NumberGeneFactory implements GeneFactory {

    protected final int mGeneRange = 60;
    protected Random mRandom;

    public NumberGeneFactory() {

        mRandom = new Random();
    }

    public Gene randomGene() {

        SimpleGene gene = new SimpleGene(mRandom.nextInt(mGeneRange) - mGeneRange/2);
        return gene;
    }
}
```

Our fitness function will evaluate solutions for their viability. Here we score **Chromosomes** based on the extent to which they satisfy our initial problem.

```Java
public class ZeroSumFitnessEvaluator implements FitnessEvaluator {

    private final int mDesiredProduct = 56;

    public float score(Chromosome chromosome) {

        int sum = 0;
        int product = 1;

        for(Gene g : chromosome) {
            int expression = ((SimpleGene) g).express();
            sum += expression;
            product *= expression;
        }

        return Math.abs(sum) + Math.abs(mDesiredProduct - product);
    }
}
```

Finally, we can put everything together. We will be using the provided strategies for chromosome creation, selection, crossover, and mutation.

```Java
 NumberGeneFactory geneFactory = new NumberGeneFactory();
 ChromosomeFactory chromosomeFactory = new StaticChromosomeFactoryImpl(geneFactory, mChromosomeSize);

 FitnessEvaluator fitnessEvaluator = new ZeroSumFitnessEvaluator();
 
 SelectionStrategy selectionStrategy = new RankSelectionImpl();
 CrossoverStrategy crossoverStrategy = new SingleLocusCrossoverImpl();
 MutationStrategy mutationStrategy = new StandardMutationRandomImpl(geneFactory);

 Engine engine = new Engine();
 engine.setChromosomeFactory(chromosomeFactory);
 engine.setFitnessEvaluator(fitnessEvaluator);
 engine.setSelectionStrategy(selectionStrategy);
 engine.setCrossoverStrategy(crossoverStrategy);
 engine.setMutationStrategy(mutationStrategy);

 engine.initPopulation(mPopulationSize);
 
 for(int i = 0; i < 1000; i++) {

    System.out.println(engine.getBest());
    engine.iterate();
}
```

### Interesting Solutions

Running the algorithm provides us with a number of interesting solutions.

```
[7, 1, 1, -1, -8]
[8, -1, -7]
[-7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -2, -2, -2]
```

Due to the nature of Genetic Algorithms, it is very simple to add arbitrary constraints that other algorithms could have trouble with. For example, we can easily look for solutions that don't contain the integer 1.

```
[-5, -4, 3]
[-4, -2, 7]
```

These solutions aren't perfect but have a high fitness.

## Provided

### ChromosomeFactory

1. **StaticChromosomeFactoryImpl** - Takes a **GeneFactory** implementation and an initial chromosome size. Populates chromosome using **GeneFactory**

### SelectionStrategy

1. **RankSelectionImpl** - Selects **Chromosome** with probability proportional to fitness ranking

### CrossoverStrategy

1. **SingleLocusCrossoverImpl** - Splits provided **Chromosomes** each with a single locus and performs swap

### MutationStrategy

1. **StandardMutationImpl** - Mutates each **Gene** in **Chromosome** with given probability. Needs to be subclassed to describe how to mutate a Gene
2. **StandardMutationRandomImpl** - Implementation of **StandardMutationImpl** that takes a **GeneFactory**. Defines mutation as replacement by new random **Gene**

## Todo

1. Implement parallelization 
2. Add more strategies
3. Add elitism

## References

<a href="http://www.boente.eti.br/fuzzy/ebook-fuzzy-mitchell.pdf">Melanie Mitchell - An Introduction to Genetic Algorithms</a>

<a href="http://www.doc.ic.ac.uk/~nd/surprise_96/journal/vol1/hmw/article1.html">Genetic Algorithms</a>

<a href="http://www.ai-junkie.com/ga/intro/gat1.html">Genetic Algorithsm in Plain English</a>
