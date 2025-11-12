package edu.supmti.hadoop;

import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class ReadHDFS {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: ReadHDFS <hdfs_path>");
            System.exit(1);
        }
        String path = args[0];

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        try (FSDataInputStream in = fs.open(new Path(path));
             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        fs.close();
    }
}
