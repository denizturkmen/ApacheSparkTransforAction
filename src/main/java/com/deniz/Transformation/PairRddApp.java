package com.deniz.Transformation;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

public class PairRddApp {
    public static void main(String[] args) {
        JavaSparkContext context = new JavaSparkContext("local", "MapFunct");
        JavaRDD<String> raw_data = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCups.csv");

        JavaRDD<CupModel> new_rdd = raw_data.map(new Function<String, CupModel>() {
            //line ilk satır rddd alır line parçala
            public CupModel call(String line) throws Exception {
                String[] split = line.split(",");
                return new CupModel(
                        split[0],
                        split[1],
                        split[2],
                        split[3],
                        split[4],
                        split[5],
                        Integer.parseInt(split[6]),
                        Integer.parseInt(split[7]),
                        Integer.parseInt(split[8]),
                        Double.parseDouble(split[6]));
            }
        });

        JavaPairRDD<String, String> firstPair = new_rdd.mapToPair(new PairFunction<CupModel, String, String>() {
            public Tuple2<String, String> call(CupModel cupModel) throws Exception {
                return new Tuple2<String, String>(cupModel.getBirinci(), String.valueOf(cupModel.getToplamkatilimci()));
            }
        });

        firstPair.foreach(new VoidFunction<Tuple2<String, String>>() {
            public void call(Tuple2<String, String> line) throws Exception {
                System.out.println(line._1+" "+line._2);
            }
        });

        //groublama

        JavaPairRDD<String, Iterable<String>> result_data = firstPair.groupByKey();
        result_data.foreach(new VoidFunction<Tuple2<String, Iterable<String>>>() {
            public void call(Tuple2<String, Iterable<String>> line) throws Exception {
                System.out.println(line._1+" "+line._2);
            }
        });

    }
}
