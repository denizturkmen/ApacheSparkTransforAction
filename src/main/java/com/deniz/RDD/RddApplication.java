package com.deniz.RDD;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RddApplication {
    public static void main(String[] args) {

        JavaSparkContext context = new JavaSparkContext("local","First Exam");
        //veriyi rdd göndermek
        JavaRDD<String> stringJavaRDD = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\names.txt");
        System.out.println(stringJavaRDD.count());
        System.out.println(stringJavaRDD.first());
    }
}
