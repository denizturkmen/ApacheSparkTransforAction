package com.deniz.Transformation;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.Arrays;
import java.util.Iterator;

public class FlatMapApp {
    public static void main(String[] args) {

        JavaSparkContext context = new JavaSparkContext("local","MapFunct");
        JavaRDD<String> raw_data = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCups.csv");

        //System.out.println(raw_data.count());
        //string modeli java objesine çevirmek için
        //ilk gelen değer string satır mapten dönen değer ise obje olacak

        JavaRDD<String> flatmapRdd = raw_data.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(",")).iterator();
            }
        });

        flatmapRdd.foreach(new VoidFunction<String>() {
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });

    }
}
