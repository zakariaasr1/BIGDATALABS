package edu.supmti.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class WriteHDFS {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: WriteHDFS <hdfs_path> <message>");
            System.exit(1);
        }
        String hdfsPath = args[0];
        String msg = args[1];

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path p = new Path(hdfsPath);

        if (!fs.exists(p)) {
            try (FSDataOutputStream out = fs.create(p)) {
                out.writeUTF(msg);
                System.out.println("Created: " + p);
            }
        } else {
            System.out.println("File already exists: " + p);
        }
        fs.close();
    }
}
