package com.wayne.frame.util;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import java.io.File;

public class ZipUtils {

    /**
     * 默认编码格式
     */
    public final static String encoding = "GBK";

    public static void zip(String srcPathName, String zipFilePath) {
        zip(srcPathName, zipFilePath, encoding);
    }

    /**
     * 压缩
     *
     * @param srcPathName 压缩的文件路径
     * @param zipFilePath 压缩后的文件路径
     * @param encoding    编码格式
     */
    public static void zip(String srcPathName, String zipFilePath, String encoding) {
        File file = new File(srcPathName);
        if (!file.exists()) {
            throw new RuntimeException("source file or directory " + srcPathName + " does not exist.");
        }

        Project project = new Project();
        FileSet fileSet = new FileSet();
        fileSet.setProject(project);
        // 推断是文件夹还是文件
        if (file.isDirectory()) {
            fileSet.setDir(file);
            // ant中include/exclude规则在此都能够使用
            // 比方:
            // fileSet.setExcludes("**/*.txt");
            // fileSet.setIncludes("**/*.xls");
        } else {
            fileSet.setFile(file);
        }

        Zip zip = new Zip();
        zip.setProject(project);
        zip.setDestFile(new File(zipFilePath));
        zip.addFileset(fileSet);
        zip.setEncoding(encoding);
        zip.execute();
    }

    /**
     * 解压缩
     *
     * @param zipFilepath 待解压的文件路径
     * @param destDir     解压的文件放置路径
     */
    public static void unzip(String zipFilepath, String destDir) {
        if (!new File(zipFilepath).exists()) {
            throw new RuntimeException("zip file " + zipFilepath + " does not exist.");
        }

        Project project = new Project();
        Expand expand = new Expand();
        expand.setProject(project);
        expand.setTaskType("unzip");
        expand.setTaskName("unzip");
        expand.setEncoding(encoding);

        expand.setSrc(new File(zipFilepath));
        expand.setDest(new File(destDir));
        expand.execute();
    }
}
