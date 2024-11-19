import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

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
        String resultsDir = System.getProperty("user.dir").getParentFile() + "/results"; // Directory containing result files
        String outputFile = "results_summary.md"; // Output file in the current working directory

        try {
            // Read result files
            List<BenchmarkResult> results = Files.list(new File(resultsDir).toPath())
                    .filter(path -> path.toString().endsWith("_result.json"))
                    .map(MarkdownGenerator::parseResult)
                    .collect(Collectors.toList());

            // Sort results by time (ascending order)
            results.sort(Comparator.comparingLong(r -> r.timeNs));

            // Calculate percentage slower than the fastest
            long fastestTime = results.get(0).timeNs;
            for (BenchmarkResult result : results) {
                if (result.timeNs != fastestTime) {
                    result.percentSlower = ((double) (result.timeNs - fastestTime) / fastestTime) * 100;
                }
            }

            // Generate the markdown file
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
            String content = new String(Files.readAllBytes(filePath)).trim();

            // Manually parse the JSON-like string
            String language = filePath.getFileName().toString().replace("_result.json", "");
            int timeIndex = content.indexOf("\"time_ns\":") + 10;
            long timeNs = Long.parseLong(content.substring(timeIndex).replaceAll("[^0-9]", ""));

            return new BenchmarkResult(language, timeNs);
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Error parsing result file: " + filePath, e);
        }
    }
}