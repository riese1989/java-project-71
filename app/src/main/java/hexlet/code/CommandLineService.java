package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        synopsisHeading = "%nUsage:"
)

public class CommandLineService implements Callable<Void> {

    @Parameters(index = "0", description = "path to first file", arity = "0..1", hideParamSyntax = true)
    private String filepath1;

    @Parameters(index = "1", description = "path to second file", arity = "0..1", hideParamSyntax = true)
    private String filepath2;

    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish",
            hideParamSyntax = true)
    private String format;

    @Option(names = {"-h", "--help"}, description = "Show this help message and exit.")
    private boolean helpFlag;

    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    private boolean versionFlag;

    @Override
    public Void call() throws Exception {
        if(helpFlag) {
            CommandLine.usage(this, System.out);
        }

        return null;
    }
}
