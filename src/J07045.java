import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }

    private static class LoaiPhong implements Comparable<LoaiPhong>{
        private String code;
        private String name;
        private int dailyRate;
        private double serviceRate;

        public LoaiPhong(String data) {
            String[] frags = data.split("\\s+");
            if (frags.length != 4) {
                throw new RuntimeException();
            }
            this.code = frags[0];
            this.name = frags[1];
            this.dailyRate = Integer.parseInt(frags[2]);
            this.serviceRate = Double.parseDouble(frags[3]);
        }

        @Override
        public String toString() {
            return code + " " + name + " " + dailyRate + " " + serviceRate;
        }

        @Override
        public int compareTo(LoaiPhong o) {
            return name.compareTo(o.name);
        }
    }
}
