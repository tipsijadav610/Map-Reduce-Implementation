package lab02.http2;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;

public class Http2{

	public static void main(String[] args) throws Exception,IOException {
		Configuration conf = new Configuration();
		Job job=Job.getInstance(conf,"Map only job");
		
		job.setJarByClass(Http2.class);
		job.setMapperClass(Http2Mapper.class);
		job.setNumReduceTasks(0);
		
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		Path outpath=new Path(args[1]);
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,outpath);
		
		outpath.getFileSystem(conf).delete(outpath,true);
		System.exit(job.waitForCompletion(true)?0:1);
	}
}
