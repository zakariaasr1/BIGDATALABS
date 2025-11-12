package edu.supmti.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.BlockLocation;
import java.io.IOException;

public class HadoopFileStatus {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        String dir     = args.length > 0 ? args[0] : "/user/root/input";
        String oldName = args.length > 1 ? args[1] : "purchases.txt";
        String newName = args.length > 2 ? args[2] : "achats.txt";

        Path filePath = new Path(dir, oldName);

        if (!fs.exists(filePath)) {
            System.out.println("File does not exist: " + filePath);
            fs.close();
            return;
        }

        FileStatus st = fs.getFileStatus(filePath);
        System.out.println("File Name     : " + st.getPath().getName());
        System.out.println("Size (bytes)  : " + st.getLen());
        System.out.println("Owner         : " + st.getOwner());
        System.out.println("Permission    : " + st.getPermission());
        System.out.println("Replication   : " + st.getReplication());
        System.out.println("Block Size    : " + st.getBlockSize());

        BlockLocation[] blks = fs.getFileBlockLocations(st, 0, st.getLen());
        for (BlockLocation b : blks) {
            System.out.println("Block offset=" + b.getOffset() + ", length=" + b.getLength());
            System.out.print("Hosts: ");
            for (String h : b.getHosts()) System.out.print(h + " ");
            System.out.println();
        }

        boolean renamed = fs.rename(filePath, new Path(dir, newName));
        System.out.println(renamed ? "Rename done successfully!" : "Rename failed!");

        fs.close();
    }
}
