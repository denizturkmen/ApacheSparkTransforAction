package com.deniz.Transformation;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

public class MapApp {
    public static void main(String[] args) {

        JavaSparkContext context = new JavaSparkContext("local","MapFunct");
        JavaRDD<String> raw_data = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCups.csv");

        //System.out.println(raw_data.count());
        //string modeli java objesine çevirmek için
        //ilk gelen değer string satır mapten dönen değer ise obje olacak

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

        new_rdd.foreach(new VoidFunction<CupModel>() {
            public void call(CupModel cupModel) throws Exception {
                System.out.println(cupModel.toplamkatilimci);
            }
        });
    }

}
