package com.deniz.Transformation;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class DistinctApp {
    public static void main(String[] args) {
        JavaSparkContext context = new JavaSparkContext("local","MapFunct");
        JavaRDD<String> raw_data = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCups.csv");

        System.out.println("Tum Kayitlar :"+raw_data.count());

        JavaRDD<String> distinct = raw_data.distinct();
        System.out.println("Distinct "+distinct.count());


    }
}
