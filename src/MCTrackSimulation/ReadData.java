package MCTrackSimulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class ReadData {

    public static String[] arraylist;
    public static Path path;
    public static List<Double> myEnergyList = new ArrayList();
    public static List<Double> myTotalList = new ArrayList();
    public static List<Double> myElasticList = new ArrayList();
    public static List<Double> myAbsorptionList = new ArrayList();

    public static void ReadData() throws FileNotFoundException, IOException {
        myEnergyList.clear();
        myTotalList.clear();
        myElasticList.clear();
        myAbsorptionList.clear();
        Integer ZAID1 = MonteCarloScatterPlot.ZAID[MonteCarloScatterPlot.Isotope_index];
        String FileName = "data/" + ZAID1 + ".csv";// read data frm csv files for all isotopes
        FileInputStream f;
        //       f = new FileInputStream(new File(ReadData.class.getProtectionDomain().getCodeSource().getLocation().getPath() + FileName));
        f = new FileInputStream(new File(FileName));
        System.out.println(FileName + "   " + (MonteCarloScatterPlot.Isotope_coef[MonteCarloScatterPlot.Isotope_index] * 100.0) + " %");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(f));
            String strline;
            while ((strline = br.readLine()) != null) {
                arraylist = StringUtils.split(strline, ";");
                Double x = Double.parseDouble(arraylist[0]);
                Double y = Double.parseDouble(arraylist[1]);
                Double z = Double.parseDouble(arraylist[2]);
                Double w = Double.parseDouble(arraylist[3]);
                myEnergyList.add(x);
                myTotalList.add(y);
                myElasticList.add(z);
                myAbsorptionList.add(w);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }    }
}
