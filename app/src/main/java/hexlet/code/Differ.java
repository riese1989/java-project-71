package hexlet.code;


import picocli.CommandLine.Option;

public class Differ {
    @Option(names = "-h")
    public static String generate() {
        System.out.println("Оляляля");
        return "";
    }
}
