package com.wow;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.tools.ExecFileLoader;
import org.jacoco.report.*;
import org.jacoco.report.html.HTMLFormatter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author arthur.hw
 * @date 2021/4/25
 */
public class JacocoUtils {

    private static List<File> classfiles;
    private static List<File> sourcefiles;
    private static List<File> execfiles;
    private static File xml;
    private static File csv;
    private static File html;
    private static int tabwidth = 4;
    private static String encoding;

    //java - jar./jacococli.jar report jacoco.exec
    // --classfiles /Users/arthur.hw/04_java/pallas-slave
    // --html /Users/arthur.hw/04_java/jacoco-0.8.3/report/html
    // --xml /Users/arthur.hw/04_java/jacoco-0.8.3/report/xml/xmlreport.xml
    // --csv /Users/arthur.hw/04_java/jacoco-0.8.3/report/csv/csvreport.csv
    // --sourcefiles /Users/arthur.hw/04_java/pallas-slave/bootstrap-service/src/main/java
    // --sourcefiles /Users/arthur.hw/04_java/pallas-slave/bootstrap-api/src/main/java
    // --sourcefiles /Users/arthur.hw/04_java/pallas-slave/bootstrap-start/src/main/java
    // --sourcefiles /Users/arthur.hw/04_java/pallas-slave/pallas-sdk/src/main/java
    public static void main(String[] args) throws Exception {
        // 解析exec的文件
        File execFile = new File("/Users/arthur.hw/04_java/jacoco-0.8.3/jacoco.exec");
        classfiles = Arrays.asList(new File("/Users/arthur.hw/04_java/pallas-slave"));
        sourcefiles = Arrays.asList(
                new File("/Users/arthur.hw/04_java/pallas-slave/bootstrap-service/src/main/java")
                , new File("/Users/arthur.hw/04_java/pallas-slave/bootstrap-api/src/main/java")
                , new File("/Users/arthur.hw/04_java/pallas-slave/bootstrap-start/src/main/java ")
                , new File("/Users/arthur.hw/04_java/pallas-slave/pallas-sdk/src/main/java"));
        execfiles = Arrays.asList(execFile);
        html = new File("/Users/arthur.hw/04_java/jacoco-0.8.3/report/html");

        final PrintWriter out = new PrintWriter(System.out, true);
        final PrintWriter err = new PrintWriter(System.err, true);

        // 加载exec
        ExecFileLoader loader = new ExecFileLoader();
        loader.load(execFile);

        // 分析覆盖率数据
        final IBundleCoverage bundle = analyze(loader.getExecutionDataStore(),
            out);

        // 生成报告
        writeReports(bundle, loader, out);

//        Report report = new Report();

//        Field execfilesField = Report.class.getDeclaredField("execfiles");
//        execfilesField.setAccessible(true);
//        execfilesField.set(report, execfiles);
//        execfilesField.setAccessible(false);
//        Field classfilesField = Report.class.getDeclaredField("classfiles");
//        classfilesField.setAccessible(true);
//        classfilesField.set(report, classfiles);
//        classfilesField.setAccessible(false);
//        Field sourcefilesField = Report.class.getDeclaredField("sourcefiles");
//        sourcefilesField.setAccessible(true);
//        sourcefilesField.set(report, sourcefiles);
//        sourcefilesField.setAccessible(false);
//        Field htmlField = Report.class.getDeclaredField("html");
//        htmlField.setAccessible(true);
//        htmlField.set(report,html);
//        htmlField.setAccessible(false);
//        Field nameField = Report.class.getDeclaredField("name");
//        nameField.setAccessible(true);
//        nameField.set(report,"pallas-slave Report");
//        nameField.setAccessible(false);

//        report.execute(out, err);

        System.out.println("main");
    }

    private static IBundleCoverage analyze(final ExecutionDataStore data, final PrintWriter out) throws Exception {
        final CoverageBuilder builder = new CoverageBuilder();
        final Analyzer analyzer = new Analyzer(data, builder);
        for (final File f : classfiles) {
            analyzer.analyzeAll(f);
        }
        //printNoMatchWarning(builder.getNoMatchClasses(), out);
        return builder.getBundle("testReport");
    }

    private static void writeReports(final IBundleCoverage bundle,
                                     final ExecFileLoader loader, final PrintWriter out)
        throws IOException {
        out.printf("[INFO] Analyzing %s classes.%n",
            Integer.valueOf(bundle.getClassCounter().getTotalCount()));
        final IReportVisitor visitor = createReportVisitor();
        visitor.visitInfo(loader.getSessionInfoStore().getInfos(),
            loader.getExecutionDataStore().getContents());
        visitor.visitBundle(bundle, getSourceLocator());
        visitor.visitEnd();
    }

    private static IReportVisitor createReportVisitor()
        throws IOException, IOException {
        final List<IReportVisitor> visitors = new ArrayList<IReportVisitor>();

        if (html != null) {
            final HTMLFormatter formatter = new HTMLFormatter();
            visitors.add(
                formatter.createVisitor(new FileMultiReportOutput(html)));
        }

        return new MultiReportVisitor(visitors);
    }

    private static ISourceFileLocator getSourceLocator() {
        final MultiSourceFileLocator multi = new MultiSourceFileLocator(
            tabwidth);
        for (final File f : sourcefiles) {
            multi.add(new DirectorySourceFileLocator(f, encoding, tabwidth));
        }
        return multi;
    }

}
