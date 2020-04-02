package com.deniz.Transformation;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class UnionApp {
    public static void main(String[] args) {
        JavaSparkContext context = new JavaSparkContext("local", "MapFunct");

        JavaRDD<String> raw_data1 = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCups.csv");
        JavaRDD<String> raw_data2 = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCupPlayers.csv");
        System.out.println("1 Rdd :" +raw_data1.count());
        System.out.println("2 Rdd :" +raw_data2.count());


        JavaRDD<String> result_rdd = raw_data1.union(raw_data2);
        System.out.println("3 Rdd :" +result_rdd.count());



    }
}
