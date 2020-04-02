package com.deniz.Action;

import com.deniz.Transformation.CupModel;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.List;

public class ActionApp {
    public static void main(String[] args) {

        JavaSparkContext context = new JavaSparkContext("local", "MapFunct");
        JavaRDD<String> raw_data = context.textFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\WorldCups.csv");

        System.out.println("Toplam Data:"+raw_data.count());
        System.out.println("Ilk Data: "+raw_data.first());

        final List<String> collect = raw_data.collect();
        for (String a:collect){
            System.out.println(a);
        }

        List<String> take1 = raw_data.take(5);
        for (String a:take1){
            System.out.println(a);
        }

        List<String> sample = raw_data.takeSample(false, 3);
        for(String smp:sample){
            System.out.println(smp);
        }

        JavaRDD<CupModel> new_rdd1 = raw_data.map(new Function<String, CupModel>() {
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

        JavaRDD<CupModel> toplamgol = new_rdd1.filter(new Function<CupModel, Boolean>() {
            public Boolean call(CupModel cupModel) throws Exception {
                return cupModel.getToplamgol() < 120;
            }
        });
        System.out.println(toplamgol.count());

        JavaRDD<String> result = toplamgol.map(new Function<CupModel, String>() {
            public String call(CupModel cupModel) throws Exception {
                return cupModel.getYil() + " " + cupModel.getToplamgol();
            }
        });
        result.saveAsObjectFile("C:\\Users\\turkm\\IdeaProjects\\ApacheSpark\\A");
    }
}
