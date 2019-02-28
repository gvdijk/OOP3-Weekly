package week1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.DoubleStream;

public class A_30_15 {

    public static void main(String[] args) {
        Random random = new Random();
        final int size = 1000;
        double[] doubles = new double[size];
        for (int i = 0; i < size; i++) doubles[i] = random.nextInt(1000);
        System.out.println("\nActual sum is " + DoubleStream.of(doubles).sum());
        System.out.println("\nRecursive sum is " + parallelSum(doubles));
    }

    public static double parallelSum(double[] list) {
        RecursiveTask<Double> task = new SumTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class SumTask extends RecursiveTask<Double> {
        private final static int THRESHOLD = 50;
        private double[] list;
        private int low;
        private int high;

        public SumTask(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        public Double compute() {
            if (high - low < THRESHOLD) {
                double sum = 0;
                for (int i = low; i < high; i++) sum += list[i];
                return sum;
            } else {
                int middle = (low + high) / 2;
                RecursiveTask<Double> left = new SumTask(list, low, middle);
                RecursiveTask<Double> right = new SumTask(list, middle, high);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }
}
