import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import org.json.JSONObject;

public class MarkdownGenerator {

    static class BenchmarkResult {
        String language;
        long timeNs;
        double timeMs;
        double timeS;
        double percentSlower;

        BenchmarkResult(String language, long timeNs) {
            this.language = language;
            this.timeNs = timeNs;
            this.timeMs = timeNs / 1e6;
            this.timeS = timeNs / 1e9;
            this.percentSlower = 0.0;
        }
    }

    public static void main(String[] args) {
        String outputFile = "results_summary.md";

        try {
            // Read JSON files
            List<BenchmarkResult> results = Files.list(Paths.get(System.getProperty("user.dir")))
                    .filter(path -> path.toString().endsWith("_result.json"))
                    .map(MarkdownGenerator::parseResult)
                    .collect(Collectors.toList());

            // Sort by time (ascending)
            results.sort(Comparator.comparingLong(r -> r.timeNs));

            // Calculate percentage slower than the fastest
            long fastestTime = results.get(0).timeNs;
            for (BenchmarkResult result : results) {
                if (result.timeNs != fastestTime) {
                    result.percentSlower = ((double) (result.timeNs - fastestTime) / fastestTime) * 100;
                }
            }

            // Generate markdown file
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                writer.println("# Prime Counting Benchmark Results\n");
                writer.println("This file contains the results of running a prime-counting algorithm across various programming languages.\n");
                writer.println("**Benchmark Details:**");
                writer.println("- Problem size: Count primes up to 1,000,000.");
                writer.println("- Environment: GitHub-hosted Ubuntu runners.");
                writer.println("- Timings: Only the second run of the algorithm is measured for warm-up optimization.\n");

                writer.println("| Language   | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |");
                writer.println("|------------|-------------------|-------------------|-------------------|-----------------------|");

                for (BenchmarkResult result : results) {
                    writer.printf("| %-10s | %-17d | %-17.2f | %-17.4f | %-21.2f |\n",
                            result.language,
                            result.timeNs,
                            result.timeMs,
                            result.timeS,
                            result.percentSlower);
                }

                writer.println("\n**Summary:**");
                writer.printf("- Fastest language: %s with %.2f ms (%.4f s).\n",
                        results.get(0).language, results.get(0).timeMs, results.get(0).timeS);
                writer.printf("- Slowest language: %s with %.2f ms (%.4f s).\n",
                        results.get(results.size() - 1).language,
                        results.get(results.size() - 1).timeMs,
                        results.get(results.size() - 1).timeS);
            }

            System.out.println("Markdown file generated successfully: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BenchmarkResult parseResult(Path filePath) {
        try {
            String content = new String(Files.readAllBytes(filePath));
            JSONObject json = new JSONObject(content);
            String language = filePath.getFileName().toString().replace("_result.json", "");
            long timeNs = json.getLong("time_ns");
            return new BenchmarkResult(language, timeNs);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}